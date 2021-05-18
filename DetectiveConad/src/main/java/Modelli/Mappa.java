package Modelli;

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
        this.esterno = new Stanza("Esterno", "Sono all'esterno del supermercato");
        this.ingresso = new Stanza("Ingresso", "Sono all’ingresso");
        this.camioncino = new Stanza("Camioncino", "Sono all’interno del mio camioncino.");
        this.cassa = new Stanza("Cassa", "Sono alla cassa");
        this.studio = new Stanza("Studio", "Sono nell'ufficio del direttore");
        this.retro = new Stanza("Cella frigorifera", "Sono nella cella frigorifera");
        this.salumeria = new Stanza("Salumeria", "Sono in salumeria");
        this.corridoio1 = new Stanza("Corridoio 1", "Sono a sud della zona detersivi");
        this.corridoio2 = new Stanza("Corridoio 2", "Sono a sud della zona frutta");
        this.corridoio3 = new Stanza("Corridoio 3", "Sono a sud della zona frigo");
        this.corridoio4 = new Stanza("Corridoio 4", "Sono a nord della zona detersivi");
        this.corridoio5 = new Stanza("Corridoio 5", "Sono a nord della zona frutta");
        this.corridoio6 = new Stanza("Corridoio 6", "Sono a nord della zona frigo");
        this.zona_detersivi = new Stanza("Zona detersivi", "Sono nella zona detersivi");
        this.zona_frutta = new Stanza("Zona frutta", "Sono nella zona frutta");
        this.zona_frigo = new Stanza("Zona frigo", "Sono nella zona frigo");
        this.condotto = new Stanza("Condotto", "Sono nel condotto dell'ufficio del direttore");

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

        Oggetto pila = new Oggetto("una", "pila");
        Oggetto torcia = new Oggetto("una", "torcia");
        Oggetto guanti = new Oggetto("dei", "guanti");
        Oggetto coltello = new Oggetto("un", "coltello");
        Oggetto mappa = new Oggetto("una", "mappa");
        Oggetto monetina = new Oggetto("una", "monetina");
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

    public void spostamento(String s) {
        Stanza appoggio1,appoggio2;
        appoggio1 = this.corrente;
        switch (s) {
            case "n":
                appoggio2 = this.corrente.vaiNord();
                if(appoggio2!=null){
                    this.corrente = appoggio2;
                    this.corrente.assegnaSud(appoggio1);
                }
                break;
            case "s":
                appoggio2 = this.corrente.vaiSud();
                if(appoggio2!=null){
                    this.corrente = appoggio2;
                    this.corrente.assegnaNord(appoggio1);
                }
                break;
            case "e":
                appoggio2 = this.corrente.vaiEst();
                if(appoggio2!=null){
                    this.corrente = appoggio2;
                    this.corrente.assegnaOvest(appoggio1);
                }
                break;
            case "o":
                appoggio2 = this.corrente.vaiOvest();
                if(appoggio2!=null){
                    this.corrente = appoggio2;
                    this.corrente.assegnaEst(appoggio1);
                }
                break;
        }
    }
}
