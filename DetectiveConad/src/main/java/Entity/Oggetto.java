package Entity;

import java.util.*;

public class Oggetto {

    private String nome;

    public Oggetto(String n) {
        this.nome = n;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean isRaccoglibile() {
        if (this instanceof OggettoNonRaccoglibile) {
            return false;
        } else {
            return true;
        }
    }

}
