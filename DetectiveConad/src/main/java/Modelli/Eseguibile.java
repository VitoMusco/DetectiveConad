package Modelli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eseguibile {
    Mappa mappa = new Mappa();
    Stanza stanzaCorrente;
    GestoreAzioni g = new GestoreAzioni();
    Interfaccia interfaccia = new Interfaccia(g);
    Database db = new Database();
    Dialoghi dialoghi = new Dialoghi();
    
    public Eseguibile(){
        interfaccia.caricaImmaginiCaricamento();
        interfaccia.riproduciIntro();
        //interfaccia.riproduciAudio("menu");
        interfaccia.inizializzaMenu();
    }
    
    public static void main(String args[]){
        Eseguibile e = new Eseguibile();
        e.controllaStato();
    }
    
    public void controllaStato(){
        if(interfaccia.controllaStato()==true){
            interfaccia.riproduciIntroduzione();
        }
    }
    
    class GestoreAzioni implements ActionListener{
        String comando;
        public GestoreAzioni(){
        }
        
        @Override
        public void actionPerformed(ActionEvent e){
            comando = e.getActionCommand();
            switch(comando){
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
                    /*
                    db.inizializzaDatabase();
                    db.inserisciPartita(interfaccia.getNomePartita());
                    interfaccia.disabilitaChiediNomePartita();
                    dialoghi.prelevaTesti();*/
                    interfaccia.creaNuovaPartita();
                    break;
                default:
                    break;
            }
        }
       
    }
}
