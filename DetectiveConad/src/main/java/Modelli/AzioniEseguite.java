package Modelli;

public class AzioniEseguite {
    boolean fotoScattata;
    
    public AzioniEseguite(){
        this.fotoScattata = false;
    }
    
    public void fotoScattata(){
        this.fotoScattata = true;
    }
    
    public boolean isFotoScattata(){
        return this.fotoScattata;
    }
}
