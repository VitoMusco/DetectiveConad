/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eccezioni;

/**
 *
 * @author Vito
 */
public class StanzaException extends Exception{
    public String getMessage(){
        return "Stanza non trovata";
    }
}
