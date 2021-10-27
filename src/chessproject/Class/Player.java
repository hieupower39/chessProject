/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessproject.Class;

import java.io.Serializable;

/**
    * @author hieup
    * This class store the information of a player 
 */
public class Player implements Serializable{
    private final String name; //Name of this player
    private final String address; //The IP address of this player

    //Contructor method
    public Player(String name, String address) {
        this.name = name;
        this.address = address;
    }

    //Get method
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    
}
