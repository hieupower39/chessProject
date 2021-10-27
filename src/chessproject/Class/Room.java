/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessproject.Class;

import chessproject.Class.Player;
import java.io.Serializable;
import java.net.Socket;

/**
    * @author hieup
    * This class storage the information of a room and handle some action in a room
 */
public class Room implements Serializable{
    private Player host; //The player hosted the room.
    private Player client; //The client joined in the room.
    private boolean status; //The status of the room (true is available, false is full).
    private int port; //The port that player want to host the room.
    private int roomIndex; //A number for identification the room.
    private static int id = 100; //Some static to increment.

    //Constructor method
    public Room(Player host, int port) {
        this.host = host;
        this.status = true;
        this.port = port;
        this.roomIndex=id++;
    }
    
    //The join method help the client join this room
    public void join(Player client) {
        this.client = client; //Set the client information
        this.status = false; //Set the status to false that mean the room is full
    } 
    
    //The out method help client which in this room to out
    public void out(){
        this.client = null; //Remove the client information was joined in this room
        this.status = true; //Set the status to true that mean the room is availible
    }
    
    //Get method
    public static int getId() {
        return id;
    }

    public int getRoomIndex() {
        return roomIndex;
    }

    public Player getHost() {
        return host;
    }

    public Player getClient() {
        return client;
    }

    public int getPort() {
        return port;
    }
    
    public boolean isStatus() {
        return status;
    }
}
