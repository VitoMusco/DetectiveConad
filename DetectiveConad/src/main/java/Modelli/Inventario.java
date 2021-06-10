package Modelli;

import java.util.*;

public class Inventario {

    private List<Oggetto> inventario;

    public Inventario() {
        this.inventario = new ArrayList<>();
    }

    public void inserisciOggetto(Oggetto o) {
        this.inventario.add(o);
    }

    public void rimuoviOggetto(Oggetto o) {
        this.inventario.remove(o);
    }

    public void visualizzaInventario() {
        for (Oggetto o : this.inventario) {
            o.osservaOggetto();
        }
    }

    public List<Oggetto> getInventario() {
        return inventario;
    }

    public boolean haOggetto(String nome){
        ListIterator<Oggetto> lit = inventario.listIterator();
        while(lit.hasNext()){
            if(lit.next().getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }
}
