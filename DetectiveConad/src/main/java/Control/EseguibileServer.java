package Control;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EseguibileServer {
    
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6666);
        int contatoreClient = 0;
        while(true){
            Socket socket = server.accept();
            Thread t = new GestoreConnessione(socket,"clientN"+contatoreClient);
            contatoreClient++;
            t.start();
        }
    }
}
