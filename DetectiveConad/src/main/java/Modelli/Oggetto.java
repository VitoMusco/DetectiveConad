package Modelli;

import java.util.*;

public class Oggetto {
    private final String nome,articolo;
    private Set<String> sinonimi;
    
    public Oggetto(String a,String n){
        this.nome = n;
        this.articolo = a;
    }
    
    public String osservaOggetto(){
        return this.articolo+" "+this.nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public Set<String> getSinonimi(){
        return this.sinonimi;
    }
    
}