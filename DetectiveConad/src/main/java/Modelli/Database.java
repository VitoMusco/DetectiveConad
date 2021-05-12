/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelli;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miki_
 */
public class Database {

    public static final String CREA_OGGETTI = "CREATE TABLE IF NOT EXISTS oggetti (nome VARCHAR(25), articolo VARCHAR(5), stanza VARCHAR(20));";
    public static final String CONTROLLO_OGGETTI = "SELECT * FROM oggetti";

    public Database() {
    }

    public void inizializzaDatabase() {
        try {
            Connection connessione = this.connessioneDb();
            if (connessione != null) {
                Statement stm = connessione.createStatement();
                ResultSet risultato = stm.executeQuery(CONTROLLO_OGGETTI);
                boolean vuoto=true;
                while(risultato.next()){
                    vuoto=false;
                }
                if(vuoto == true){
                stm = connessione.createStatement();
                stm.executeUpdate(CREA_OGGETTI);
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("INSERT INTO oggetti VALUES('pila', 'una', 'camioncino')");
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("INSERT INTO oggetti VALUES('torcia', 'una', 'camioncino')");
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("INSERT INTO oggetti VALUES('guanti', 'dei', 'camioncino')");
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("INSERT INTO oggetti VALUES('coltello', 'un', 'salumeria')");
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("INSERT INTO oggetti VALUES('mappa', 'una', 'ingresso')");
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("INSERT INTO oggetti VALUES('monetina', 'una', 'studio')");
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("INSERT INTO oggetti VALUES('impronta', 'una', 'studio')");
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("INSERT INTO oggetti VALUES('impronta', 'una', 'salumeria')");
                stm.close();
                stm = connessione.createStatement();
                stm.executeUpdate("INSERT INTO oggetti VALUES('impronta', 'una', 'cella frigorifera')");
                stm.close();                
                }
                connessione.close();
            }
        } catch (SQLException ex) {
            System.err.println("Errore");
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
