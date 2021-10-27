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
 *
 * @author hieup
 */
public class ChessServer {

    /**
     * @param args the command line arguments
     */
    
    static ArrayList <Socket> listClient = new ArrayList();
    static ArrayList <Room> listRoom = new ArrayList();
    static ServerSocket server;
    
    
    public static void main(String[] args) throws IOException {
        server = new ServerSocket(ServerInformation.getServerPort());
        while(true){
            //Server always listen and accept client each client server create a new thread to handling it
            createClientThread(server.accept());
        }
    }

    //Static method for server
    
    private static void createClientThread(Socket accept) throws IOException {
        //This method create and a new thread to handling requests from client
        ServerRoomHandling roomHandling = new ServerRoomHandling (server, accept);
        Thread process = new Thread(new Runnable(){
            @Override
            public void run() {
                while(!accept.isClosed()){
                    try {
                        requestHandling(roomHandling);
                    } catch (IOException | ClassNotFoundException ex) {
                        
                    }
                }
                System.out.println("Connection is close");
            }
            
        });
        process.start();
    }
    
    private static void requestHandling(ServerRoomHandling roomHandling) throws IOException, ClassNotFoundException{
        Request request = (Request) roomHandling.receiveData();
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
