/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chessproject.Class;

import java.io.IOException;

/**
    * @author hieup
    * This class handles some action with the room you have joined.
 */
public class ClientJoinHandling extends ClientHandling{
    
    //Construct method extends from class ClientHandling
    public ClientJoinHandling(String host, int port) throws IOException {
        super(host, port);
    }
    
    //The sendData method help to send a string data to the host room.
    public void sendData(String data) throws IOException{
        this.sendRequest(new Request("DATA", data));
    }
    
    //The out method help send a request to exit this room to the host room and close the connection with it.
    public void out() throws IOException{
        this.sendRequest(new Request("OUT") );
        this.socket.close();
    }
    
}
