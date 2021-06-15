package Client.Entity;

import java.util.*;

public class Stanza {

    private final String MESSAGGIO_ERRORE_DIREZIONE = "Non posso andare in quella direzione!";

    private Stanza nord;
    private Stanza sud;
    private Stanza est;
    private Stanza ovest;
    private String nome;
    private String descrizione;
    private int numOsservazioni;
    private int maxOsservazioni;

    public Stanza(String nome, String desc, int maxOss) {
        this.nord = null;
        this.sud = null;
        this.est = null;
        this.ovest = null;
        this.nome = nome;
        this.descrizione = desc;
        this.numOsservazioni = 0;
        this.maxOsservazioni = maxOss;
    }

    public Stanza(Stanza n, Stanza s, Stanza e, Stanza o, String nome, String desc, int maxOss) {
        this.nord = n;
        this.sud = s;
        this.est = e;
        this.ovest = o;
        this.nome = nome;
        this.descrizione = desc;
        this.numOsservazioni = 0;
        this.maxOsservazioni = maxOss;
    }

    public void assegnaNord(Stanza s) {
        this.nord = s;
    }

    public void assegnaSud(Stanza s) {
        this.sud = s;
    }

    public void assegnaEst(Stanza s) {
        this.est = s;
    }

    public void assegnaOvest(Stanza s) {
        this.ovest = s;
    }

    public Stanza vaiNord() {
        if (this.nord != null) {
            return this.nord;
        } else {
            return null;
        }
    }

    public Stanza vaiSud() {
        if (this.sud != null) {
            return this.sud;
        } else {
            return null;
        }
    }

    public Stanza vaiEst() {
        if (this.est != null) {
            return this.est;
        } else {
            return null;
        }
    }

    public Stanza vaiOvest() {
        if (this.ovest != null) {
            return this.ovest;
        } else {
            return null;
        }
    }

    public String getMessaggioErroreDirezione() {
        return MESSAGGIO_ERRORE_DIREZIONE;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public String getNome() {
        return this.nome;
    }
    
    public int getNumOsservazioni(){
        return this.numOsservazioni;
    }
    
    public int getMaxOsservazioni(){
        return this.maxOsservazioni;
    }
    
    public void incrementaNumOsservazioni(){
        this.numOsservazioni++;
    }
}
