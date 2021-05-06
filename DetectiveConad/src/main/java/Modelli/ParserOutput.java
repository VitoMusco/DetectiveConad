package Modelli;

public class ParserOutput {

    private Comando comando;

    private Oggetto oggetto;

    private Oggetto inventario;

    public ParserOutput(Comando comando, Oggetto ogetto) {
        this.comando = comando;
        this.oggetto = ogetto;
    }

    public ParserOutput(Comando comando, Oggetto ogetto, Oggetto inventario) {
        this.comando = comando;
        this.oggetto = ogetto;
        this.inventario = inventario;
    }

    public Comando getComando() {
        return comando;
    }

    public void setComando(Comando comando) {
        this.comando = comando;
    }

    public Oggetto getOggetto() {
        return this.oggetto;
    }

    public void setOggetto(Oggetto oggetto) {
        this.oggetto = oggetto;
    }

    public Oggetto getInventario() {
        return inventario;
    }

    public void setInventario(Oggetto inventario) {
        this.inventario = inventario;
    }

}
