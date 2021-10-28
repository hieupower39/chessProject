/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessproject.Class;

import java.io.Serializable;

/**
    * @author hieup
    * This class stores the information of the request.
 */
public class Request implements Serializable{
    private Player player; //The information of the player request.
    private final String request; //The request type
    private String data; //The string data of the request
    private int roomIndex; // The room identified of the request
    private int port; //The port player want to host

    //Constructor method
    public Request(String request) {
        this.request = request;
    }

    public Request(Player player, String request, String port) {
        this.player = player;
        this.request = request;
        this.port = Integer.parseInt(port);
        
    }

    public Request(Player player, String request, int roomIndex) {
        this.player = player;
        this.request = request;
        this.roomIndex = roomIndex;
    }

    public Request(String request, String data) {
        this.request = request;
        this.data = data;
    }
    
    //Get method
    public Player getPlayer() {
        return player;
    }

    public String getRequest() {
        return request;
    }

    public int getRoomIndex() {
        return roomIndex;
    }

    public int getPort() {
        return port;
    }

    public String getData() {
        return data;
    }
    
    //Override method
    @Override
    public String toString() {
        return request;
    }
    
}
