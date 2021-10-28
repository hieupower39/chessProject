/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chessproject.Class;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
    * @author hieup
    * This class handles the action of client which is related to the rooms.
 */
public class ServerRoomHandling extends ServerHandling{
    private Room host; //This is the room which client create. 
    private Room join; //This is the room which client join in
    
    //Construct method extends from class ServerHandling
    public ServerRoomHandling(ServerSocket server, Socket socket) throws IOException {
        super(server, socket);
    }
    
    /*
        The hostRoom method help player to host a room
        Input parameters include:
            listRoom - a list to store rooms
            player - who want to host the room
            port - the server port which player want to host
    */
    public void hostRoom(ArrayList<Room> listRoom, Player player, int port){
        host = new Room(player, port); //Create a new room
        listRoom.add(host);//Store that room to the listRoom
    }
    
    /*
        The joinRoom method help player to join in a room
        Input parameters include:
            listRoom - a list to store rooms
            player - who want to join in the room
            roomIndex - the index of the room which player want to join in
    */
    public void joinRoom(ArrayList<Room> listRoom, Player player, int roomIndex) throws IOException{
        join = findRoom(listRoom, roomIndex); //Find the room by the roomIndex
        /*
            If the room does not exist, return "Not found".
            Else check the status of the room:
                If the status of room is false, someone else is already in the room, return "Full".
                Else let player join the room and send that player the room which that player just joined.
        */
        if(join != null){ 
            if(join.isStatus()){
                join.join(player);
                this.sendData(join);
            }
            else {
                this.sendData(new FullRoomException());
            }
        }
        else{
            this.sendData(new NotFoundRoomException());
        }
    }
    
    
    //The refreshRoom method return to client a listRoom
    public void refreshRoom(ArrayList<Room> listRoom) throws IOException{
        this.sendData(listRoom);
    }
    
    //The closeRoom  method help client close the room which they hosted;
    public void closeRoom(ArrayList<Room> listRoom){
        listRoom.remove(host); //remove the room was closed in the list
        host = null; //remove all information of the room was closed
    }
    
    //The method outRoom help client out the room which they joined in;
    public void outRoom(){
        join.out(); //clear the player joined in information
        join = null; //remove all information of the room which player was out;
    }
    
    /*
        The close method help client close connection with the server
        Input parameters include:
             listRoom - a list to store rooms
             listClient - a list to store the client
    */
    public void close(ArrayList<Socket> listClient, ArrayList<Room> listRoom) throws IOException{
       listClient.remove(socket); //remove the client in the listClient
       //System.out.println(host.getRoomIndex());

       if(host!=null){
           closeRoom(listRoom);//remove the room which this client hosted in the listRoom
       }
       
       //close all input output and connection
       input.close();
       output.close();
       socket.close();

    }
    
    //The findRoom method return the room have the roomIndex in parameters
    private Room findRoom(ArrayList<Room> listRoom, int roomIndex){
        for(Room room : listRoom){
            if(room.getRoomIndex()==roomIndex){
                return room;
            }
        }
        return null;
    }

    //Get method
    public Room getHost() {
        return host;
    }

    public Room getJoin() {
        return join;
    }
   
}
