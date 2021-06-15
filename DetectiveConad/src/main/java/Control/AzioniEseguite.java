package Control;

import Entity.Azione;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class AzioniEseguite {

    private List<Azione> azioni;

    public AzioniEseguite() {
        this.azioni = new ArrayList<>();
    }

    public void inserisciAzione(Azione a) {
        azioni.add(a);
    }
    
    public void inserisciAzione(String a){
        switch (a){
            case "GUANTI_EQUIPAGGIATI":
                inserisciAzione(Azione.GUANTI_EQUIPAGGIATI);
                break;
            case "FOTO_SCATTATA":
                inserisciAzione(Azione.FOTO_SCATTATA);
                break;
            case "GRATA_APERTA":
                inserisciAzione(Azione.GRATA_APERTA);
                break;
            case "GRATA_TROVATA":
                inserisciAzione(Azione.GRATA_TROVATA);
                break;
            case "CACCIAVITE_PRESO":
                inserisciAzione(Azione.CACCIAVITE_PRESO);
                break;
            case "TROVATO_LUOGO_UCCISIONE":
                inserisciAzione(Azione.TROVATO_LUOGO_UCCISIONE);
                break;
            case "TROVATO_CADAVERE":
                inserisciAzione(Azione.TROVATO_CADAVERE);
                break;
            case "PORTA_APERTA":
                inserisciAzione(Azione.PORTA_APERTA);
                break;
            case "TORCIA_PRESA":
                inserisciAzione(Azione.TORCIA_PRESA);
                break;
            case "TROVATA_IMPRONTA_MICHELE":
                inserisciAzione(Azione.TROVATA_IMPRONTA_MICHELE);
                break;
            case "TROVATA_IMPRONTA_VINCENZO":
                inserisciAzione(Azione.TROVATA_IMPRONTA_VINCENZO);
                break;
            case "TROVATA_IMPRONTA_VITO":
                inserisciAzione(Azione.TROVATA_IMPRONTA_VITO);
                break;
            case "FLASH_ATTIVATO":
                inserisciAzione(Azione.FLASH_ATTIVATO);
                break;
            case "DIPENDENTI_INTERROGATI":
                inserisciAzione(Azione.DIPENDENTI_INTERROGATI);
                break;
            case "INCASTRATO_VITO":
                inserisciAzione(Azione.INCASTRATO_VITO);
                break;
            case "INCASTRATO_MICHELE":
                inserisciAzione(Azione.INCASTRATO_MICHELE);
                break;
            case "INCASTRATO_VINCENZO":
                inserisciAzione(Azione.INCASTRATO_VINCENZO);
                break;
            default:
                break;
        }
    }

    public List<Azione> getAzioni() {
        return azioni;
    }

    public boolean verificaPresenzaAzione(Azione a) {
        ListIterator<Azione> lit = this.azioni.listIterator();
        while (lit.hasNext()) {
            if (lit.next().equals(a)) {
                return true;
            }
        }
        return false;
    }
    
    public void resettaAzioni(){
        azioni = new ArrayList<>();
    }
}
