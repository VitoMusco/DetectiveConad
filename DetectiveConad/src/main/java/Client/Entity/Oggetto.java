package Client.Entity;

public class Oggetto {

    private final String nome;

    public Oggetto(String n) {
        this.nome = n;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean isRaccoglibile() {
        return !(this instanceof OggettoNonRaccoglibile);
    }

}
