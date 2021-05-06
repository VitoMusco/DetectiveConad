package Modelli;

public class OggettoNonRaccoglibile extends Oggetto{
    @Override
    public String osservaOggetto(){
        return super.osservaOggetto()+", ma non posso raccoglierlo";
    }
}