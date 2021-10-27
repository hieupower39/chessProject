/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chessproject.Class;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author hieup
 */
public class ClientHostHandling extends ServerHandling{
    private Boolean isOut = false;
    
    public ClientHostHandling(ServerSocket server, Socket socket) throws IOException {
        super(server, socket);
    }

    public void close() throws IOException {
        this.sendData(new Request("CLOSEROOM"));
    }

    public Boolean getIsOut() {
        return isOut;
    }

    public void setIsOut(Boolean isOut) {
        this.isOut = isOut;
    }
    
}
