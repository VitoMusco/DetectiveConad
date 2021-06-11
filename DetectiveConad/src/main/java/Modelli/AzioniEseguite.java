package Modelli;

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
            case "FOTO_SCATTATA":
                inserisciAzione(Azione.FOTO_SCATTATA);
                break;
            case "GRATA_APERTA":
                inserisciAzione(Azione.GRATA_APERTA);
                break;
            case "FLASH_ATTIVATO":
                inserisciAzione(Azione.FLASH_ATTIVATO);
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
        azioni = null;
    }
}
