package Modelli;

import java.util.*;

public class Stanza {
    private Stanza nord;
    private Stanza sud;
    private Stanza est;
    private Stanza ovest;
    private List<Oggetto> oggetti;
    private Map<String,Impiegato> impiegati;
    private String nome;
    private String descrizione;
    
    public Stanza(String nome,String desc){
        this.nord = null;
        this.sud = null;
        this.est = null;
        this.ovest = null;
        this.oggetti = new ArrayList<>();
        this.impiegati = new HashMap<>();
        this.nome = nome;
        this.descrizione = desc;
    }
    
    public Stanza(Stanza n,Stanza s,Stanza e,Stanza o,String nome,String desc){
        this.nord = n;
        this.sud = s;
        this.est = e;
        this.ovest = o;
        this.oggetti = new ArrayList<>();
        this.nome = nome;
        this.descrizione = desc;
    }
    
    public void inserisciOggetto(Oggetto o){
        oggetti.add(o);
    }
    
    public void inserisciImpiegato(Impiegato impiegato){
        this.impiegati.put(impiegato.getNome(),impiegato);
    }
    
    public void osservaStanza(){
        for(Oggetto o:this.oggetti){
            System.out.println("Vedo "+o.osservaOggetto());
        }
        for(String nome:this.impiegati.keySet()){
            System.out.println("Vedo "+nome);
        }
    }
    
    public void interrogaImpiegati(){
        for(Map.Entry<String,Impiegato> e:impiegati.entrySet()){
            System.out.println(e.getValue().getNome()+": "+e.getValue().interroga());
        }
    }
    
    public void assegnaNord(Stanza s){
        this.nord = s;
    }
    
    public void assegnaSud(Stanza s){
        this.sud = s;
    }
    
    public void assegnaEst(Stanza s){
        this.est = s;
    }
    
    public void assegnaOvest(Stanza s){
        this.ovest = s;
    }
    
    public Stanza vaiNord(){
        if(this.nord != null){
            return this.nord;
        }
        else{
            return null;
        }
    }
    
    public Stanza vaiSud(){
        if(this.sud != null){
            return this.sud;
        }
        else{
            return null;
        }
    }
    
    public Stanza vaiEst(){
        if(this.est != null){
            return this.est;
        }
        else{
            return null;
        }
    }
    
    public Stanza vaiOvest(){
        if(this.ovest != null){
            return this.ovest;
        }
        else{
            return null;
        }
    }
    
    public void rimuoviOggetto(Oggetto o){
        this.oggetti.remove(o);
    }
    
}
