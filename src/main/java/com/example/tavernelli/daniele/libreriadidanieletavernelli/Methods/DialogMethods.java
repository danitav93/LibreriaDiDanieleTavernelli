package com.example.tavernelli.daniele.libreriadidanieletavernelli.Methods;


import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

public class DialogMethods {

    public static void createMessageAlertDialog(Context context, String message, Integer titleResourceStringId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        if (titleResourceStringId!=null) {
            builder.setTitle(titleResourceStringId);
        }
        builder.create().show();
    }

    public static void createBaseYesOrNoDialog(Context context, String message, DialogInterface.OnClickListener dialogClickListener ) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message).setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
    }


}
