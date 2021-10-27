/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chessproject.Class;

import java.io.IOException;

/**
 *
 * @author hieup
 */
public class ClientJoinHandling extends ClientHandling{

    public ClientJoinHandling(String host, int port) throws IOException {
        super(host, port);
    }
    
    public void sendData(String data) throws IOException{
        this.sendRequest(new Request("DATA", data));
    }
    
    public void out() throws IOException{
        this.sendRequest(new Request("OUT") );
        this.socket.close();
    }
    
}