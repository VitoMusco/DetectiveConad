package Client.Control;

import Client.Entity.OggettoNonRaccoglibile;
import Client.Entity.Azione;
import Client.Entity.Stanza;
import Client.Entity.Inventario;
import Client.Entity.Oggetto;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private static final String CREA_OGGETTI = "CREATE TABLE IF NOT EXISTS oggetti (id_oggetto SMALLINT AUTO_INCREMENT, nome VARCHAR(25), stanza VARCHAR(20), id_partita SMALLINT, raccoglibile BIT, PRIMARY KEY(id_oggetto), FOREIGN KEY(id_partita) REFERENCES partita(id_partita));";
    private static final String CREA_PARTITA = "CREATE TABLE IF NOT EXISTS partita (id_partita SMALLINT, nome_salvataggio VARCHAR(25), stanza_corrente VARCHAR(20), PRIMARY KEY(id_partita));";
    private static final String CREA_AZIONI = "CREATE TABLE IF NOT EXISTS azioni (id_partita SMALLINT, azione VARCHAR(25), PRIMARY KEY(id_partita, azione));";

    public Database() {
    }

    public void inizializzaDatabase() {
        try {
            Connection connessione = connessioneDb();
            if (connessione != null) {
                Statement stm = connessione.createStatement();
                stm.executeUpdate(CREA_PARTITA);
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate(CREA_OGGETTI);
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate(CREA_AZIONI);
                stm.close();
                connessione.close();
            }
        } catch (SQLException ex) {
            System.err.println("Errore");
        }
    }

    public void inserisciPartita(String nome_partita,int id_partita) {
        Connection connessione = connessioneDb();
        if (connessione != null) {
            try {
                Statement stm = connessione.createStatement();
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("INSERT INTO partita (id_partita, nome_salvataggio, stanza_corrente) VALUES('" + id_partita + "','" + nome_partita + "', 'esterno')");
                stm.close();
                stm = connessione.createStatement();             
                connessione.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void inserisciOggetti(int id_partita, Map<Oggetto, String> o) {
        Statement stm;
        Connection connessione = connessioneDb();
        if (connessione != null) {
            try {
                stm = connessione.createStatement();
                ResultSet risultato;
                risultato = stm.executeQuery("SELECT * FROM oggetti WHERE id_partita = '" + id_partita + "'");
                while (risultato.next()) {
                    //System.out.println("Oggetti gia inseriti");
                    return;
                }
                risultato.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                stm = connessione.createStatement();
                stm.executeUpdate(CREA_OGGETTI);
                stm.close();
                for (Map.Entry<Oggetto, String> e : o.entrySet()) {
                    stm = connessione.createStatement();
                    stm.executeUpdate("INSERT INTO oggetti(nome, stanza, id_partita, raccoglibile) VALUES('" + e.getKey().getNome() + "', '" + e.getValue() + "','" + id_partita + "', '" + e.getKey().isRaccoglibile() + "')");
                    stm.close();
                }
                connessione.close();
            } catch (SQLException ex) {
                System.err.println("Errore nell'inserimento degli oggetti nel database");
            }
        }
    }

    public Connection connessioneDb() {
        Properties proprieta = new Properties();
        proprieta.setProperty("user", "user");
        proprieta.setProperty("password", "1234");
        try {
            Connection connessione = DriverManager.getConnection("jdbc:h2:./risorse/db/teamballo", proprieta);
            return connessione;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public String nomePartita(int id_partita) {
        String partita = "";
        Statement stm;
        Connection connessione = connessioneDb();
        if (connessione != null) {
            try {
                stm = connessione.createStatement();
                ResultSet risultato;
                risultato = stm.executeQuery("SELECT nome_salvataggio FROM partita WHERE id_partita = '" + id_partita + "'");
                while (risultato.next()) {
                    partita = risultato.getString(1);
                }
                risultato.close();
                stm.close();
                connessione.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return partita;
    }

    public boolean[] getPartiteSalvate() {
        boolean[] id_partite = new boolean[4];
        int i = 0;
        Statement stm;
        Connection connessione = connessioneDb();
        if (connessione != null) {
            try {
                stm = connessione.createStatement();
                ResultSet risultato;
                risultato = stm.executeQuery("SELECT id_partita FROM partita");
                while (risultato.next()) {
                    id_partite[risultato.getInt(1)-1] = true;
                    i++;
                }
                risultato.close();
                stm.close();
                connessione.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id_partite;
    }

    public void salvaPartita(Stanza corrente, Inventario inventario, int id_partita, AzioniEseguite azioni) {
        Statement stm;
        Connection connessione = connessioneDb();
        AzioniEseguite azioniGiaPresenti = caricaAzioniEseguite(id_partita);
        if (connessione != null) {
            try {
                stm = connessione.createStatement();
                stm.executeUpdate("UPDATE partita SET stanza_corrente = '" + corrente.getNome() + "' WHERE id_partita = '" + id_partita + "';");
                stm.close();
                ListIterator<Oggetto> lit = inventario.getInventario().listIterator();
                while (lit.hasNext()) {
                    stm = connessione.createStatement();
                    stm.executeUpdate("UPDATE oggetti SET stanza = 'inventario' WHERE id_partita = '" + id_partita + "' AND nome='" + lit.next().getNome() + "';");
                    stm.close();
                }
                ListIterator<Azione> azione = azioni.getAzioni().listIterator();
                while (azione.hasNext()) {
                    ListIterator<Azione> azioneGiaPresente = azioniGiaPresenti.getAzioni().listIterator();
                    boolean possoCaricare = true;
                    Azione azioneDaCaricare = azione.next();
                    while (azioneGiaPresente.hasNext()) {
                        if (azioneGiaPresente.next().name().equals(azioneDaCaricare.name())) {
                            possoCaricare = false;
                        }
                    }
                    if(possoCaricare){
                        stm = connessione.createStatement();
                        stm.executeUpdate("INSERT INTO azioni VALUES ('" + id_partita + "', '" + azioneDaCaricare.name() + "');");
                        stm.close();
                    }
                }
                connessione.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Inventario caricaInventario(int idPartita) {
        Statement stm;
        Inventario inventario = new Inventario();
        Oggetto appoggio;
        Connection connessione = connessioneDb();
        if (connessione != null) {
            try {
                stm = connessione.createStatement();
                ResultSet risultato;
                risultato = stm.executeQuery("SELECT nome, raccoglibile FROM oggetti WHERE stanza='inventario' AND id_partita='" + idPartita + "'");
                while (risultato.next()) {
                    if(risultato.getBoolean(2)){
                        appoggio = new Oggetto(risultato.getString(1));
                    } else{
                        appoggio = new OggettoNonRaccoglibile(risultato.getString(1));
                    }
                    inventario.getInventario().add(appoggio);
                }
                risultato.close();
                connessione.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return inventario;
    }

    public Map<Oggetto, String> caricaOggetti(int idPartita) {
        Statement stm;
        Map<Oggetto, String> oggetti = new HashMap<>();
        Oggetto appoggio;
        Connection connessione = connessioneDb();
        if (connessione != null) {
            try {
                stm = connessione.createStatement();
                ResultSet risultato;
                risultato = stm.executeQuery("SELECT nome, stanza, raccoglibile FROM oggetti WHERE stanza<>'inventario' AND id_partita='" + idPartita + "'");
                while (risultato.next()) {
                    if(risultato.getBoolean(3)){
                        appoggio = new Oggetto(risultato.getString(1));
                    } else{
                        appoggio = new OggettoNonRaccoglibile(risultato.getString(1));
                    }
                    oggetti.put(appoggio, risultato.getString(2));
                }
                risultato.close();
                connessione.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return oggetti;
    }

    public AzioniEseguite caricaAzioniEseguite(int id_partita) {
        Statement stm;
        AzioniEseguite azioni = new AzioniEseguite();
        Connection connessione = connessioneDb();
        if (connessione != null) {
            try {
                stm = connessione.createStatement();
                ResultSet risultato;
                risultato = stm.executeQuery("SELECT azione FROM azioni WHERE id_partita = '" + id_partita + "'");
                while (risultato.next()) {
                    azioni.inserisciAzione(risultato.getString(1));
                }
                risultato.close();
                connessione.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return azioni;
    }

    public String caricaStanzaCorrente(int id_partita) {
        Statement stm;
        String stanza_corrente = "";
        Connection connessione = connessioneDb();
        if (connessione != null) {
            try {
                stm = connessione.createStatement();
                ResultSet risultato;
                risultato = stm.executeQuery("SELECT stanza_corrente FROM partita WHERE id_partita = '" + id_partita + "'");
                while (risultato.next()) {
                    stanza_corrente = risultato.getString(1);
                }
                risultato.close();
                connessione.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return stanza_corrente;
    }
    
    public void cancellaPartita(int id_partita) {
        Statement stm;
        Connection connessione = connessioneDb();
        if (connessione != null) {
            try {
                stm = connessione.createStatement();
                stm.executeUpdate("DELETE FROM oggetti WHERE id_partita = '" + id_partita + "';");
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("DELETE FROM azioni WHERE id_partita = '" + id_partita + "';");
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("DELETE FROM partita WHERE id_partita = '" + id_partita + "';");
                stm.close();
                connessione.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
