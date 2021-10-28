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
    * @author hieup
    * This class handle send requests which is related to the rooms to the server.
 */
public class ClientRoomHandling extends ClientHandling{
    
    //Construct method extends from class ClientHandling
    public ClientRoomHandling(String host, int port) throws IOException {
        super(host, port);
    }
    
    //The roomRefresh method help send request and return a current list of rooms.
    public ArrayList <Room> roomRefresh() throws IOException, ClassNotFoundException{
        this.sendRequest(new Request("REFRESH"));
        return (ArrayList <Room>) this.receiveResult();
    }
    
    //The roomHost method help send request to host a room.
    public void roomHost(String name, int port) throws IOException {
        this.sendRequest(new Request(new Player
            (name, this.socket.getInetAddress().getHostAddress()),"HOST", port+""));
    }
    
    //The roomJoin method help join a room you want if it available and return the room you just joined.
    public Room roomJoin(String name, int roomIndex) throws IOException, ClassNotFoundException, FullRoomException, NotFoundRoomException, Exception{
        Room room = null;
        this.sendRequest(new Request(new Player
            (name, this.socket.getInetAddress().getHostAddress()), "JOIN", roomIndex));
        Object object = this.receiveResult();
        if(object instanceof Room){
            room = (Room) object;
        }
        else{
            //If the room is not availible (full or not found) the server will send an exception so just throw it
            throw (Exception) object;
        }
        return room;
    }
    
    //The roomClose method help close a room you have hosted by send to the server a CLOSEROOM request.
    public void roomClose() throws IOException{
        this.sendRequest(new Request("CLOSEROOM"));
    }
    
    //The roomOut method help exit a room you have joined by send to the server a OUT request.
    public void roomOut() throws IOException {
        this.sendRequest(new Request("OUT"));
    }
    
}


