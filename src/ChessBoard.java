
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hieup
 */
public class ChessBoard {
    ArrayList <Object> moves;
    ArrayList <Object> chesses;

    public ChessBoard() {
    }
    
    public void movingAChess(Object movement){
        moves.add(movement);
    }
}
