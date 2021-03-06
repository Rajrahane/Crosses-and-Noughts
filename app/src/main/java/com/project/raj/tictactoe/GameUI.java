package com.project.raj.tictactoe;

import com.raj.tictactoe.ai.AI;
import com.raj.tictactoe.model.Board;
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
    public int playMove(int i,UserProfile user){
        turn+=2;
        board.setBoardIndex(i,user.getPlayerMoveValue());
        int movePlayed=-1;
        if(turn<= Board.TOTAL_MOVES){
            if(user.getComputerChanceNo()== com.raj.tictactoe.constants.GameConstants.SECOND_CHANCE){   //comp plays second
                switch (turn){
                    case 2:{
                        if(!board.isBlank(4)){                        //center taken
                            movePlayed=ai.getRandomCorner()-1;
                            board.setBoardIndex(movePlayed, user.getComputerMoveValue());//take any corner
                        }
                        else if(!board.isBlank(0)||!board.isBlank(2)||!board.isBlank(6)||!board.isBlank(8)){    //corner taken
                            movePlayed=4;
                            board.setBoardIndex(movePlayed, user.getComputerMoveValue());                               //take center
                        }
                        else{                                   //edge taken
                            if(!board.isBlank(1)||!board.isBlank(5)){
                                movePlayed=2;
                                board.setBoardIndex(movePlayed, user.getComputerMoveValue());
                            }
                            else{
                                movePlayed=6;
                                board.setBoardIndex(movePlayed, user.getComputerMoveValue());
                            }
                        }
                        break;
                    }
                    case 4:
                    case 6:
                    case 8:{
                        movePlayed=ai.findBestMove(board,user.getPlayer(),user.getComputer());
                        board.setBoardIndex(movePlayed, user.getComputerMoveValue());
                    }
                }
            }
            else{                                                                       //comp plays first,to be implemented
                movePlayed=ai.findBestMove(board,user.getPlayer(),user.getComputer());
                board.setBoardIndex(movePlayed,user.getComputerMoveValue());
            }
        }
        return movePlayed;
    }
    public int getTurn(){
        return turn;
    }
    public int evaluateGame(UserProfile user){
        return board.evaluateBoard(user.getPlayer(),user.getComputer());
    }
    public int playRandomCorner(UserProfile user){
        int movePlayedByAI=ai.getRandomCorner()-1;
        board.setBoardIndex(movePlayedByAI,user.getComputerMoveValue());
        return movePlayedByAI;
    }
}
