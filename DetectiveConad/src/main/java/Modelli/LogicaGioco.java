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
        if (interfaccia.controllaStato() == true) {
            interfaccia.riproduciIntroduzione();
            interfaccia.inizializzaInterfacciaUtente();
        }
    }
    
    public void resettaStruttureDati(){
        //Cancella le cose fatte
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
                        if(idPartita != 0){
                            mappa = new Mappa();
                            db.inserisciOggetti(idPartita,mappa.getOggetti());
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
                    //Carica oggetti sulla mappa
                    break;
                case "CONTINUA_PARTITA_2":
                    interfaccia.caricaPartita();
                    idPartita = 2;
                    azioniEseguite = db.caricaAzioniEseguite(idPartita);
                    inventario = db.caricaInventario(idPartita);
                    mappa.caricaStanzaCorrente(db.caricaStanzaCorrente(idPartita));
                    //Carica oggetti sulla mappa
                    break;
                case "CONTINUA_PARTITA_3":
                    interfaccia.caricaPartita();
                    idPartita = 3;
                    azioniEseguite = db.caricaAzioniEseguite(idPartita);
                    inventario = db.caricaInventario(idPartita);
                    mappa.caricaStanzaCorrente(db.caricaStanzaCorrente(idPartita));
                    //Carica oggetti sulla mappa
                    break;
                case "CONTINUA_PARTITA_4":
                    interfaccia.caricaPartita();
                    idPartita = 4;
                    azioniEseguite = db.caricaAzioniEseguite(idPartita);
                    inventario = db.caricaInventario(idPartita);
                    mappa.caricaStanzaCorrente(db.caricaStanzaCorrente(idPartita));
                    //Carica oggetti sulla mappa
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
                    if(mappa.getCorrente().getNome().equals("Strada")){
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
                    if (mappa.getCorrente().getNome().equals("Salumeria")) {
                        interfaccia.aggiungiTesto("Non posso entrarci, la porta e' chiusa a chiave, e nessuno sembra avercela.");
                    } else {
                        interfaccia.aggiungiTesto(mappa.spostamento("n"));
                    }
                    break;
                case "VAI_GIU":
                    interfaccia.aggiungiTesto(mappa.spostamento("s"));
                    break;
                case "VAI_DESTRA":
                    if (azioniEseguite.verificaPresenzaAzione(Azione.GRATA_APERTA) && mappa.getCorrente().getNome().equals("Studio")) {
                        interfaccia.aggiungiTesto(mappa.spostamento("e"));
                    } else if (!azioniEseguite.verificaPresenzaAzione(Azione.GRATA_APERTA) && mappa.getCorrente().getNome().equals("Studio")) {
                        interfaccia.aggiungiTesto("Non posso entrarci, la grata e' chiusa, dovrei usare qualcosa per aprirla...");
                    } else {
                        interfaccia.aggiungiTesto(mappa.spostamento("e"));
                    }
                    break;
                case "VAI_SINISTRA":
                    interfaccia.aggiungiTesto(mappa.spostamento("o"));
                    break;
                case "OSSERVA":
                    interfaccia.aggiungiTesto(mappa.osservaStanza());
                    break;
                case "SCATTA_FOTO":
                    if (mappa.getCorrente().getNome().equals("Ingresso") && !azioniEseguite.verificaPresenzaAzione(Azione.FOTO_SCATTATA)) {
                        if(mappa.prendiOggetto("mappa") != null){
                            inventario.inserisciOggetto(mappa.prendiOggetto("mappa"));
                            interfaccia.aggiungiTesto(mappa.getDialogoPresaOggetto("FotoQuadro"));
                            azioniEseguite.inserisciAzione(Azione.FOTO_SCATTATA);
                        }
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
                    break;
                case "SALVA_NO_E_VAI_AL_MENU":
                    interfaccia.disattivaInterfacciaSalvataggio();
                    interfaccia.tornaAMenuIniziale();
                    resettaStruttureDati();
                    break;
                case "COMANDO_APRI":
                    if(mappa.getCorrente().getNome().equals("Studio") && inventario.haOggetto("Cacciavite")){
                        azioniEseguite.inserisciAzione(Azione.GRATA_APERTA);
                        interfaccia.aggiungiTesto(mappa.getDialogoAperto());
                    }
                    interfaccia.aggiungiTesto(mappa.getDialogoApri());
                    break;
                    
                case "FLASH":
                    if(mappa.getCorrente().getNome().equals("Condotto")){
                        azioniEseguite.inserisciAzione(Azione.FLASH_ATTIVATO);
                        interfaccia.aggiungiTesto(mappa.prelevaTesto());
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
