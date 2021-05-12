package Modelli;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    public static final String CREA_OGGETTI = "CREATE TABLE IF NOT EXISTS oggetti (id_oggetto INT AUTO_INCREMENT, nome VARCHAR(25), articolo VARCHAR(5), stanza VARCHAR(20), id_partita INT, PRIMARY KEY(id_oggetto), FOREIGN KEY(id_partita) REFERENCES partita(id_partita));";
    public static final String CREA_PARTITA = "CREATE TABLE IF NOT EXISTS partita (id_partita INT AUTO_INCREMENT, nome_salvataggio VARCHAR(25), PRIMARY KEY(id_partita));";

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
                connessione.close();
            }
        } catch (SQLException ex) {
            System.err.println("Errore");
        }
    }

    public void inserisciPartita(String nome_partita) {    
        int id_partita = 0;
        Connection connessione = connessioneDb();
        if (connessione != null) {
            try {
                Statement stm = connessione.createStatement() ;
                ResultSet risultato = stm.executeQuery("SELECT id_partita FROM partita WHERE nome_salvataggio = '" + nome_partita + "'");
                while (risultato.next()) {
                    System.out.println("Nome partita utilizzato");
                    return;
                }
                stm.close();
                stm = connessione.createStatement() ;
                stm.executeUpdate("INSERT INTO partita (nome_salvataggio) VALUES('" + nome_partita+ "')");
                stm.close();
                stm = connessione.createStatement() ;
                risultato = stm.executeQuery("SELECT id_partita FROM partita WHERE nome_salvataggio = '" + nome_partita + "'");
                while (risultato.next()) {
                    id_partita = risultato.getInt(1);
                }
                risultato.close();
                stm.close();
                inserisciOggetti(id_partita);
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void inserisciOggetti(int id_partita) {
        Statement stm;
        Connection connessione = connessioneDb();
        if (connessione != null) {

            try {
                stm = connessione.createStatement();
                ResultSet risultato;
                risultato = stm.executeQuery("SELECT * FROM oggetti WHERE id_partita = '"+id_partita+"'");
                while (risultato.next()) {
                    System.out.println("Oggetti gia inseriti");
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
                stm = connessione.createStatement();
                stm.executeUpdate("INSERT INTO oggetti(nome, articolo, stanza, id_partita) VALUES('pila', 'una', 'camioncino','" + id_partita + "')");
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("INSERT INTO oggetti(nome, articolo, stanza, id_partita) VALUES('torcia', 'una', 'camioncino','" + id_partita + "')");
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("INSERT INTO oggetti(nome, articolo, stanza, id_partita) VALUES('guanti', 'dei', 'camioncino','" + id_partita + "')");
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("INSERT INTO oggetti(nome, articolo, stanza, id_partita) VALUES('coltello', 'un', 'salumeria','" + id_partita + "')");
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("INSERT INTO oggetti(nome, articolo, stanza, id_partita) VALUES('mappa', 'una', 'ingresso','" + id_partita + "')");
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("INSERT INTO oggetti(nome, articolo, stanza, id_partita) VALUES('monetina', 'una', 'studio','" + id_partita + "')");
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("INSERT INTO oggetti(nome, articolo, stanza, id_partita) VALUES('impronta', 'una', 'studio','" + id_partita + "')");
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("INSERT INTO oggetti(nome, articolo, stanza, id_partita) VALUES('impronta', 'una', 'salumeria','" + id_partita + "')");
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("INSERT INTO oggetti(nome, articolo, stanza, id_partita) VALUES('impronta', 'una', 'cella frigorifera','" + id_partita + "')");
                stm.close();
                connessione.close();
            } catch (SQLException ex) {
                System.err.println("Errore");
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
}
