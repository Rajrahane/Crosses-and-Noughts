package com.project.raj.tictactoe.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.project.raj.tictactoe.R;

public class MainActivity extends AppCompatActivity {
    Button playButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setUpListeners();
    }
    void init(){
        playButton=findViewById(R.id.btn_startGame);
    }
    public void setUpListeners(){
       playButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                Intent setgamePlayersIntent;
               setgamePlayersIntent = new Intent(view.getContext(),GamePlayersActivity.class);
               startActivity(setgamePlayersIntent);
           }
       });
    }
}
