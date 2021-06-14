package Modelli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

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
    private Map<Oggetto,String> oggetti;

    public Mappa() {
        this.oggetti = new HashMap<>();
        
        this.esterno = new Stanza("Strada", "Sono all'esterno del supermercato", 1);
        this.ingresso = new Stanza("Ingresso", "Sono all’ingresso", 3);
        this.camioncino = new Stanza("Camioncino", "Sono all’interno del mio camioncino.", 1);
        this.cassa = new Stanza("Cassa", "Sono alla cassa", 1);
        this.studio = new Stanza("Studio", "Sono nell'ufficio del direttore", 2);
        this.retro = new Stanza("Cellafrigo", "Sono nella cella frigorifera", 4);
        this.salumeria = new Stanza("Salumeria", "Sono in salumeria", 3);
        this.corridoio1 = new Stanza("Corridoio1", "Sono a sud della zona detersivi", 1);
        this.corridoio2 = new Stanza("Corridoio2", "Sono a sud della zona frutta", 1);
        this.corridoio3 = new Stanza("Corridoio3", "Sono a sud della zona frigo", 1);
        this.corridoio4 = new Stanza("Corridoio4", "Sono a nord della zona detersivi", 1);
        this.corridoio5 = new Stanza("Corridoio5", "Sono a nord della zona frutta", 1);
        this.corridoio6 = new Stanza("Corridoio6", "Sono a nord della zona frigo", 1);
        this.zona_detersivi = new Stanza("Zonadetersivi", "Sono nella zona detersivi", 1);
        this.zona_frutta = new Stanza("Zonafrutta", "Sono nella zona frutta", 1);
        this.zona_frigo = new Stanza("Zonafrigo", "Sono nella zona frigo", 1);
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
        this.condotto.assegnaOvest(this.studio);
        this.retro.assegnaOvest(this.condotto);

        this.corrente = this.esterno;

        this.dialoghi = new Dialoghi();
        this.dialoghi.prelevaTesti();

    }

    public void caricaOggetti(){
        Oggetto cacciavite = new Oggetto("un","cacciavite");
        Oggetto torcia = new Oggetto("una", "torcia");
        Oggetto guanti = new Oggetto("dei", "guanti");
        Oggetto mappa = new OggettoNonRaccoglibile("una", "mappa");
        Oggetto improntemichele = new OggettoNonRaccoglibile("le","impronte_michele");
        Oggetto improntevito = new OggettoNonRaccoglibile("le","impronte_vito");
        Oggetto improntevincenzo = new OggettoNonRaccoglibile("le","impronte_vincenzo");
        
        aggiungiOggetto(cacciavite, this.camioncino.getNome());
        aggiungiOggetto(torcia, this.camioncino.getNome());
        aggiungiOggetto(guanti, this.camioncino.getNome());
        aggiungiOggetto(mappa, this.ingresso.getNome());
        aggiungiOggetto(improntemichele, this.retro.getNome());
        aggiungiOggetto(improntevito, this.studio.getNome());
        aggiungiOggetto(improntevincenzo, this.salumeria.getNome());
        /*
        Oggetto pila = new Oggetto("una", "pila");
        
        Oggetto guanti = new Oggetto("dei", "guanti");
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
        */
    }
    
    public void caricaOggetti(Map<Oggetto,String> oggetti){
        for(Map.Entry<Oggetto,String> o : oggetti.entrySet()){
            aggiungiOggetto(o.getKey(),o.getValue());
        }
    }
    
    public Map<Oggetto,String> getOggetti(){
        return this.oggetti;
    }
    
    public List<Oggetto> getOggettiStanzaCorrente(){
        List<Oggetto> listaOggetti = new ArrayList<>();
        for(Map.Entry<Oggetto,String> o : oggetti.entrySet()){
            if(o.getValue().equals(this.corrente.getNome())){
                listaOggetti.add(o.getKey());
            }
        }
        return listaOggetti;
    }
    
    public void aggiungiOggetto(Oggetto o, String stanza) {
        oggetti.put(o,stanza);
    }
    
    public Oggetto prendiOggetto(String nome){
        Oggetto oggetto;
        for (Map.Entry<Oggetto, String> o : oggetti.entrySet()) {
            oggetto = o.getKey();
            if(oggetto.getNome().equals(nome)){
                oggetti.remove(oggetto);
                return oggetto;
            }
        }
        return null;
    }
    
    public Stanza getCorrente() {
        return this.corrente;
    }

    public void setCorrente(Stanza corrente) {
        this.corrente = corrente;
    }
    
    public void caricaStanzaCorrente(String s){
        switch(s){
            case "Strada":
                this.corrente = this.esterno;
                break;
            case "Ingresso":
                this.corrente = this.ingresso;
                break;
            case "Camioncino":
                this.corrente = this.camioncino;
                break;
            case "Cassa":
                this.corrente = this.cassa;
                break;
            case "Studio":
                this.corrente = this.studio;
                break;
            case "Cellafrigo":
                this.corrente = this.retro;
                break;
            case "Salumeria":
                this.corrente = this.salumeria;
                break;
            case "Corridoio1":
                this.corrente = this.corridoio1;
                break;
            case "Corridoio2":
                this.corrente = this.corridoio2;
                break;
            case "Corridoio3":
                this.corrente = this.corridoio3;
                break;
            case "Corridoio4":
                this.corrente = this.corridoio4;
                break;
            case "Corridoio5":
                this.corrente = this.corridoio5;
                break;
            case "Corridoio6":
                this.corrente = this.corridoio6;
                break;
            case "Zonadetersivi":
                this.corrente = this.zona_detersivi;
                break;
            case "Zonafrutta":
                this.corrente = this.zona_frutta;
                break;
            case "Zonafrigo":
                this.corrente = this.zona_frigo;
                break;
            case "Condotto":
                this.corrente = this.condotto;
                break;
            default:
                break;
        }
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
        return this.dialoghi.getTesti().get(this.corrente.getNome());
    }

    public String prelevaTestoDaIntroduzione() {
        return this.dialoghi.getTesti().get("Introduzione");
    }

    public String osservaStanza() {
        String testo = "";
        if (this.corrente.getMaxOsservazioni() > 1) {
            if (this.corrente.getNumOsservazioni() >= this.corrente.getMaxOsservazioni()) {
                for (int i = 1; i <= this.corrente.getMaxOsservazioni(); i++) {
                    testo = testo + this.dialoghi.getTesti().get(this.corrente.getNome() + "Oss" + i);
                    if (i < this.corrente.getMaxOsservazioni()) {
                        testo = testo + "\n";
                    }
                }
            } else {
                this.corrente.incrementaNumOsservazioni();
                testo = testo + this.dialoghi.getTesti().get(this.corrente.getNome() + "Oss" + this.corrente.getNumOsservazioni());
            }
        } else {
            testo = testo + this.dialoghi.getTesti().get(this.corrente.getNome() + "Oss");
        }
        if(testo.equals("null")){
            testo = "Non c'e' niente di particolare qui...";
        }
        return testo;
    }

    public String getDialogoPresaOggetto(String nome) {
        return this.dialoghi.getTesti().get("Prendi" + nome);
    }
    
    public String getDialogoApri(){
        String testo;
        testo = this.dialoghi.getTesti().get(corrente.getNome() + "Apri");
        if(testo==null){
            testo = "Non vedo niente da aprire qui...";
        }
        return testo;
    }
    
    public String getDialogoAperto(){
        String testo;
        testo = this.dialoghi.getTesti().get(corrente.getNome() + "Aperto");
        if(testo==null){
            testo = "Non vedo niente da aprire qui...";
        }
        return testo;
    }
    
    public String getDialogoInterrogazione(){
        String testo;
        testo = this.dialoghi.getTesti().get(corrente.getNome() + "Interroga");
        if(testo==null){
            testo = "Non vedo nessuno da interrogare...";
        }
        return testo;
    }
    
    public String getDialogoImpronte(String nome){
        String testo;
        testo = this.dialoghi.getTesti().get("ConfrontaImpronte" + nome);
        if(testo==null){
            testo = "Non vedo nessuno da interrogare...";
        }
        return testo;
    }
    
    public void resettaMappa(){
        oggetti = new HashMap<>();
    }

}
