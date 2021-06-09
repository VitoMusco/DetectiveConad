package Modelli;

public class AzioniEseguite {
    private boolean fotoScattata;
    private boolean grataAperta;
    
    public AzioniEseguite(){
        this.fotoScattata = false;
    }
    
    public void fotoScattata(){
        this.fotoScattata = true;
    }
    
    public boolean isFotoScattata(){
        return this.fotoScattata;
    }
    
    public void grataAperta(){
        this.grataAperta = true;
    }
    
    public boolean isGrataAperta(){
        return this.grataAperta;
    }
}
