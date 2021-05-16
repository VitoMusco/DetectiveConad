/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelli;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dialoghi {
    Map<String, String> testi; 
    public Dialoghi() {
        this.testi = new HashMap<>(); 
    }
    public void prelevaTesti() {
        Scanner scanner = null;
        File file = new File("C:/Users/miki_/Desktop/Testi/testi.txt");
        String frase = null, chiave = null;
        String[] parti = new String[2];
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(file)));
            while (scanner.hasNextLine()) {
                parti = scanner.nextLine().split("#");
                chiave = parti[0];
                frase = parti[1];
                this.testi.put(chiave, frase);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dialoghi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
