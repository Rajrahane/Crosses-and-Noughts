package com.project.raj.tictactoe.activities;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.project.raj.tictactoe.R;
import com.project.raj.tictactoe.fragments.PlayersDialogFragment;

public class GamePlayersActivity extends AppCompatActivity implements PlayersDialogFragment.PlayersDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_players);
        showPlayersDialog();
    }
    public  void showPlayersDialog(){
        DialogFragment dialog=new PlayersDialogFragment();
        dialog.show(getFragmentManager(),"PlayersDialogFragment");
    }
    @Override
    public void onDialogPositiveClick(DialogFragment dialog){
        Toast.makeText(this.getBaseContext(),"Game Start",Toast.LENGTH_SHORT).show();
        Intent startGameIntent;
        startGameIntent=new Intent(this.getBaseContext(),GameActivity.class);
        startActivity(startGameIntent);
        finish();
    }
    @Override
    public void onDialogNegativeClick(DialogFragment dialog){
        Toast.makeText(this.getBaseContext(),"Exit",Toast.LENGTH_SHORT).show();
        finish();
    }
}
