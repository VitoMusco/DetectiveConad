package Modelli;

import Eccezioni.*;

public class Mappa {

    Stanza esterno;
    Stanza ingresso;
    Stanza camioncino;
    Stanza cassa;
    Stanza studio;
    Stanza retro;
    Stanza salumeria;
    Stanza corridoio1;
    Stanza corridoio2;
    Stanza corridoio3;
    Stanza corridoio4;
    Stanza corridoio5;
    Stanza corridoio6;
    Stanza zona_detersivi;
    Stanza zona_frutta;
    Stanza zona_frigo;
    Stanza condotto;
    Stanza corrente;

    public Mappa() {
        this.esterno = new Stanza("Esterno");
        this.ingresso = new Stanza("Ingresso");
        this.camioncino = new Stanza("Camioncino");
        this.cassa = new Stanza("Cassa");
        this.studio = new Stanza("Studio");
        this.retro = new Stanza("Cella frigorifera");
        this.salumeria = new Stanza("Salumeria");
        this.corridoio1 = new Stanza("Corridoio 1");
        this.corridoio2 = new Stanza("Corridoio 2");
        this.corridoio3 = new Stanza("Corridoio 3");
        this.corridoio4 = new Stanza("Corridoio 4");
        this.corridoio5 = new Stanza("Corridoio 5");
        this.corridoio6 = new Stanza("Corridoio 6");
        this.zona_detersivi = new Stanza("Zona detersiva");
        this.zona_frutta = new Stanza("Zona frutta");
        this.zona_frigo = new Stanza("Zona frigo");
        this.condotto = new Stanza("Condotto");

        this.esterno.assegnaNord(this.ingresso);
        this.esterno.assegnaSud(this.camioncino);
        this.ingresso.assegnaNord(this.cassa);
        this.ingresso.assegnaSud(this.esterno);
        this.camioncino.assegnaNord(this.esterno);
        this.cassa.assegnaNord(this.studio);
        this.cassa.assegnaSud(this.ingresso);
        this.cassa.assegnaEst(this.corridoio1);
        this.corridoio1.assegnaNord(this.zona_detersivi);
        this.corridoio1.assegnaEst(this.corridoio2);
        this.corridoio1.assegnaOvest(this.cassa);
        this.corridoio2.assegnaNord(this.zona_frutta);
        this.corridoio2.assegnaEst(this.corridoio3);
        this.corridoio2.assegnaOvest(this.corridoio1);
        this.corridoio3.assegnaNord(this.zona_frigo);
        this.corridoio3.assegnaOvest(this.corridoio2);
        this.zona_detersivi.assegnaNord(this.corridoio4);
        this.zona_detersivi.assegnaSud(this.corridoio1);
        this.zona_frutta.assegnaNord(this.corridoio5);
        this.zona_frutta.assegnaSud(this.corridoio2);
        this.zona_frigo.assegnaNord(this.corridoio6);
        this.zona_frigo.assegnaSud(this.corridoio3);
        this.corridoio4.assegnaSud(this.zona_detersivi);
        this.corridoio4.assegnaEst(this.corridoio5);
        this.corridoio5.assegnaSud(this.zona_frutta);
        this.corridoio5.assegnaEst(this.corridoio6);
        this.corridoio5.assegnaOvest(this.corridoio4);
        this.corridoio6.assegnaNord(this.salumeria);
        this.corridoio6.assegnaSud(this.zona_frigo);
        this.corridoio6.assegnaOvest(this.corridoio5);
     //   this.salumeria.assegnaNord(this.retro);
        this.salumeria.assegnaSud(this.corridoio6);
     //   this.retro.assegnaSud(this.salumeria);
        this.studio.assegnaSud(this.cassa);
        this.studio.assegnaNord(condotto);
        this.retro.assegnaOvest(studio);

        Oggetto pila = new Oggetto("una","pila");
        Oggetto torcia = new Oggetto("una","torcia");
        Oggetto guanti = new Oggetto("dei","guanti");
        Oggetto coltello = new Oggetto("un","coltello");
        Oggetto mappa = new Oggetto("una","mappa");
        Oggetto monetina = new Oggetto("una","moentina");
        Oggetto impronta = new OggettoNonRaccoglibile("una", "impronta");
        
                
        this.ingresso.inserisciOggetto(mappa);
        this.studio.inserisciOggetto(monetina);
        this.camioncino.inserisciOggetto(pila);
        this.camioncino.inserisciOggetto(torcia);
        this.camioncino.inserisciOggetto(guanti);
        this.salumeria.inserisciOggetto(coltello);
        this.studio.inserisciOggetto(impronta);
        this.salumeria.inserisciOggetto(impronta);
        this.retro.inserisciOggetto(impronta);
        
        this.corrente = this.esterno;
        
    }

    public Stanza getCorrente() {
        return this.corrente;
    }

    public void setCorrente(Stanza corrente) {
        this.corrente = corrente;
    }
    
    public void spostamento(String s){
        Stanza appoggio;
        appoggio = this.corrente;
        switch(s){
            case "n":
                try{
                    this.corrente = this.corrente.vaiNord();
                    this.corrente.assegnaSud(appoggio);
                }catch(StanzaException ex){
                    System.err.println(ex.getMessage());
                }
                break;
            case "s":
                try{
                    this.corrente = this.corrente.vaiSud();
                    this.corrente.assegnaNord(appoggio);
                }catch(StanzaException ex){
                    System.err.println(ex.getMessage());
                }
                break;
            case "e":
                try{
                    this.corrente = this.corrente.vaiEst();
                    this.corrente.assegnaOvest(appoggio);
                }catch(StanzaException ex){
                    System.err.println(ex.getMessage());
                }
                break;
            case "o":
                try{
                    this.corrente = this.corrente.vaiOvest();
                    this.corrente.assegnaEst(appoggio);
                }catch(StanzaException ex){
                    System.err.println(ex.getMessage());
                }
                break;
        }
    }
}
