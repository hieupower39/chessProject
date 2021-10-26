/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessproject;

import chessproject.Class.Room;
import chessproject.Class.Request;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hieup
 */
public class ServerTest {

    /**
     * @param args the command line arguments
     */
    
    static ArrayList <Socket> listClient = new ArrayList();
    static ArrayList <Room> listRoom = new ArrayList();
    
    private static Room findRoom(int roomIndex){
        for(Room room : listRoom){
            if(room.getRoomIndex()==roomIndex){
                return room;
            }
        }
        return null;
    }
    
    private static void createClientThread(Socket client) throws IOException{
        listClient.add(client);
        Thread process = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        System.out.println(client);
                        Room host = null;
                        Room join = null;
                        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
                        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
                        System.out.println("Waiting");
                        while(!client.isClosed()){
                            oos.reset();
                            System.out.println(client.isConnected());
                            Request request = (Request) ois.readObject(); 
                            System.out.println(request.getRequest());
                            if(request.getRequest().equals("HOST") ){
                                //System.out.println(request);
                                host = new Room(request.getPlayer(), request.getPort());
                                listRoom.add(host);
                                
                            }
                            if(request.getRequest().equals("JOIN")){
                                join = findRoom(request.getRoomIndex());
                                if(join != null){
                                    
                                    if(join.isStatus()){
                                        join.join(request.getPlayer());
                                        oos.writeObject(join);
                                    }   
                                    else{
                                        oos.writeObject("Full");
                                    }
                                    
                                }
                                else{
                                    oos.writeObject("Not found");
                                }
                                
                            }
                            if(request.getRequest().equals("REFRESH")){
                                ArrayList rooms = listRoom;
                                
                                oos.writeObject(rooms);   
                                System.out.println(listRoom.size());
                            }
                            if(request.getRequest().equals("CLOSE")){
                                try (client) {
                                    listClient.remove(client);
                                    if(host!=null){
                                        listRoom.remove(host);
                                    }
                                    client.close();
                                }
                            }
                            if(request.getRequest().equals("CLOSEROOM")){
                                listRoom.remove(host);
                                host = null;
                            }
                            if(request.getRequest().equals("OUT")){
                                join.out();
                                join = null;
                            }
                        }
                        ois.close();
                        oos.close();
                        System.out.println("This connection is close");
                        
                        
                    }catch (Exception e){
                        
                    }
                }
            });
         process.start();
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ServerSocket server = new ServerSocket(ServerInformation.getServerPort());
        
        
        while(true){
            createClientThread(server.accept());
        }
    }
    
}
