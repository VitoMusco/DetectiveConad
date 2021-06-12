package Modelli;

import java.util.*;

public class Inventario {

    private List<Oggetto> inventario;
    private Oggetto oggettoEquipaggiato;

    public Inventario() {
        this.inventario = new ArrayList<>();
        this.oggettoEquipaggiato = new Oggetto("","");
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
        return this.inventario;
    }

    public boolean haOggetto(String nome){
        ListIterator<Oggetto> lit = this.inventario.listIterator();
        while(lit.hasNext()){
            if(lit.next().getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }
    
    public void resettaInventario(){
        this.inventario = new ArrayList<>();
    }
    
    public void equipaggiaOggetto(String nome){
        ListIterator<Oggetto> lit = this.inventario.listIterator();
        Oggetto app;
        while(lit.hasNext()){
            app = lit.next();
            if(app.getNome().equals(nome)){
                this.oggettoEquipaggiato = app;
            }
        }
    }
    
    public boolean isEquipaggiato(String nome){
        if(this.oggettoEquipaggiato.getNome().equals(nome)){
            return true;
        }
        return false;
    }
}
