package com.project.raj.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;

import TicTacToe.Board;

public class GameActivity extends AppCompatActivity {
    Button GameMoveButton[]=new Button[9];
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
        setContentView(R.layout.activity_game);
        init();
        setUpListeners();
    }

    void setUpListeners() {
        int i;
        for(i=0;i<GameMoveButton.length;i++){
            GameMoveButton[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button callingButton=(Button)view;
                    callingButton.setEnabled(false);
                    callingButton.setText("O");//change button settings here
                    int movePlayedByAI=newGame.playMove(findIndexOf(callingButton));
                    if(newGame.getTurn()!= Board.TOTALMOVES+1){
                        GameMoveButton[movePlayedByAI].setEnabled(false);
                        GameMoveButton[movePlayedByAI].setText("X");
                    }    //valid move was played by ai
                    if(newGame.evaluateGame()==Board.COMPUTERWINS){     //ai wins
                        Toast.makeText(view.getContext(),"You Lose",Toast.LENGTH_SHORT).show();
                    }
                    else if(newGame.evaluateGame()==Board.PLAYERWINS){  //player wins
                        Toast.makeText(view.getContext(),"You Win",Toast.LENGTH_SHORT).show();
                    }
                    else if(newGame.getTurn()>Board.TOTALMOVES){    //draw
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
