package com.example.tavernelli.daniele.libreriadidanieletavernelli.Methods;


import android.content.Context;
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


}
