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
public class Main {
    public static void main(String args[]){
        Interfaccia interfaccia = new Interfaccia();

        interfaccia.caricaImmaginiCaricamento();
        interfaccia.riproduciIntro();
        interfaccia.riproduciIntroduzione();
        interfaccia.riproduciAudio("menu");
        interfaccia.inizializzaMenu();
    }
}
