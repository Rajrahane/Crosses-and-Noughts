package com.project.raj.tictactoe.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.project.raj.tictactoe.constants.GameConstants;

/**
 * Created by Rajvaibhav D. Rahane on 26-Jul-18.
 */
public class ChanceDialogFragment extends DialogFragment{
    private int chanceNo;
    public interface ChanceDialogListener{
        void onChanceDialogPositiveClick(DialogFragment dialog,int chanceNo);
        void onChanceDialogNegativeClick(DialogFragment dialog);
    }
    ChanceDialogListener mListener;
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            mListener=(ChanceDialogListener)activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+" must implement ChanceDialogListener");
        }
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Select Chance");
        builder.setSingleChoiceItems(GameConstants.DISPLAY_CHANCE_NOS, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                chanceNo=i;
            }
        });
        builder.setPositiveButton("Play", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mListener.onChanceDialogPositiveClick(ChanceDialogFragment.this,chanceNo);
                    }
        });
        builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mListener.onChanceDialogNegativeClick(ChanceDialogFragment.this);
                    }
        });
        return builder.create();
    }
}
