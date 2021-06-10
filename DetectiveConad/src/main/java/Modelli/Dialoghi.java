
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
    private Map<String, String> testi; 
    
    public Dialoghi() {
        this.testi = new HashMap<>(); 
    }
    
    public Map<String, String> getTesti(){
        return this.testi;
    }
    
    public void prelevaTesti() {
        Scanner scanner = null;
        File file = new File("./risorse/dialoghi/dialoghi.txt");
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
