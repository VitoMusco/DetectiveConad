package Modelli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Eseguibile {

    Mappa mappa = new Mappa();
    Stanza stanzaCorrente;
    GestoreAzioni g = new GestoreAzioni();
    Interfaccia interfaccia = new Interfaccia(g);
    Database db = new Database();
    Dialoghi dialoghi = new Dialoghi();

    public Eseguibile() {
        interfaccia.riproduciIntro();
        interfaccia.riproduciAudio("menu");
        interfaccia.inizializzaMenu();
    }

    public static void main(String args[]) {
        Eseguibile e = new Eseguibile();
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
                    //interfaccia.chiediNomePartita();
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
                        dialoghi.prelevaTesti();
                        mappa = new Mappa();
                        interfaccia.creaNuovaPartita();
                    }
                    break;
                case "APRI_EDITOR":
                    interfaccia.mostraEditorTesto();
                    interfaccia.mostraTesto(dialoghi.testi.get("Introduzione"));
                    break;
                case "APRI_TELEFONO":
                    interfaccia.mostraCellulare();
                    break;
                case "SALTA_VIDEO":
                    interfaccia.saltaIntroduzione();
                    break;
                default:
                    break;
            }
        }

    }
}
