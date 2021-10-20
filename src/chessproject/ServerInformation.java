/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessproject;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.UnknownHostException;



/**
 *
 * @author hieup
 */
public class ServerInformation {
    public static int getServerPort(){
        return 2207;
    }

    public static String getServerHost() throws UnknownHostException{
        return InetAddress.getLocalHost().getHostAddress();
    }
    
    public static int getClientPort() throws IOException{
        int port;
        for(port = 2208; port <= 65535; port++){
            try{
                //DatagramSocket serverUDP = new DatagramSocket(port);
                //serverUDP.close();
                ServerSocket serverTCP = new ServerSocket(port);
                serverTCP.close();
                return port;
            } catch(SocketException ex){
                //System.out.println("There is a server on: "+port);
            }
        }
                
        return -1;
    }
}
