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
public class RoomHandling extends ClientHandling{

    public RoomHandling(String host, int port) throws IOException {
        super(host, port);
    }
    
    public ArrayList roomRefresh() throws IOException, ClassNotFoundException{
        this.sendRequest(new Request("REFRESH"));
        return (ArrayList) this.receiveResult();
    }
     
    public void roomHost(String name, int port) throws IOException {
        this.sendRequest(new Request(new Player
            (name, this.socket.getInetAddress().getHostAddress()),"HOST", port+""));
    }
    
    public Room roomJoin(String name, int roomIndex) throws IOException, ClassNotFoundException, FullRoomException, NotFoundRoomException{
        Room room = null;
        this.sendRequest(new Request(new Player
            (name, this.socket.getInetAddress().getHostAddress()), "JOIN", roomIndex));
        Object object = this.receiveResult();
        if(object instanceof Room){
            room = (Room) object;
        }
        else{
            if(object.equals("Full")){
                throw new FullRoomException();
            }
            else{
                throw new NotFoundRoomException();
            }
        }
        return room;
    }
    
    public void roomClose() throws IOException{
        this.sendRequest(new Request("CLOSEROOM"));
    }

    public void roomOut() throws IOException {
        this.sendRequest(new Request("OUT"));
    }
    
}


