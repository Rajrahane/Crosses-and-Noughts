package com.project.raj.tictactoe.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.project.raj.tictactoe.constants.GameConstants;
import com.project.raj.tictactoe.R;

/**
 * Created by Rajvaibhav D. Rahane on 21-Jul-18.
 */
public class PlayersDialogFragment extends DialogFragment{
    private int playerType;

    public interface PlayersDialogListener{
        void onPlayersDialogPositiveClick(DialogFragment dialog,int playerType);
        void onPlayersDialogNegativeClick(DialogFragment dialog);
    }
    PlayersDialogListener mListener;
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            mListener=(PlayersDialogListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+" must implement NoticeDialogListener");
        }
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.select_players).setSingleChoiceItems(GameConstants.DISPLAY_PLAYER_TYPES, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                playerType=i;
            }
        }).setPositiveButton("Next", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mListener.onPlayersDialogPositiveClick(PlayersDialogFragment.this,playerType);
            }
        }).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mListener.onPlayersDialogNegativeClick(PlayersDialogFragment.this);
            }
        });
        return builder.create();
    }
}
