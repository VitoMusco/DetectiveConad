package Server.Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JTextArea;

public class GestoreConnessione extends Thread{
    private final Socket socket;
    private long oraConnessione;
    private JTextArea areaTesto;
    
    public GestoreConnessione(Socket s){
        this.socket = s;
    }
    
    public GestoreConnessione(Socket s,String nClient,JTextArea a){
        super(nClient);
        this.socket = s;
        this.areaTesto = a;
    }
    
    public void mostraTempoConnessione(){
        long oraDisconnessione = System.currentTimeMillis();
        oraDisconnessione = oraDisconnessione - oraConnessione;
        areaTesto.append("Il client "+this.getName()+" e' stato connesso per "+oraDisconnessione+" ms\n");
    }
    
    @Override
    public void run(){
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String in;
            while (true) {
                in = input.readLine();
                if (in.equals("disconnessione")){
                    mostraTempoConnessione();
                    break;
                } else if (in.equals("connessione")){
                    areaTesto.append("Il client "+this.getName()+" si e' connesso\n");
                    oraConnessione = System.currentTimeMillis(); 
                }
            }
        } catch (IOException ex) {
            mostraTempoConnessione();
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
        
    }
}
