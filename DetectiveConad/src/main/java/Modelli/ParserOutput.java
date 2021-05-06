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

    public Comando getCommand() {
        return comando;
    }

    public void setCommand(Comando comando) {
        this.comando = comando;
    }

    public Oggetto getObject() {
        return oggetto;
    }

    public void setObject(Oggetto oggetto) {
        this.oggetto = oggetto;
    }

    public Oggetto getInvObject() {
        return inventario;
    }

    public void setInvObject(Oggetto inventario) {
        this.inventario = inventario;
    }

}
