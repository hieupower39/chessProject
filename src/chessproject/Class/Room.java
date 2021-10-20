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
 *
 * @author hieup
 */
public class Room implements Serializable{
    private Player host, client;
    private boolean status;
    private int port;
    private static int id = 100;
    private int roomIndex;

    public Room(Player host, int port) {
        this.client = null;
        this.host = host;
        this.status = true;
        this.port = port;
        this.roomIndex=id++;
    }

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

    public void join(Player client) {
        this.client = client;
        this.status = false;
    } 
    
    public void out(){
        this.client = null;
        this.status = true;
    }
    
    
}
