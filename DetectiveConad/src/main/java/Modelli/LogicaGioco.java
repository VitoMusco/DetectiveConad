package Modelli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogicaGioco {

    private Mappa mappa = new Mappa();
    private GestoreAzioni g = new GestoreAzioni();
    private Interfaccia interfaccia = new Interfaccia(g);
    private Database db = new Database();
    private Inventario inventario = new Inventario();
    private AzioniEseguite azioniEseguite = new AzioniEseguite();
    private int idPartita;

    public LogicaGioco() {
        interfaccia.riproduciIntro();
        db.inizializzaDatabase();
        inizializzaFunzionalitaPulsanti();
    }

    public void controllaStato() {
        controllaStatoIntroduzione();
        controllaStatoFinaleCorretto();
    }
    
    public void controllaStatoIntroduzione(){
        if (interfaccia.controllaStatoIntroduzione()) {
            interfaccia.riproduciIntroduzione();
            controllaStato();
        }
    }
    
    public void controllaStatoFinaleCorretto(){
        if(interfaccia.controllaStatoFinaleCorretto()){
            interfaccia.riproduciFinaleCorretto();
            controllaStato();
        }
    }

    public void resettaStruttureDati() {
        azioniEseguite.resettaAzioni();
        inventario.resettaInventario();
        mappa.resettaMappa();
        interfaccia.resettaTesto();
    }
    
    public void inizializzaFunzionalitaPulsanti(){
        interfaccia.getPulsanteEsci().addActionListener(g -> {
            System.exit(0);
        });
        interfaccia.getPulsanteIndaga().addActionListener(g -> {
            interfaccia.caricaPartiteSalvate(db.controlloIdPartite());
            interfaccia.inizializzaSelettorePartita();
        });
        interfaccia.getIniziaPartita().addActionListener(g -> {
            if (interfaccia.controllaNomePartita() == true) {
                idPartita = db.inserisciPartita(interfaccia.getNomePartita());
                if (idPartita != 0) {
                    mappa = new Mappa();
                    mappa.caricaOggetti();
                    db.inserisciOggetti(idPartita, mappa.getOggetti());
                    inventario = db.caricaInventario(idPartita);
                    interfaccia.esciDaCreatorePartita();
                    interfaccia.chiediSaltaIntroduzione();                 
                }
           }
        });
        interfaccia.getSalvataggiEsci().addActionListener(g -> {
            interfaccia.esciDaSelettorePartita();
        });
        interfaccia.getCreaSalvataggioEsci().addActionListener(g -> {
            interfaccia.esciDaCreatorePartita();
        });
        interfaccia.getNuovaPartita1().addActionListener(g -> {
            interfaccia.inizializzaCreatorePartita();
        });
        interfaccia.getNuovaPartita2().addActionListener(g -> {
            interfaccia.inizializzaCreatorePartita();
        });
        interfaccia.getNuovaPartita3().addActionListener(g -> {
            interfaccia.inizializzaCreatorePartita();
        });
        interfaccia.getNuovaPartita4().addActionListener(g -> {
            interfaccia.inizializzaCreatorePartita();
        });
        interfaccia.getContinuaPartita1().addActionListener(g -> {
            idPartita = 1;
            continuaPartita();
        });
        interfaccia.getContinuaPartita2().addActionListener(g -> {
            idPartita = 2;
            continuaPartita();
        });
        interfaccia.getContinuaPartita3().addActionListener(g -> {
            idPartita = 3;
            continuaPartita();
        });
        interfaccia.getContinuaPartita4().addActionListener(g -> {
            idPartita = 4;
            continuaPartita();
        });
        interfaccia.getApriEditor().addActionListener(g -> {
            interfaccia.mostraEditorTesto();
            if (mappa.getCorrente().getNome().equals("Strada")) {
                interfaccia.mostraTesto(mappa.prelevaTestoDaIntroduzione());
            }
            interfaccia.aggiungiTesto(mappa.getCorrente().getDescrizione());
        });
        interfaccia.getApriTelefono().addActionListener(g -> {
            interfaccia.mostraCellulare();
        });
        interfaccia.getApriMovimento().addActionListener(g -> {
            interfaccia.mostraInterfacciaMovimento();
        });
        interfaccia.getSu().addActionListener(g -> {
            if (mappa.getCorrente().getNome().equals("Strada") && !azioniEseguite.verificaPresenzaAzione(Azione.GUANTI_EQUIPAGGIATI)) {
                interfaccia.aggiungiTesto("Nono, senza guanti non ci entro li. Le regole sono regole.");
            } else if (mappa.getCorrente().getNome().equals("Salumeria") && !azioniEseguite.verificaPresenzaAzione(Azione.PORTA_APERTA)) {
                interfaccia.aggiungiTesto("La porta e' chiusa a chiave, a meno che io non possa attraversare i muri da questa parte non si passa");
            } else if (mappa.getCorrente().getNome().equals("Ingresso") && !azioniEseguite.verificaPresenzaAzione(Azione.FOTO_SCATTATA)) {
                interfaccia.aggiungiTesto("Serve qualcosa per orientarmi... se mi spostassi mi perderei, il mio senso dell'orientamento e' andato ormai");
            } else {
                interfaccia.aggiungiTesto(mappa.spostamento("n"));
            }
        });
        interfaccia.getGiu().addActionListener(g -> {
            if (mappa.getCorrente().getNome().equals("Ingresso") && !azioniEseguite.verificaPresenzaAzione(Azione.FOTO_SCATTATA)) {
                interfaccia.aggiungiTesto("Serve qualcosa per orientarmi... se mi spostassi mi perderei, il mio senso dell'orientamento e' andato ormai");
            } else if (mappa.getCorrente().getNome().equals("Cellafrigo") && !azioniEseguite.verificaPresenzaAzione(Azione.PORTA_APERTA)) {
                interfaccia.aggiungiTesto("La porta e' chiusa, a meno che io non la apra dovro' usare il condotto.");
            } else {
                interfaccia.aggiungiTesto(mappa.spostamento("s"));
            }
        });
        interfaccia.getDestra().addActionListener(g -> {
            if (mappa.getCorrente().getNome().equals("Ingresso") && !azioniEseguite.verificaPresenzaAzione(Azione.FOTO_SCATTATA)) {
                interfaccia.aggiungiTesto("Serve qualcosa per orientarmi... se mi spostassi mi perderei, il mio senso dell'orientamento e' andato ormai");
            } else if (azioniEseguite.verificaPresenzaAzione(Azione.GRATA_APERTA) && mappa.getCorrente().getNome().equals("Studio")) {
                interfaccia.aggiungiTesto(mappa.spostamento("e"));
            } else if (!azioniEseguite.verificaPresenzaAzione(Azione.GRATA_APERTA) && mappa.getCorrente().getNome().equals("Studio")) {
                interfaccia.aggiungiTesto("Non posso entrarci, la grata e' chiusa, dovrei usare qualcosa per aprirla...");
            } else if (!azioniEseguite.verificaPresenzaAzione(Azione.FLASH_ATTIVATO) && mappa.getCorrente().getNome().equals("Condotto")) {
                interfaccia.aggiungiTesto("Non vedo niente! Non riesco a spostarmi! Dove diavolo e' il mio telefono?");
            } else {
                interfaccia.aggiungiTesto(mappa.spostamento("e"));
            }
        });
        interfaccia.getSinistra().addActionListener(g -> {
            if (mappa.getCorrente().getNome().equals("Ingresso") && !azioniEseguite.verificaPresenzaAzione(Azione.FOTO_SCATTATA)) {
                interfaccia.aggiungiTesto("Serve qualcosa per orientarmi... se mi spostassi mi perderei, il mio senso dell'orientamento e' andato ormai");
            } else if (!azioniEseguite.verificaPresenzaAzione(Azione.FLASH_ATTIVATO) && mappa.getCorrente().getNome().equals("Condotto")) {
                interfaccia.aggiungiTesto("Non vedo niente! Non riesco a spostarmi! Dove diavolo e' il mio telefono?");
            } else {
                interfaccia.aggiungiTesto(mappa.spostamento("o"));
            }
        });
        interfaccia.getOsserva().addActionListener(g -> {
            if (mappa.getCorrente().getNome().equals("Studio") && !azioniEseguite.verificaPresenzaAzione(Azione.GRATA_TROVATA)) {
                azioniEseguite.inserisciAzione(Azione.GRATA_TROVATA);
                interfaccia.aggiungiTesto(mappa.osservaStanza());
            } else if (mappa.getCorrente().getNome().equals("Cellafrigo") && !azioniEseguite.verificaPresenzaAzione(Azione.TROVATO_CADAVERE)) {
                azioniEseguite.inserisciAzione(Azione.TROVATO_CADAVERE);
                interfaccia.aggiungiTesto(mappa.osservaStanza());
            } else if (mappa.getCorrente().getNome().equals("Cellafrigo") && inventario.isEquipaggiato("torcia")) {
                interfaccia.aggiungiTesto("Oh ma cosa abbiamo qui? Un'impronta digitale...");
                interfaccia.aggiungiTesto("Ecco fatto, l'ho presa. Quelli della scientifica si pentiranno di non avermi assunto!");
                interfaccia.aggiungiTesto("Ora devo soltanto vedere a chi appartiene... meglio andare ad interrogare i dipendenti, cosi' potro' confrontarla con le loro impronte!");
                inventario.inserisciOggetto(mappa.prendiOggetto("impronte_michele"));
            } else if (mappa.getCorrente().getNome().equals("Salumeria") && inventario.isEquipaggiato("torcia")) {
                interfaccia.aggiungiTesto("Hmm... vedo delle impronte fresche su uno dei coltelli.");
                interfaccia.aggiungiTesto("Bene, ho preso le impronte.");
                inventario.inserisciOggetto(mappa.prendiOggetto("impronte_vincenzo"));
            } else if (mappa.getCorrente().getNome().equals("Studio") && inventario.isEquipaggiato("torcia")) {
                interfaccia.aggiungiTesto("Allora vediamo un po'... Ecco! ci sono impronte sui dispositivi del pc e sulla maniglia della porta.");
                interfaccia.aggiungiTesto("Prese! Vediamo se riesco ad incastrare qualcuno.");
                inventario.inserisciOggetto(mappa.prendiOggetto("impronte_vito"));
            } else if (mappa.getCorrente().getNome().equals("Zonafrigo") && inventario.isEquipaggiato("torcia")) {
                interfaccia.aggiungiTesto("Mamma mia che macchia gigante! Avranno buttato a terra qualche succo di frutta?");
                interfaccia.aggiungiTesto("Ma cosa sto dicendo! Quel tipo di macchia non si vede con i raggi UV! Forse hanno fatto bene a non prendermi nella scientifica alla fine...");
                interfaccia.aggiungiTesto("Qui deve essere stata pulita una grossa macchia di sangue, avranno ucciso qui il direttore? Mi avvicino alla soluzione del caso...");
                azioniEseguite.inserisciAzione(Azione.TROVATO_LUOGO_UCCISIONE);
            } else {
                interfaccia.aggiungiTesto(mappa.osservaStanza());
            }
        });
        interfaccia.getFotocamera().addActionListener(g -> {
            if (mappa.getCorrente().getNome().equals("Ingresso")) {
                if (!azioniEseguite.verificaPresenzaAzione(Azione.FOTO_SCATTATA)) {
                    inventario.inserisciOggetto(mappa.prendiOggetto("mappa"));
                    interfaccia.aggiungiTesto(mappa.getDialogoPresaOggetto("Mappa"));
                    azioniEseguite.inserisciAzione(Azione.FOTO_SCATTATA);
                } else if (azioniEseguite.verificaPresenzaAzione(Azione.FOTO_SCATTATA)) {
                    interfaccia.aggiungiTesto("Ho gia' scattato la foto!"); //Aggiungere nel file dialoghi
                }
            } else {
                interfaccia.aggiungiTesto("Non c'e' niente da fotografare qui"); //Aggiungere nel file dialoghi
            }
        });
        interfaccia.getEsci().addActionListener(g -> {
            interfaccia.impostaSalvataggioConUscita();
            interfaccia.mostraInterfacciaSalvataggio();
        });
        interfaccia.getAnnullaSalvataggio().addActionListener(g -> {
            interfaccia.disattivaInterfacciaSalvataggio();
        });
        interfaccia.getSalvaEVaiAMenu().addActionListener(g -> {
            interfaccia.impostaSalvataggioConMenu();
            interfaccia.mostraInterfacciaSalvataggio();
        });
        interfaccia.getSalva().addActionListener(g -> {
            interfaccia.impostaSalvataggioSenzaUscita();
            interfaccia.mostraInterfacciaSalvataggio();
        });
        interfaccia.getApri().addActionListener(g -> {
            if (mappa.getCorrente().getNome().equals("Studio")) {
                if (inventario.haOggetto("cacciavite") && inventario.isEquipaggiato("cacciavite")) {
                    azioniEseguite.inserisciAzione(Azione.GRATA_APERTA);
                    interfaccia.aggiungiTesto(mappa.getDialogoAperto());
                } else if (inventario.haOggetto("cacciavite") && !inventario.isEquipaggiato("cacciavite")) {
                    interfaccia.aggiungiTesto("Bene, ora che ho preso il cacciavite dovrei essere in grado di aprire questa grata, ma dove diavolo l'ho messo? Non dirmi che l'ho perso! Dovrei controllare la mia valigetta...");
                } else if (!inventario.haOggetto("cacciavite") && azioniEseguite.verificaPresenzaAzione(Azione.GRATA_TROVATA)) {
                    interfaccia.aggiungiTesto(mappa.getDialogoApri());
                } else if (!inventario.haOggetto("cacciavite") && !azioniEseguite.verificaPresenzaAzione(Azione.GRATA_TROVATA)) {
                    interfaccia.aggiungiTesto("Non vedo niente da aprire qui...");
                }
            } else if (mappa.getCorrente().getNome().equals("Salumeria")) {
                if (inventario.haOggetto("chiave") && inventario.isEquipaggiato("chiave")) {
                    azioniEseguite.inserisciAzione(Azione.PORTA_APERTA);
                    interfaccia.aggiungiTesto("Ecco qua, ho aperto la porta della salumeria, cosi' non dovro' piu' attraversare quel condotto sporco... Bleah!");
                } else if (inventario.haOggetto("chiave") && !inventario.isEquipaggiato("chiave")) {
                    interfaccia.aggiungiTesto("Ok, la chiave l'ho presa, ma non ce l'ho in mano...");
                } else {
                    interfaccia.aggiungiTesto("Come faccio ad aprire la porta senza la chiave? A meno che non la trovi dovro' sempre usare il condotto... Che schifo.");
                }
            } else {
                interfaccia.aggiungiTesto("Non vedo niente da aprire qui...");
            }
        });
        interfaccia.getFlash().addActionListener(g -> {
            if (mappa.getCorrente().getNome().equals("Condotto")) {
                if (!azioniEseguite.verificaPresenzaAzione(Azione.FLASH_ATTIVATO)) {
                    azioniEseguite.inserisciAzione(Azione.FLASH_ATTIVATO);
                    interfaccia.aggiungiTesto(mappa.prelevaTesto());
                } else if (azioniEseguite.verificaPresenzaAzione(Azione.FLASH_ATTIVATO)) {
                    interfaccia.aggiungiTesto("Ho gia' attivato il flash!");
                }
            } else {
                interfaccia.aggiungiTesto("Non ho bisogno di attivare il flash adesso!");
            }
        });
        interfaccia.getPrendi().addActionListener(g -> {
            interfaccia.inizializzaInterfacciaGraficaAppCellulare();
            interfaccia.inizializzaPulsantiApp("PRENDI",mappa.getOggettiStanzaCorrente(),azioniEseguite);
        });
        interfaccia.getIncastra().addActionListener(g -> {
            if (azioniEseguite.verificaPresenzaAzione(Azione.TROVATO_CADAVERE)) {
                if (azioniEseguite.verificaPresenzaAzione(Azione.TROVATO_LUOGO_UCCISIONE) || azioniEseguite.verificaPresenzaAzione(Azione.TROVATA_IMPRONTA_VITO) || azioniEseguite.verificaPresenzaAzione(Azione.TROVATA_IMPRONTA_MICHELE) || azioniEseguite.verificaPresenzaAzione(Azione.TROVATA_IMPRONTA_VINCENZO)) {
                    interfaccia.inizializzaInterfacciaGraficaAppCellulare();
                    interfaccia.inizializzaAppIncastra();
                } else {
                    interfaccia.aggiungiTesto("Non posso incastrare nessuno, non ho trovato prove concrete che confermano sia un omicidio da parte di uno dei dipendenti.");
                }
            } else {
                interfaccia.aggiungiTesto("Perche' dovrei incastrare qualcuno? Non e' detto che il direttore sia morto... Dovrei smetterla di essere cosi' pessimista.");
            }
        });
        interfaccia.getInterroga().addActionListener(g -> {
            if (mappa.getCorrente().getNome().equals("Ingresso")) {
                if (inventario.isEquipaggiato("impronte_michele")) {
                    azioniEseguite.inserisciAzione(Azione.TROVATA_IMPRONTA_MICHELE);
                    interfaccia.aggiungiTesto(mappa.getDialogoImpronte("Michele"));
                } else if (inventario.isEquipaggiato("impronte_vincenzo")) {
                    azioniEseguite.inserisciAzione(Azione.TROVATA_IMPRONTA_VINCENZO);
                    interfaccia.aggiungiTesto(mappa.getDialogoImpronte("Vincenzo"));
                } else if (inventario.isEquipaggiato("impronte_vito")) {
                    azioniEseguite.inserisciAzione(Azione.TROVATA_IMPRONTA_VITO);
                    interfaccia.aggiungiTesto(mappa.getDialogoImpronte("Vito"));
                } else if (!azioniEseguite.verificaPresenzaAzione(Azione.DIPENDENTI_INTERROGATI)) {
                    interfaccia.aggiungiTesto(mappa.getDialogoInterrogazione());
                    azioniEseguite.inserisciAzione(Azione.DIPENDENTI_INTERROGATI);
                } else if (azioniEseguite.verificaPresenzaAzione(Azione.DIPENDENTI_INTERROGATI)) {
                    interfaccia.aggiungiTesto("Ho gia' interrogato i dipendenti, vediamo se mi ricordo cosa mi hanno detto...");
                    interfaccia.aggiungiTesto(mappa.getDialogoInterrogazione());
                }
            } else {
                interfaccia.aggiungiTesto("Non vedo nessuno da interrogare qui... i dipendenti sono all'ingresso.");
            }
        });
        interfaccia.getChiudiCaso().addActionListener(g -> {
            if (azioniEseguite.verificaPresenzaAzione(Azione.INCASTRATO_VITO) && azioniEseguite.verificaPresenzaAzione(Azione.INCASTRATO_MICHELE) && azioniEseguite.verificaPresenzaAzione(Azione.INCASTRATO_VINCENZO)) {
                interfaccia.inizializzaFinaleCorretto();
            } else {
                System.out.println("Il codice funziona, ma sei morto");
            }
        });
        interfaccia.getChiudiGraficaAppCellulare().addActionListener(g -> {
            interfaccia.chiudiInterfacciaGraficaAppCellulare();
        });
        interfaccia.getInventario().addActionListener(g -> {
            interfaccia.inizializzaInterfacciaGraficaAppCellulare();
            interfaccia.inizializzaPulsantiApp("EQUIPAGGIA",inventario.getInventario(),azioniEseguite);
        });
    }
    
    public void continuaPartita(){
        interfaccia.caricaPartita();
        azioniEseguite = db.caricaAzioniEseguite(idPartita);
        inventario = db.caricaInventario(idPartita);
        mappa.caricaStanzaCorrente(db.caricaStanzaCorrente(idPartita));
        mappa.caricaOggetti(db.caricaOggetti(idPartita));
    }
    
    class GestoreAzioni implements ActionListener {

        String comando;

        public GestoreAzioni() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            comando = e.getActionCommand();
            switch (comando) {
                case "SALTA_FILMATO":
                    interfaccia.saltaFilmatoIntroduzione();
                    interfaccia.chiudiChiediSaltaIntroduzione();
                    interfaccia.creaNuovaPartita();
                    break;
                case "VISUALIZZA_FILMATO":
                    interfaccia.nonSaltareFilmatoIntroduzione();
                    interfaccia.chiudiChiediSaltaIntroduzione();
                    interfaccia.creaNuovaPartita();
                    break;
                case "SALVA_SI_ED_ESCI":
                    db.salvaPartita(mappa.getCorrente(), inventario, idPartita, azioniEseguite);
                    System.exit(0);
                    break;
                case "SALVA_NO_ED_ESCI":
                    System.exit(0);
                    break;
                case "SALVA_SI":
                    db.salvaPartita(mappa.getCorrente(), inventario, idPartita, azioniEseguite);
                    interfaccia.disattivaInterfacciaSalvataggio();
                    break;
                case "SALVA_NO":
                    interfaccia.disattivaInterfacciaSalvataggio();
                    break;   
                case "SALVA_SI_E_VAI_AL_MENU":
                    db.salvaPartita(mappa.getCorrente(), inventario, idPartita, azioniEseguite);
                    interfaccia.disattivaInterfacciaSalvataggio();
                    interfaccia.tornaAMenuIniziale();
                    resettaStruttureDati();
                    break;
                case "SALVA_NO_E_VAI_AL_MENU":
                    interfaccia.disattivaInterfacciaSalvataggio();
                    interfaccia.tornaAMenuIniziale();
                    resettaStruttureDati();
                    break;
                case "EQUIPAGGIA_MAPPA":
                    interfaccia.mostraMappa();
                    break;
                case "PRENDI_CACCIAVITE":
                    if(azioniEseguite.verificaPresenzaAzione(Azione.GRATA_TROVATA)){
                        interfaccia.aggiungiTesto("Ecco qui il mio bel cacciavite! Mi tornera' utile...");
                        azioniEseguite.inserisciAzione(Azione.CACCIAVITE_PRESO);
                        inventario.inserisciOggetto(mappa.prendiOggetto("cacciavite"));
                        interfaccia.chiudiInterfacciaGraficaAppCellulare();
                    } else{
                        interfaccia.aggiungiTesto("Perche' dovrei prendere il cacciavite? Non ho niente da svitare!");
                    }
                    break;
                 case "PRENDI_CHIAVE":
                    if(!inventario.haOggetto("chiave")){
                        interfaccia.aggiungiTesto("Ma guarda un po' tu! Quali erano le possibilita' che trovassi la chiave proprio dove c'e' il corpo del direttore?");
                        inventario.inserisciOggetto(mappa.prendiOggetto("chiave"));
                        interfaccia.chiudiInterfacciaGraficaAppCellulare();
                    }
                    break;
                case "PRENDI_TORCIA":
                    if(azioniEseguite.verificaPresenzaAzione(Azione.TROVATO_CADAVERE)){
                        interfaccia.aggiungiTesto("Bene, con questa torcia posso vedere tracce di sangue e impronte digitali.");
                        azioniEseguite.inserisciAzione(Azione.TORCIA_PRESA);
                        inventario.inserisciOggetto(mappa.prendiOggetto("torcia"));
                        interfaccia.chiudiInterfacciaGraficaAppCellulare();
                    } else{
                        interfaccia.aggiungiTesto("Perche' dovrei prendere la torcia UV? Non ho niente da cercare per ora!");
                    }
                    break;
                case "PRENDI_GUANTI":
                    interfaccia.aggiungiTesto("Ok, adesso posso prendere prove senza lasciare impronte digitali. A patto che ci siano prove. A dir la verita' ho paura del covid...");
                    inventario.inserisciOggetto(mappa.prendiOggetto("guanti"));
                    interfaccia.chiudiInterfacciaGraficaAppCellulare();
                    break;
                case "INCASTRA_VITO":
                    if(azioniEseguite.verificaPresenzaAzione(Azione.TROVATA_IMPRONTA_VITO)){
                        interfaccia.aggiungiTesto("Ok, in base alle prove che ho trovato sono in grado di incastrare Vito, sara' lui il killer?");
                        azioniEseguite.inserisciAzione(Azione.INCASTRATO_VITO);
                    }
                    else{
                        interfaccia.aggiungiTesto("Perche' dovrei incastrare Vito? Non ho trovato nessuna prova che lo coinvolga nei fatti accaduti.");
                    }
                    break;
                case "INCASTRA_MICHELE":
                    if(azioniEseguite.verificaPresenzaAzione(Azione.TROVATA_IMPRONTA_MICHELE)){
                        interfaccia.aggiungiTesto("Ho trovato delle prove per incastrare Michele, saranno sufficienti?");
                        azioniEseguite.inserisciAzione(Azione.INCASTRATO_MICHELE);
                    }
                    else{
                        interfaccia.aggiungiTesto("Perche' dovrei incastrare Michele? Non ho trovato nessuna prova che lo coinvolga nei fatti accaduti.");
                    }
                    break;
                case "INCASTRA_VINCENZO":
                    if(azioniEseguite.verificaPresenzaAzione(Azione.TROVATA_IMPRONTA_VINCENZO)){
                        interfaccia.aggiungiTesto("Le impronte di Vincenzo erano su quel coltello, scacco matto?");
                        azioniEseguite.inserisciAzione(Azione.INCASTRATO_VINCENZO);
                    }
                    else{
                        interfaccia.aggiungiTesto("Perche' dovrei incastrare Vincenzo? Non ho trovato nessuna prova che lo coinvolga nei fatti accaduti.");
                    }
                    break;
                case "EQUIPAGGIA_CACCIAVITE":
                    if(!inventario.isEquipaggiato("cacciavite")){
                        interfaccia.aggiungiTesto("Ah ecco dove l'avevo messo, posso usarlo finalmente.");
                        inventario.equipaggiaOggetto("cacciavite");
                        interfaccia.chiudiInterfacciaGraficaAppCellulare();
                    } else{
                        interfaccia.aggiungiTesto("Perche' dovrei riprendere il cacciavite? Ce l'ho gia' in mano!");
                    }
                    break;
                case "EQUIPAGGIA_TORCIA":
                    if(!inventario.isEquipaggiato("torcia")){
                        interfaccia.aggiungiTesto("E' meglio che mi metta a cercare tracce in fretta, vorrei andarmene da qui.");
                        inventario.equipaggiaOggetto("torcia");
                        interfaccia.chiudiInterfacciaGraficaAppCellulare();
                    } else{
                        interfaccia.aggiungiTesto("Perche' dovrei riprendere la torcia? Ce l'ho gia' in mano!");
                    }
                    break;
                case "EQUIPAGGIA_CHIAVE":
                    if(!inventario.isEquipaggiato("chiave")){
                        interfaccia.aggiungiTesto("Ok, ora posso aprire la porta della salumeria.");
                        inventario.equipaggiaOggetto("chiave");
                        interfaccia.chiudiInterfacciaGraficaAppCellulare();
                    } else{
                        interfaccia.aggiungiTesto("Perche' dovrei riprendere la chiave? Ce l'ho gia' in mano!");
                    }
                    break;
                case "EQUIPAGGIA_GUANTI":
                    if(!azioniEseguite.verificaPresenzaAzione(Azione.GUANTI_EQUIPAGGIATI)){
                        interfaccia.aggiungiTesto("Ok, ora posso entrare e fare le mie indagini.");
                        inventario.equipaggiaOggetto("guanti");
                        azioniEseguite.inserisciAzione(Azione.GUANTI_EQUIPAGGIATI);
                        interfaccia.chiudiInterfacciaGraficaAppCellulare();
                    }
                    break;
                case "EQUIPAGGIA_IMPRONTE_VITO":
                    if(!inventario.isEquipaggiato("impronte_vito")){
                        interfaccia.aggiungiTesto("Hmmm... dove avevo trovato queste impronte? Ah si! Nell'ufficio del direttore.");
                        inventario.equipaggiaOggetto("impronte_vito");
                        interfaccia.chiudiInterfacciaGraficaAppCellulare();
                    } else{
                        interfaccia.aggiungiTesto("Devo smetterla di cercare oggetti che ho gia' in mano!");
                    }
                    break;
                case "EQUIPAGGIA_IMPRONTE_MICHELE":
                    if(!inventario.isEquipaggiato("impronte_michele")){
                        interfaccia.aggiungiTesto("Hmmm... dove avevo trovato queste impronte? Ah si! Sul telo che copriva il corpo nella cella frigorifera.");
                        inventario.equipaggiaOggetto("impronte_michele");
                        interfaccia.chiudiInterfacciaGraficaAppCellulare();
                    } else{
                        interfaccia.aggiungiTesto("Devo smetterla di cercare oggetti che ho gia' in mano!");
                    }
                    break;
                case "EQUIPAGGIA_IMPRONTE_VINCENZO":
                    if(!inventario.isEquipaggiato("impronte_vincenzo")){
                        interfaccia.aggiungiTesto("Hmmm... dove avevo trovato queste impronte? Ah si! In salumeria su un coltello di Michele.");
                        inventario.equipaggiaOggetto("impronte_vincenzo");
                        interfaccia.chiudiInterfacciaGraficaAppCellulare();
                    } else{
                        interfaccia.aggiungiTesto("Devo smetterla di cercare oggetti che ho gia' in mano!");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
