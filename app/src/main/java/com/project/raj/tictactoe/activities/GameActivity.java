package com.project.raj.tictactoe.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.project.raj.tictactoe.GameUI;
import com.project.raj.tictactoe.R;
import com.project.raj.tictactoe.UserProfile;
import com.raj.tictactoe.constants.GameConstants;
import com.raj.tictactoe.model.Board;

public class GameActivity extends AppCompatActivity {
    Button GameMoveButton[]=new Button[9];
    UserProfile user=new UserProfile();
    GameUI newGame=new GameUI();
    private static final int[] BUTTON_IDS={
            R.id.btn_board0,
            R.id.btn_board1,
            R.id.btn_board2,
            R.id.btn_board3,
            R.id.btn_board4,
            R.id.btn_board5,
            R.id.btn_board6,
            R.id.btn_board7,
            R.id.btn_board8
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent startGameIntent=getIntent();
        user.createPlayers(startGameIntent.getIntExtra("playerType",0),startGameIntent.getIntExtra("chanceNo",0));
        setContentView(R.layout.activity_game);
        init();
        setUpListeners();
        if(user.getComputerChanceNo()== GameConstants.FIRST_CHANCE){
            int movePlayedByAI=newGame.playRandomCorner(user);
            GameMoveButton[movePlayedByAI].setEnabled(false);
            GameMoveButton[movePlayedByAI].setBackgroundResource(user.getComputerIcon());
        }
    }

    void setUpListeners() {
        int i;
        for(i=0;i<GameMoveButton.length;i++){
            GameMoveButton[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button callingButton=(Button)view;
                    callingButton.setEnabled(false);
                    callingButton.setBackgroundResource(user.getPlayerIcon());
                    //callingButton.setText("O");//change button settings here
                    int movePlayedByAI=newGame.playMove(findIndexOf(callingButton),user);
                    if(newGame.getTurn()<= Board.TOTAL_MOVES){
                        GameMoveButton[movePlayedByAI].setEnabled(false);
                        GameMoveButton[movePlayedByAI].setBackgroundResource(user.getComputerIcon());
                        //GameMoveButton[movePlayedByAI].setText("X");
                    }    //valid move was played by ai
                    if(newGame.evaluateGame(user)==Board.COMPUTER_WINS){     //ai wins
                        Toast.makeText(view.getContext(),"You Lose",Toast.LENGTH_SHORT).show();
                    }
                    else if(newGame.evaluateGame(user)==Board.PLAYER_WINS){  //player wins
                        Toast.makeText(view.getContext(),"You Win",Toast.LENGTH_SHORT).show();
                    }
                    else if(newGame.getTurn()>Board.TOTAL_MOVES){    //draw
                        Toast.makeText(view.getContext(),"Game Draw",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    void init(){
        for(int i=0;i<GameMoveButton.length;i++){               //init boardButtons
            GameMoveButton[i]=findViewById(BUTTON_IDS[i]);
        }
    }
    int findIndexOf(Button button){
        for(int i=0;i<BUTTON_IDS.length;i++){
            if(button.getId()==BUTTON_IDS[i])
                return i;
        }
        return -1;
    }
}
