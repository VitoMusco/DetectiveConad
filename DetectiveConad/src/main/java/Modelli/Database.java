package Modelli;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    public static final String CREA_OGGETTI = "CREATE TABLE IF NOT EXISTS oggetti (id_oggetto SMALLINT AUTO_INCREMENT, nome VARCHAR(25), articolo VARCHAR(5), stanza VARCHAR(20), id_partita SMALLINT, raccoglibile BIT, PRIMARY KEY(id_oggetto), FOREIGN KEY(id_partita) REFERENCES partita(id_partita));";
    public static final String CREA_PARTITA = "CREATE TABLE IF NOT EXISTS partita (id_partita SMALLINT AUTO_INCREMENT, nome_salvataggio VARCHAR(25), stanza_corrente VARCHAR(20), PRIMARY KEY(id_partita));";
    public static final String CREA_AZIONI = "CREATE TABLE IF NOT EXISTS azioni (id_partita SMALLINT, azione VARCHAR(25), PRIMARY KEY(id_partita, azione));";

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

    public int inserisciPartita(String nome_partita) {
        int id_partita = 0;
        Connection connessione = connessioneDb();
        if (connessione != null) {
            try {
                Statement stm = connessione.createStatement();
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("INSERT INTO partita (nome_salvataggio, stanza_corrente) VALUES('" + nome_partita + "', 'esterno')");
                stm.close();
                stm = connessione.createStatement();
                ResultSet risultato = stm.executeQuery("SELECT id_partita FROM partita WHERE nome_salvataggio = '" + nome_partita + "'");
                while (risultato.next()) {
                    id_partita = risultato.getInt(1);
                }
                risultato.close();
                stm.close();
                return id_partita;
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
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
                    stm.executeUpdate("INSERT INTO oggetti(nome, articolo, stanza, id_partita, raccoglibile) VALUES('" + e.getKey().getNome() + "', '" + e.getKey().getArticolo() + "', '" + e.getValue() + "','" + id_partita + "', '" + e.getKey().isRaccoglibile() + "')");
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

    /*public void controlloNomeSalvataggio() {
        boolean controllo = false;
        String nome_partita;
        for (int i = 1; i < 5; i++) {
            nome_partita = nomePartita(i);
            if (nome_partita.equals("")) {
                controllo = true;
                break;
            }
        }
        if (controllo == true) {
            System.out.println("C'e' uno slot di salvataggio disponibile"); //esempio
        }
    }*/
    public int[] idPartita() {
        int[] id_partite = new int[4];
        int i = 0;
        Statement stm;
        Connection connessione = connessioneDb();
        if (connessione != null) {
            try {
                stm = connessione.createStatement();
                ResultSet risultato;
                risultato = stm.executeQuery("SELECT id_partita FROM partita");
                while (risultato.next()) {
                    id_partite[i] = risultato.getInt(1);
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

    public boolean[] controlloIdPartite() {
        boolean[] presenza_Id = new boolean[4];
        int[] id_partite = idPartita();
        for (int i = 0; i < 4; i++) {
            if (id_partite[i] != 0) {
                presenza_Id[i] = true;
            } else {
                presenza_Id[i] = false;
            }
        }
        return presenza_Id;
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
                ListIterator<Azione> azioneGiaPresente = azioniGiaPresenti.getAzioni().listIterator();
                while (azione.hasNext()) {
                    Azione azioneDaCaricare = azione.next();
                    while (azioneGiaPresente.hasNext()) {
                        if (azioneGiaPresente.next().name().equals(azioneDaCaricare.name())) {
                            if (azione.hasNext()) {
                                azioneDaCaricare = azione.next();
                            } else {
                                return;
                            }
                        }
                    }
                    stm = connessione.createStatement();
                    stm.executeUpdate("INSERT INTO azioni VALUES ('" + id_partita + "', '" + azioneDaCaricare.name() + "');");
                    stm.close();
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
                risultato = stm.executeQuery("SELECT articolo, nome FROM oggetti WHERE stanza='inventario' AND id_partita='" + idPartita + "'");
                while (risultato.next()) {
                    appoggio = new Oggetto(risultato.getString(1), risultato.getString(2));
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
                risultato = stm.executeQuery("SELECT articolo, nome, stanza FROM oggetti WHERE stanza<>'inventario' AND id_partita='" + idPartita + "'");
                while (risultato.next()) {
                    appoggio = new Oggetto(risultato.getString(1),risultato.getString(2));
                    oggetti.put(appoggio, risultato.getString(3));
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
}
