/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Control;

import Server.Boundary.InterfacciaServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vito
 */
public class Connettore {
    
    private InterfacciaServer interfaccia = new InterfacciaServer();
    
    public Connettore(){
        ServerSocket server;
        try {
            server = new ServerSocket(6666);
            int contatoreClient = 0;
            while(true){
                Socket socket = server.accept();
                Thread t = new GestoreConnessione(socket,"clientN"+contatoreClient,interfaccia.getAreaTesto());
                contatoreClient++;
                t.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Connettore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
