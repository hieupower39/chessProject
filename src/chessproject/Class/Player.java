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
public class Player implements Serializable{
    private String name, address;

    public Player(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    
}
