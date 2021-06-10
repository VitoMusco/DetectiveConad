package Modelli;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class AzioniEseguite {

    private List<String> azioni;

    public AzioniEseguite() {
        this.azioni = new ArrayList<>();
    }

    public void inserisciAzione(String nome_azione) {
        azioni.add(nome_azione);
    }

    public List<String> getAzioni() {
        return azioni;
    }

    public boolean verificaPresenzaAzione(String nome_azione) {
        ListIterator<String> lit = this.azioni.listIterator();
        while (lit.hasNext()) {
            if (lit.next().equals(nome_azione)) {
                return true;
            }
        }
        return false;
    }
}
