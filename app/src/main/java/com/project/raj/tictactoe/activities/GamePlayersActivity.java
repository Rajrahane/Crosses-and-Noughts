package com.project.raj.tictactoe.activities;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.project.raj.tictactoe.R;
import com.project.raj.tictactoe.fragments.ChanceDialogFragment;
import com.project.raj.tictactoe.fragments.PlayersDialogFragment;

public class GamePlayersActivity extends AppCompatActivity implements PlayersDialogFragment.PlayersDialogListener,ChanceDialogFragment.ChanceDialogListener {

     int playerType;
     int chanceNo;
     //UserProfile user=new UserProfile();

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
    public void onPlayersDialogPositiveClick(DialogFragment dialog,int playerType){
        this.playerType=playerType;
        showChanceDialog();
    }
    @Override
    public void onPlayersDialogNegativeClick(DialogFragment dialog){
        Toast.makeText(this.getBaseContext(),"Exit",Toast.LENGTH_SHORT).show();
        finish();
    }
    public void showChanceDialog(){
        DialogFragment dialog=new ChanceDialogFragment();
        dialog.show(getFragmentManager(),"ChanceDialogFragment");
    }
    @Override
    public void onChanceDialogPositiveClick(DialogFragment dialog,int chanceNo) {
        this.chanceNo=chanceNo;
        //user.createPlayers(this.playerType,this.chanceNo);
        Toast.makeText(this.getBaseContext(),"Game Start",Toast.LENGTH_SHORT).show();
        Intent startGameIntent=new Intent(this.getBaseContext(),GameActivity.class);
        startGameIntent.putExtra("playerType",this.playerType);
        startGameIntent.putExtra("chanceNo",this.chanceNo);
        startActivity(startGameIntent);
        finish();
    }
    @Override
    public void onChanceDialogNegativeClick(DialogFragment dialog){
        Toast.makeText(this.getBaseContext(),"Exit",Toast.LENGTH_SHORT).show();
        finish();
    }
}
