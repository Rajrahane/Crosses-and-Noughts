package com.project.raj.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                Intent gameIntent;
               gameIntent = new Intent(view.getContext(),GameActivity.class);
               startActivity(gameIntent);
           }
       });
    }
}
