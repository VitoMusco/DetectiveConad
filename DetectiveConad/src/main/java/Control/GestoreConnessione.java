package Control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;

public class GestoreConnessione extends Thread{
    private final Socket socket;
    int[] oraConnessione = new int[3];
    Date data = new Date();
    
    public GestoreConnessione(Socket s){
        this.socket = s;
    }
    
    public GestoreConnessione(Socket s,String nClient){
        super(nClient);
        this.socket = s;
    }
    
    @Override
    public void run(){
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String in = input.readLine();
                if (in.equals("disconnessione")){
                    System.out.println("Il client "+this.getName()+" e' stato connesso per AGGIUNGERE TEMPO QUI");
                    break;
                } else if (in.equals("connessione")){
                    oraConnessione[0] = data.getSeconds();
                    oraConnessione[1] = data.getMinutes();
                    oraConnessione[2] = data.getHours();
                }
            }
        } catch (IOException ex){
            System.err.println(ex);
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
        
    }
}
