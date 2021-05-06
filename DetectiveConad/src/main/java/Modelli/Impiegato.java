/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelli;

/**
 *
 * @author Vito
 */
public class Impiegato {
    private String alibi;
    private String nome;
    
    public Impiegato(String a,String n){
        this.alibi = a;
        this.nome = n;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String interroga(){
        return this.alibi;
    }
}
