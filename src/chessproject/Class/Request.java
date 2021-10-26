/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessproject.Class;

import java.io.Serializable;

/**
 *
 * @author hieup
 */
public class Request implements Serializable{
    private Player player;
    private String request, data;
    private int roomIndex;
    private int port;

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
    
    
    
}
