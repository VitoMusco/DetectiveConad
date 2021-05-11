/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelli;

import java.sql.*;
import java.util.*;

/**
 *
 * @author miki_
 */
public class Database {

    public static final String CREA_OGGETTI = "CREATE TABLE IF NOT EXISTS oggetti (nome VARCHAR(25), articolo VARCHAR(5), stanza VARCHAR(20));";

    public Database() {
        try {
            Properties dbprops = new Properties();
            dbprops.setProperty("user", "user");
            dbprops.setProperty("password", "1234");
            Connection conn = DriverManager.getConnection("jdbc:h2:./risorse/db/teamballo", dbprops);
            Statement stm = conn.createStatement();
            stm.executeUpdate(CREA_OGGETTI);
            stm.close();
            stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO oggetti VALUES('pila', 'una', 'camioncino')");
            stm.close();
            stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO oggetti VALUES('torcia', 'una', 'camioncino')");
            stm.close();
            stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO oggetti VALUES('guanti', 'dei', 'camioncino')");
            stm.close();
            stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO oggetti VALUES('coltello', 'un', 'salumeria')");
            stm.close();
            stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO oggetti VALUES('mappa', 'una', 'ingresso')");
            stm.close();
            stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO oggetti VALUES('monetina', 'una', 'studio')");
            stm.close();
            stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO oggetti VALUES('impronta', 'una', 'studio')");
            stm.close();
            stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO oggetti VALUES('impronta', 'una', 'salumeria')");
            stm.close();
            stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO oggetti VALUES('impronta', 'una', 'cella frigorifera')");
            stm.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Errore");
        }
    }
}
