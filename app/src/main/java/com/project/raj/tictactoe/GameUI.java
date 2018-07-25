package com.project.raj.tictactoe;

import TicTacToe.AI;
import TicTacToe.Board;
/**
 * Created by Rajvaibhav D. Rahane on 12-Jul-18.
 */
public class GameUI {
    private Board board;
    private AI ai;
    private int turn;
    public GameUI(){
        board=new Board();
        ai=new AI();
        turn=0;
    }
    public int playMove(int i){
        turn+=2;
        board.setBoardIndex(i,board.getPlayer());
        int movePlayed=-1;
        if(turn<= Board.TOTALMOVES){
            switch (turn){
                case 2:{
                    if(!board.isBlank(4)){                        //center taken
                        movePlayed=ai.getRandomCorner()-1;
                        board.setBoardIndex(movePlayed, board.getComputer());//take any corner
                    }
                    else if(!board.isBlank(0)||!board.isBlank(2)||!board.isBlank(6)||!board.isBlank(8)){    //corner taken
                        movePlayed=4;
                        board.setBoardIndex(movePlayed, board.getComputer());                               //take center
                    }
                    else{                                   //edge taken
                        if(!board.isBlank(1)||!board.isBlank(5)){
                            movePlayed=2;
                            board.setBoardIndex(movePlayed, board.getComputer());
                        }
                        else{
                            movePlayed=6;
                            board.setBoardIndex(movePlayed, board.getComputer());
                        }
                    }
                    break;
                }
                case 4:
                case 6:
                case 8:{
                    movePlayed=ai.findBestMove(board);
                    board.setBoardIndex(movePlayed, board.getComputer());
                }
            }
        }
        return movePlayed;
    }
    public int getTurn(){
        return turn;
    }
    public int evaluateGame(){
        return board.evaluateBoard(board.getBoard());
    }
}
