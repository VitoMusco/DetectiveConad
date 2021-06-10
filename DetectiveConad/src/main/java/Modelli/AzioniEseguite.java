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
}
