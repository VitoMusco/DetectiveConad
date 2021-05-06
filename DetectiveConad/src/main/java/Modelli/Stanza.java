package Modelli;

import java.util.*;
import Eccezioni.*;

public class Stanza {
    private Stanza nord;
    private Stanza sud;
    private Stanza est;
    private Stanza ovest;
    private List<Oggetto> oggetti;
    private Map<String,Impiegato> impiegati;
    private String nome;
    
    public Stanza(String nome){
        this.nord = null;
        this.sud = null;
        this.est = null;
        this.ovest = null;
        this.oggetti = new ArrayList<>();
        this.impiegati = new HashMap<>();
        this.nome = nome;
    }
    
    public Stanza(Stanza n,Stanza s,Stanza e,Stanza o,String nome){
        this.nord = n;
        this.sud = s;
        this.est = e;
        this.ovest = o;
        this.oggetti = new ArrayList<>();
        this.nome = nome;
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
    
    public Stanza vaiNord() throws StanzaException{
        if(this.nord != null){
            return this.nord;
        }
        else{
            throw new StanzaException();
        }
    }
    
    public Stanza vaiSud() throws StanzaException{
        if(this.sud != null){
            return this.sud;
        }
        else{
            throw new StanzaException();
        }
    }
    
    public Stanza vaiEst() throws StanzaException{
        if(this.est != null){
            return this.est;
        }
        else{
            throw new StanzaException();
        }
    }
    
    public Stanza vaiOvest() throws StanzaException{
        if(this.ovest != null){
            return this.ovest;
        }
        else{
            throw new StanzaException();
        }
    }
    
    public void rimuoviOggetto(Oggetto o){
        this.oggetti.remove(o);
    }
    
}
