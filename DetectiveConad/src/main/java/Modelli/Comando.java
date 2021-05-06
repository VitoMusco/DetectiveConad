package Modelli;

import java.util.*;

public class Comando {
    private final TipoComando tipo;
    private final String nome;
    private Set<String> sinonimi;
    
    public Comando(TipoComando t,String n){
        this.tipo = t;
        this.nome = n;
    }
    
    public void setSinonimi(String[] s){
        for(String sinonimo:s){
            this.sinonimi.add(sinonimo);
        }
    }
    
    public Set<String> getSinonimi(){
        return this.sinonimi;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public boolean equals(Comando c){
        if (this == c) {
            return true;
        }
        if (c == null) {
            return false;
        }
        if (getClass() != c.getClass()) {
            return false;
        }
        final Comando altro = (Comando) c;
        if (this.tipo != altro.tipo) {
            return false;
        }
        return true;
    }
}
