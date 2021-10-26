/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chessproject.Class;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author hieup
 */
public class ClientHandling {
    protected Socket socket;
    protected ObjectInputStream input;
    protected ObjectOutputStream output;
    
    public ClientHandling(String host, int port) throws IOException {
        socket = new Socket(host, port);
        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());
    }

    public Socket getSocket() {
        return socket;
    }
    
    protected void sendRequest(Request request) throws IOException{
        output.writeObject(request);
    }
    
    protected Object receiveResult() throws IOException, ClassNotFoundException{
        return input.readObject();
    }
    
    public void close() throws IOException{
        sendRequest(new Request("CLOSE"));
        input.close();
        output.close();
        socket.close();
    }
    
}
