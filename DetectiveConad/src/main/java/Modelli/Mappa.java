package Modelli;

public class Mappa {

    private Dialoghi dialoghi;
    private Stanza esterno;
    private Stanza ingresso;
    private Stanza camioncino;
    private Stanza cassa;
    private Stanza studio;
    private Stanza retro;
    private Stanza salumeria;
    private Stanza corridoio1;
    private Stanza corridoio2;
    private Stanza corridoio3;
    private Stanza corridoio4;
    private Stanza corridoio5;
    private Stanza corridoio6;
    private Stanza zona_detersivi;
    private Stanza zona_frutta;
    private Stanza zona_frigo;
    private Stanza condotto;
    private Stanza corrente;

    public Mappa() {
        this.esterno = new Stanza("Strada", "Sono all'esterno del supermercato", 1);
        this.ingresso = new Stanza("Ingresso", "Sono all’ingresso", 2);
        this.camioncino = new Stanza("Camioncino", "Sono all’interno del mio camioncino.", 1);
        this.cassa = new Stanza("Cassa", "Sono alla cassa", 1);
        this.studio = new Stanza("Studio", "Sono nell'ufficio del direttore", 1);
        this.retro = new Stanza("Cellafrigo", "Sono nella cella frigorifera", 3);
        this.salumeria = new Stanza("Salumeria", "Sono in salumeria", 1);
        this.corridoio1 = new Stanza("Corridoio 1", "Sono a sud della zona detersivi", 1);
        this.corridoio2 = new Stanza("Corridoio 2", "Sono a sud della zona frutta", 1);
        this.corridoio3 = new Stanza("Corridoio 3", "Sono a sud della zona frigo", 1);
        this.corridoio4 = new Stanza("Corridoio 4", "Sono a nord della zona detersivi", 1);
        this.corridoio5 = new Stanza("Corridoio 5", "Sono a nord della zona frutta", 1);
        this.corridoio6 = new Stanza("Corridoio 6", "Sono a nord della zona frigo", 1);
        this.zona_detersivi = new Stanza("Zona detersivi", "Sono nella zona detersivi", 1);
        this.zona_frutta = new Stanza("Zona frutta", "Sono nella zona frutta", 1);
        this.zona_frigo = new Stanza("Zona frigo", "Sono nella zona frigo", 1);
        this.condotto = new Stanza("Condotto", "Sono nel condotto dell'ufficio del direttore", 1);

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
        this.studio.assegnaEst(this.condotto);
        this.condotto.assegnaEst(this.retro);
        this.retro.assegnaOvest(this.studio);

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

        this.dialoghi = new Dialoghi();
        this.dialoghi.prelevaTesti();

    }

    public Stanza getCorrente() {
        return this.corrente;
    }

    public void setCorrente(Stanza corrente) {
        this.corrente = corrente;
    }

    public String spostamento(String s) {
        Stanza appoggio1, appoggio2;
        appoggio1 = this.corrente;
        switch (s) {
            case "n":
                appoggio2 = this.corrente.vaiNord();
                if (appoggio2 != null) {
                    this.corrente = appoggio2;
                    this.corrente.assegnaSud(appoggio1);
                    return this.corrente.getDescrizione();
                }
                break;
            case "s":
                appoggio2 = this.corrente.vaiSud();
                if (appoggio2 != null) {
                    this.corrente = appoggio2;
                    this.corrente.assegnaNord(appoggio1);
                    return this.corrente.getDescrizione();
                }
                break;
            case "e":
                appoggio2 = this.corrente.vaiEst();
                if (appoggio2 != null) {
                    this.corrente = appoggio2;
                    this.corrente.assegnaOvest(appoggio1);
                    return this.corrente.getDescrizione();
                }
                break;
            case "o":
                appoggio2 = this.corrente.vaiOvest();
                if (appoggio2 != null) {
                    this.corrente = appoggio2;
                    this.corrente.assegnaEst(appoggio1);
                    return this.corrente.getDescrizione();
                }
                break;
        }
        return this.corrente.getMessaggioErroreDirezione();
    }

    public String prelevaTesto() {
        return this.dialoghi.testi.get(this.corrente.getNome());
    }

    public String prelevaTestoDaIntroduzione() {
        return this.dialoghi.testi.get("Introduzione");
    }

    public String osservaStanza() {
        String testo = "";
        if (this.corrente.getMaxOsservazioni() > 1) {
            if (this.corrente.getNumOsservazioni() >= this.corrente.getMaxOsservazioni()) {
                for (int i = 1; i <= this.corrente.getMaxOsservazioni(); i++) {
                    testo = testo + this.dialoghi.testi.get(this.corrente.getNome() + "Oss" + i);
                    if (i < this.corrente.getMaxOsservazioni()) {
                        testo = testo + "\n";
                    }
                }
            } else {
                this.corrente.incrementaNumOsservazioni();
                testo = testo + this.dialoghi.testi.get(this.corrente.getNome() + "Oss" + this.corrente.getNumOsservazioni());
            }
        } else {
            testo = testo + this.dialoghi.testi.get(this.corrente.getNome() + "Oss");
        }

        return testo;
    }

    public Oggetto prendiOggetto(String nome) {
        return this.corrente.getOggetto(nome);
    }

    public String getDialogoPresaOggetto(String nome) {
        return this.dialoghi.testi.get("Prendi" + nome);
    }

}
