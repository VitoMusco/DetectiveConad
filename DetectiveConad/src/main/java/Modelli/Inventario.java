package Modelli;

import java.util.*;


public class Inventario {
    private List<Oggetto> inventario = new ArrayList<>();
    
    public Inventario(){
       // this.inventario = new ArrayList<>();
    }
    
    public void inserisciOggetto(Oggetto o){
        this.inventario.add(o);
    }
    
    public void rimuoviOggetto(Oggetto o){
        this.inventario.remove(o);
    }
    
    public void visualizzaInventario(){
        for(Oggetto o:this.inventario){
            o.osservaOggetto();
        }
    }

    public List<Oggetto> getInventario() {
        return inventario;
    }
    
}
