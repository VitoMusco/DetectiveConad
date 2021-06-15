package Entity;

import java.util.*;

public class Oggetto {

    private String nome, articolo;

    public Oggetto(String a, String n) {
        this.nome = n;
        this.articolo = a;
    }

    public String osservaOggetto() {
        return this.articolo + " " + this.nome;
    }

    public String getNome() {
        return this.nome;
    }

    public String getArticolo() {
        return this.articolo;
    }

    public boolean isRaccoglibile() {
        if (this instanceof OggettoNonRaccoglibile) {
            return false;
        } else {
            return true;
        }
    }

}
