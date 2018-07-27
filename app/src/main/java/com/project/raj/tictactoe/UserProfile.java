package com.project.raj.tictactoe;

import com.raj.tictactoe.constants.GameConstants;
import com.raj.tictactoe.model.Player;

/**
 * Created by Rajvaibhav D. Rahane on 26-Jul-18.
 */
public class UserProfile {
    private Player player=new Player(),computer=new Player();
    private int playerIcon,computerIcon;
    public void createPlayers(int type,int chanceNo){
        if(type==0){
            computer.setMoveType(GameConstants.Move.O);
            computerIcon=android.R.drawable.btn_radio;              //set icon to O
            player.setMoveType(GameConstants.Move.X);
            playerIcon=android.R.drawable.ic_delete;                //set icon to X
        }
        else{
            computer.setMoveType(GameConstants.Move.X);
            computerIcon=android.R.drawable.ic_delete;              //set icon to X;
            player.setMoveType(GameConstants.Move.O);
            playerIcon=android.R.drawable.btn_radio;                //set icon to O;
        }
        if(chanceNo==0){
            player.setChanceNo(GameConstants.FIRST_CHANCE);
            computer.setChanceNo(GameConstants.SECOND_CHANCE);
        }
        else{
            player.setChanceNo(GameConstants.SECOND_CHANCE);
            computer.setChanceNo(GameConstants.FIRST_CHANCE);
        }
    }
    public int getPlayerIcon(){
        return playerIcon;
    }
    public int getComputerIcon(){
        return computerIcon;
    }
    public int getPlayerMoveValue(){
        return player.getMoveValue();
    }
    public int getComputerMoveValue(){
        return computer.getMoveValue();
    }
    public Player getPlayer(){
        return player;
    }
    public Player getComputer() {
        return computer;
    }
}

