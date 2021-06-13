package Modelli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    }

    public void controllaStato() {
        if (interfaccia.controllaStatoIntroduzione()) {
            interfaccia.riproduciIntroduzione();
            interfaccia.inizializzaInterfacciaUtente();
        }

        if(interfaccia.controllaStatoFinaleCorretto()){
            interfaccia.riproduciFinaleCorretto();
        }
    }

    public void resettaStruttureDati() {
        azioniEseguite.resettaAzioni();
        inventario.resettaInventario();
        mappa.resettaMappa();
        interfaccia.resettaTesto();
    }

    class GestoreAzioni implements ActionListener {

        String comando;

        public GestoreAzioni() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            comando = e.getActionCommand();
            switch (comando) {
                case "ESCI":
                    System.exit(0);
                    break;
                case "NUOVA_PARTITA":
                    interfaccia.caricaPartiteSalvate(db.controlloIdPartite());
                    interfaccia.inizializzaSelettorePartita();
                    break;
                case "MENU_INIZIALE":
                    interfaccia.esciDaSelettorePartita();
                    break;
                case "CREA_PARTITA":
                    interfaccia.inizializzaCreatorePartita();
                    break;
                case "CREA_SALVATAGGIO_ESCI":
                    interfaccia.esciDaCreatorePartita();
                    break;
                case "INIZIA_PARTITA":
                    if (interfaccia.controllaNomePartita() == true) {
                        idPartita = db.inserisciPartita(interfaccia.getNomePartita());
                        if (idPartita != 0) {
                            mappa = new Mappa();
                            mappa.caricaOggetti();
                            db.inserisciOggetti(idPartita, mappa.getOggetti());
                            inventario = db.caricaInventario(idPartita);
                            interfaccia.creaNuovaPartita();
                        }
                    }
                    break;
                case "CONTINUA_PARTITA_1":
                    interfaccia.caricaPartita();
                    idPartita = 1;
                    azioniEseguite = db.caricaAzioniEseguite(idPartita);
                    inventario = db.caricaInventario(idPartita);
                    mappa.caricaStanzaCorrente(db.caricaStanzaCorrente(idPartita));
                    mappa.caricaOggetti(db.caricaOggetti(idPartita));
                    break;
                case "CONTINUA_PARTITA_2":
                    interfaccia.caricaPartita();
                    idPartita = 2;
                    azioniEseguite = db.caricaAzioniEseguite(idPartita);
                    inventario = db.caricaInventario(idPartita);
                    mappa.caricaStanzaCorrente(db.caricaStanzaCorrente(idPartita));
                    mappa.caricaOggetti(db.caricaOggetti(idPartita));
                    break;
                case "CONTINUA_PARTITA_3":
                    interfaccia.caricaPartita();
                    idPartita = 3;
                    azioniEseguite = db.caricaAzioniEseguite(idPartita);
                    inventario = db.caricaInventario(idPartita);
                    mappa.caricaStanzaCorrente(db.caricaStanzaCorrente(idPartita));
                    mappa.caricaOggetti(db.caricaOggetti(idPartita));
                    break;
                case "CONTINUA_PARTITA_4":
                    interfaccia.caricaPartita();
                    idPartita = 4;
                    azioniEseguite = db.caricaAzioniEseguite(idPartita);
                    inventario = db.caricaInventario(idPartita);
                    mappa.caricaStanzaCorrente(db.caricaStanzaCorrente(idPartita));
                    mappa.caricaOggetti(db.caricaOggetti(idPartita));
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
                case "ANNULLA_SALVA_ED_ESCI":
                    interfaccia.disattivaInterfacciaSalvataggio();
                    break;
                case "APRI_EDITOR":
                    interfaccia.mostraEditorTesto();
                    if (mappa.getCorrente().getNome().equals("Strada")) {
                        interfaccia.mostraTesto(mappa.prelevaTestoDaIntroduzione());
                    }
                    interfaccia.aggiungiTesto(mappa.getCorrente().getDescrizione());
                    break;
                case "APRI_TELEFONO":
                    interfaccia.mostraCellulare();
                    break;
                case "APRI_MOVIMENTO":
                    interfaccia.mostraInterfacciaMovimento();
                    break;
                case "SALTA_VIDEO":
                    interfaccia.saltaIntroduzione();
                    break;
                case "VAI_SU":
                    if (mappa.getCorrente().getNome().equals("Ingresso") && !azioniEseguite.verificaPresenzaAzione(Azione.FOTO_SCATTATA)){
                        interfaccia.aggiungiTesto("Serve qualcosa per orientarmi... se mi spostassi mi perderei, il mio senso dell'orientamento e' andato ormai");
                    }
                    else if (mappa.getCorrente().getNome().equals("Salumeria")) {
                        interfaccia.aggiungiTesto("Non posso entrarci, la porta e' chiusa a chiave, e nessuno sembra avercela.");
                    } else {
                        interfaccia.aggiungiTesto(mappa.spostamento("n"));
                    }
                    break;
                case "VAI_GIU":
                    if (mappa.getCorrente().getNome().equals("Ingresso") && !azioniEseguite.verificaPresenzaAzione(Azione.FOTO_SCATTATA)){
                        interfaccia.aggiungiTesto("Serve qualcosa per orientarmi... se mi spostassi mi perderei, il mio senso dell'orientamento e' andato ormai");
                    }
                    else{
                        interfaccia.aggiungiTesto(mappa.spostamento("s"));
                    }
                    break;
                case "VAI_DESTRA":
                    if (mappa.getCorrente().getNome().equals("Ingresso") && !azioniEseguite.verificaPresenzaAzione(Azione.FOTO_SCATTATA)){
                        interfaccia.aggiungiTesto("Serve qualcosa per orientarmi... se mi spostassi mi perderei, il mio senso dell'orientamento e' andato ormai");
                    }
                    else if (azioniEseguite.verificaPresenzaAzione(Azione.GRATA_APERTA) && mappa.getCorrente().getNome().equals("Studio")) {
                        interfaccia.aggiungiTesto(mappa.spostamento("e"));
                    } else if (!azioniEseguite.verificaPresenzaAzione(Azione.GRATA_APERTA) && mappa.getCorrente().getNome().equals("Studio")) {
                        interfaccia.aggiungiTesto("Non posso entrarci, la grata e' chiusa, dovrei usare qualcosa per aprirla...");
                    } else if (!azioniEseguite.verificaPresenzaAzione(Azione.FLASH_ATTIVATO) && mappa.getCorrente().getNome().equals("Condotto")){
                        interfaccia.aggiungiTesto("Non vedo niente! Non riesco a spostarmi! Dove diavolo e' il mio telefono?");
                    }
                    else {
                        interfaccia.aggiungiTesto(mappa.spostamento("e"));
                    }
                    break;
                case "VAI_SINISTRA":
                    if (mappa.getCorrente().getNome().equals("Ingresso") && !azioniEseguite.verificaPresenzaAzione(Azione.FOTO_SCATTATA)){
                        interfaccia.aggiungiTesto("Serve qualcosa per orientarmi... se mi spostassi mi perderei, il mio senso dell'orientamento e' andato ormai");
                    }
                    else if (!azioniEseguite.verificaPresenzaAzione(Azione.FLASH_ATTIVATO) && mappa.getCorrente().getNome().equals("Condotto")){
                        interfaccia.aggiungiTesto("Non vedo niente! Non riesco a spostarmi! Dove diavolo e' il mio telefono?");
                    }  else{
                        interfaccia.aggiungiTesto(mappa.spostamento("o"));
                    }
                    break;
                case "OSSERVA":
                    if(mappa.getCorrente().getNome().equals("Cellafrigo") && inventario.isEquipaggiato("torcia")){
                        interfaccia.aggiungiTesto("Oh ma cosa abbiamo qui? Un'impronta digitale...");
                        interfaccia.aggiungiTesto("Ecco fatto, l'ho presa. Quelli della scientifica si pentiranno di non avermi assunto!");
                        interfaccia.aggiungiTesto("Ora devo soltanto vedere a chi appartiene... meglio andare ad interrogare i dipendenti, cosi' potro' confrontarla con le loro impronte!");
                        azioniEseguite.inserisciAzione(Azione.TROVATA_IMPRONTA_MICHELE);
                        inventario.inserisciOggetto(mappa.prendiOggetto("impronte_michele"));
                    }
                    else if(mappa.getCorrente().getNome().equals("Salumeria") && inventario.isEquipaggiato("torcia")){
                        interfaccia.aggiungiTesto("Hmm... vedo delle impronte fresche su uno dei coltelli.");
                        interfaccia.aggiungiTesto("Bene, ho preso le impronte.");
                        azioniEseguite.inserisciAzione(Azione.TROVATA_IMPRONTA_VINCENZO);
                        inventario.inserisciOggetto(mappa.prendiOggetto("impronte_vincenzo"));
                    }
                    else if(mappa.getCorrente().getNome().equals("Studio") && inventario.isEquipaggiato("torcia")){
                        interfaccia.aggiungiTesto("Allora vediamo un po'... Ecco! ci sono impronte sui dispositivi del pc e sulla maniglia della porta.");
                        interfaccia.aggiungiTesto("Prese! Vediamo se riesco ad incastrare qualcuno.");
                        azioniEseguite.inserisciAzione(Azione.TROVATA_IMPRONTA_VITO);
                        inventario.inserisciOggetto(mappa.prendiOggetto("impronte_vito"));
                    }
                    else if(mappa.getCorrente().getNome().equals("ZonaFrigo") && inventario.isEquipaggiato("torcia")){
                        interfaccia.aggiungiTesto("Mamma mia che macchia gigante! Avranno buttato a terra qualche succo di frutta?");
                        interfaccia.aggiungiTesto("Ma cosa sto dicendo! Quel tipo di macchia non si vede con i raggi UV! Forse hanno fatto bene a non prendermi nella scientifica alla fine...");
                        azioniEseguite.inserisciAzione(Azione.TROVATA_IMPRONTA_VITO);
                        inventario.inserisciOggetto(mappa.prendiOggetto("impronte_vito"));
                    }
                    interfaccia.aggiungiTesto(mappa.osservaStanza());
                    break;
                case "SCATTA_FOTO":
                    if (mappa.getCorrente().getNome().equals("Ingresso") && !azioniEseguite.verificaPresenzaAzione(Azione.FOTO_SCATTATA)) {
                        inventario.inserisciOggetto(mappa.prendiOggetto("mappa"));
                        interfaccia.aggiungiTesto(mappa.getDialogoPresaOggetto("Mappa"));
                        azioniEseguite.inserisciAzione(Azione.FOTO_SCATTATA);
                    } else if (mappa.getCorrente().getNome().equals("Ingresso") && azioniEseguite.verificaPresenzaAzione(Azione.FOTO_SCATTATA)) {
                        interfaccia.aggiungiTesto("Ho gia' scattato la foto!"); //Aggiungere nel file dialoghi
                    } else {
                        interfaccia.aggiungiTesto("Non c'e' niente da fotografare qui"); //Aggiungere nel file dialoghi
                    }
                    break;
                case "SALVA":
                    interfaccia.impostaSalvataggioSenzaUscita();
                    interfaccia.mostraInterfacciaSalvataggio();
                    break;
                case "SALVA_E_VAI_AL_MENU":
                    interfaccia.impostaSalvataggioConMenu();
                    interfaccia.mostraInterfacciaSalvataggio();
                    break;
                case "SALVA_ED_ESCI":
                    interfaccia.impostaSalvataggioConUscita();
                    interfaccia.mostraInterfacciaSalvataggio();
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
                case "COMANDO_APRI":
                    if (mappa.getCorrente().getNome().equals("Studio") && inventario.haOggetto("cacciavite") && inventario.isEquipaggiato("cacciavite")) {
                        azioniEseguite.inserisciAzione(Azione.GRATA_APERTA);
                        interfaccia.aggiungiTesto(mappa.getDialogoAperto());
                    }
                    else if(mappa.getCorrente().getNome().equals("Studio") && inventario.haOggetto("cacciavite") && !inventario.isEquipaggiato("cacciavite")){
                        interfaccia.aggiungiTesto("Bene, ora che ho preso il cacciavite dovrei essere in grado di aprire questa grata, ma dove diavolo l'ho messo? Non dirmi che l'ho perso! Dovrei controllare la mia valigetta...");
                    }
                    else if(mappa.getCorrente().getNome().equals("Studio") && !inventario.haOggetto("cacciavite")){
                        interfaccia.aggiungiTesto(mappa.getDialogoApri());
                    }
                    else{
                        interfaccia.aggiungiTesto("Non vedo niente da aprire qui...");
                    }
                    break;
                case "FLASH":
                    if (mappa.getCorrente().getNome().equals("Condotto") && !azioniEseguite.verificaPresenzaAzione(Azione.FLASH_ATTIVATO)) {
                        azioniEseguite.inserisciAzione(Azione.FLASH_ATTIVATO);
                        interfaccia.aggiungiTesto(mappa.prelevaTesto());
                    } else if (mappa.getCorrente().getNome().equals("Condotto") && azioniEseguite.verificaPresenzaAzione(Azione.FLASH_ATTIVATO)) {
                        interfaccia.aggiungiTesto("Ho gia' attivato il flash!");
                    } else {
                        interfaccia.aggiungiTesto("Non ho bisogno di attivare il flash adesso!");
                    }
                    break;
                case "PRENDI":
                    interfaccia.inizializzaInterfacciaGraficaAppCellulare();
                    interfaccia.inizializzaPulsantiApp("PRENDI",mappa.getOggettiStanzaCorrente());
                    break;
                case "DISATTIVA_INTERFACCIA_APP_CELLULARE":
                    interfaccia.chiudiInterfacciaGraficaAppCellulare();
                    break;
                case "INTERROGA":
                    if (mappa.getCorrente().getNome().equals("Ingresso") && !azioniEseguite.verificaPresenzaAzione(Azione.DIPENDENTI_INTERROGATI)) {
                        interfaccia.aggiungiTesto(mappa.getDialogoInterrogazione());
                        azioniEseguite.inserisciAzione(Azione.DIPENDENTI_INTERROGATI);
                    } else if (mappa.getCorrente().getNome().equals("Ingresso") && azioniEseguite.verificaPresenzaAzione(Azione.DIPENDENTI_INTERROGATI)) {
                        interfaccia.aggiungiTesto("Ho gia' interrogato i dipendenti, vediamo se mi ricordo cosa mi hanno detto...");
                        interfaccia.aggiungiTesto(mappa.getDialogoInterrogazione());
                    } 
                    if(mappa.getCorrente().getNome().equals("Studio") && inventario.isEquipaggiato("impronte_michele")){
                        //Dialogo impronte michele
                        //Inserisci azione impronte confrontate
                    }
                    if(mappa.getCorrente().getNome().equals("Studio") && inventario.isEquipaggiato("impronte_vincenzo")){
                        //Dialogo impronte vincenzo
                        //Inserisci azione impronte confrontate
                    }
                    if(mappa.getCorrente().getNome().equals("Studio") && inventario.isEquipaggiato("impronte_vito")){
                        //Dialogo impronte vito
                        //Inserisci azione impronte confrontate
                    }
                    else {
                        interfaccia.aggiungiTesto("Non vedo nessuno da interrogare qui... i dipendenti sono all'ingresso.");
                    }
                    break;
                case "INCASTRA":
                    interfaccia.inizializzaInterfacciaGraficaAppCellulare();
                    interfaccia.inizializzaAppIncastra();
                    break;
                case "MAPPA":
                    //Mostra la mappa a video
                    break;
                case "PRENDI_CACCIAVITE":
                    interfaccia.aggiungiTesto("Ecco qui il mio bel cacciavite! Mi tornera' utile...");
                    azioniEseguite.inserisciAzione(Azione.CACCIAVITE_PRESO);
                    inventario.inserisciOggetto(mappa.prendiOggetto("cacciavite"));
                    interfaccia.chiudiInterfacciaGraficaAppCellulare();
                    break;
                case "PRENDI_TORCIA":
                    interfaccia.aggiungiTesto("Bene, con questa torcia posso vedere tracce di sangue e impronte digitali.");
                    azioniEseguite.inserisciAzione(Azione.TORCIA_PRESA);
                    inventario.inserisciOggetto(mappa.prendiOggetto("torcia"));
                    interfaccia.chiudiInterfacciaGraficaAppCellulare();
                    break;
                case "INCASTRA_VITO":
                    //Si puo fare se e solo se si sono trovate le prove
                    azioniEseguite.inserisciAzione(Azione.INCASTRATO_VITO);
                    break;
                case "INCASTRA_MICHELE":
                    //Si puo fare se e solo se si sono trovate le prove
                    azioniEseguite.inserisciAzione(Azione.INCASTRATO_MICHELE);
                    break;
                case "INCASTRA_VINCENZO":
                    //Si puo fare se e solo se si sono trovate le prove
                    azioniEseguite.inserisciAzione(Azione.INCASTRATO_VINCENZO);
                    break;
                case "CHIUDI_CASO":
                    //Si deve poter fare se e solo se si ha incastrato almeno una persona
                    if(azioniEseguite.verificaPresenzaAzione(Azione.INCASTRATO_VITO) || azioniEseguite.verificaPresenzaAzione(Azione.INCASTRATO_MICHELE) || azioniEseguite.verificaPresenzaAzione(Azione.INCASTRATO_VINCENZO)){
                        interfaccia.inizializzaFinaleCorretto();
                    } else{
                        System.out.println("Il codice funziona, ma sei morto");
                    }
                    break;
                case "INVENTARIO":
                    interfaccia.inizializzaInterfacciaGraficaAppCellulare();
                    interfaccia.inizializzaPulsantiApp("EQUIPAGGIA",inventario.getInventario());
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
                default:
                    break;
            }
        }
    }
}
