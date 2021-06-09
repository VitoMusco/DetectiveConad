package Modelli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogicaGioco {

    Mappa mappa = new Mappa();
    GestoreAzioni g = new GestoreAzioni();
    Interfaccia interfaccia = new Interfaccia(g);
    Database db = new Database();
    Inventario inventario = new Inventario();

    public LogicaGioco() {
        interfaccia.riproduciIntro();
    }

    public static void main(String args[]) {
        LogicaGioco e = new LogicaGioco();
        e.controllaStato();
    }

    public void controllaStato() {
        if (interfaccia.controllaStato() == true) {
            interfaccia.riproduciIntroduzione();
            interfaccia.inizializzaInterfacciaUtente();
        }
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
                        db.inizializzaDatabase();
                        db.inserisciPartita(interfaccia.getNomePartita());
                        mappa = new Mappa();
                        interfaccia.creaNuovaPartita();
                    }
                    break;
                case "APRI_EDITOR":
                    interfaccia.mostraEditorTesto();
                    interfaccia.mostraTesto(mappa.prelevaTestoDaIntroduzione());
                    interfaccia.aggiungiTesto(mappa.prelevaTesto());
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
                    interfaccia.aggiungiTesto(mappa.spostamento("n"));
                    break;
                case "VAI_GIU":
                    interfaccia.aggiungiTesto(mappa.spostamento("s"));
                    break;
                case "VAI_DESTRA":
                    interfaccia.aggiungiTesto(mappa.spostamento("e"));
                    break;
                case "VAI_SINISTRA":
                    interfaccia.aggiungiTesto(mappa.spostamento("o"));
                    break;
                case "OSSERVA":
                    interfaccia.aggiungiTesto(mappa.osservaStanza());
                    break;
                case "SCATTA_FOTO":
                    inventario.inserisciOggetto(mappa.prendiOggetto("mappa"));
                    interfaccia.aggiungiTesto(mappa.getDialogoPresaOggetto("FotoQuadro"));
                    break;
                default:
                    break;
            }
        }
    }
}
