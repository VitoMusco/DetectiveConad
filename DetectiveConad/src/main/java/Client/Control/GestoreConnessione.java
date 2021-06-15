package Client.Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class GestoreConnessione extends Thread{
    private final Socket socket;
    private long oraConnessione;
    
    public GestoreConnessione(Socket s){
        this.socket = s;
    }
    
    public GestoreConnessione(Socket s,String nClient){
        super(nClient);
        this.socket = s;
    }
    
    public void mostraTempoConnessione(){
        long oraDisconnessione = System.currentTimeMillis();
        oraDisconnessione = oraDisconnessione - oraConnessione;
        System.out.println("Il client "+this.getName()+" e' stato connesso per "+oraDisconnessione+" ms");
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
                    System.out.println("Il client "+this.getName()+" si e' connesso");
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
