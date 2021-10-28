/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chessproject;

import chessproject.Class.Request;
import chessproject.Class.Room;
import chessproject.Class.ServerRoomHandling;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
    * @author hieup
    * Main server run
 */
public class ChessServer {
    static ArrayList <Socket> listClient = new ArrayList();// A list of clients is availible
    static ArrayList <Room> listRoom = new ArrayList();// A list of rooms which clients hosted
    static ServerSocket server;
    
    
    public static void main(String[] args) throws IOException {
        server = new ServerSocket(ServerInformation.getServerPort());
        while(true){
            //Server always listen and accept client each client server create a new thread to handle it
            createClientThread(server.accept());
        }
    }

    //Static method for server
    
    private static void createClientThread(Socket client) throws IOException {
        //This method create and a new thread to handling requests from client
        ServerRoomHandling roomHandling = new ServerRoomHandling (server, client);
        Thread process = new Thread(new Runnable(){
            @Override
            public void run() {
                /*
                    If the connection to the client is closed the loop will end. 
                    Else call the requestHandling to handle the request from client.
                */
                while(!client.isClosed()){
                    try {
                        requestHandle(roomHandling);
                    } catch (IOException | ClassNotFoundException ex) {
                        
                    }
                }
            }
            
        });
        process.start();
    }
    
    //requestHandle function will take the request from the client, check what type it is and handles it by the roomHandling.
    private static void requestHandle(ServerRoomHandling roomHandling) throws IOException, ClassNotFoundException{
        Request request = (Request) roomHandling.receiveData(); //Get request from the client
        System.out.println(request);
        switch(request.getRequest()){
            case "HOST": 
                roomHandling.hostRoom(listRoom, request.getPlayer(), request.getPort());
                break;
            case "REFRESH":
                roomHandling.refreshRoom(listRoom);
                break;
            case "JOIN":
                roomHandling.joinRoom(listRoom, request.getPlayer(), request.getRoomIndex());
                System.out.println(listRoom.size());
                System.out.println(request.getRoomIndex());
                break;
            case "CLOSEROOM":
                roomHandling.closeRoom(listRoom);
                break;
            case "OUT":
                roomHandling.outRoom();
                break;
            case "CLOSE":
                roomHandling.close(listClient, listRoom);
                break;
        }
    }
}
