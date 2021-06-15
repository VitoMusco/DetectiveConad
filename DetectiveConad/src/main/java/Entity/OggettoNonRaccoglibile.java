package Entity;

public class OggettoNonRaccoglibile extends Oggetto{
    
    public OggettoNonRaccoglibile(String a,String n){
        super(a,n);
    }
    
    @Override
    public String osservaOggetto(){
        return super.osservaOggetto()+", ma non posso raccoglierlo";
    }
}