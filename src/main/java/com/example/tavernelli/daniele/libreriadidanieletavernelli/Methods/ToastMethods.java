package com.example.tavernelli.daniele.libreriadidanieletavernelli.Methods;

import android.content.Context;
import android.widget.Toast;



public class ToastMethods {

    //TOAST
    public static void showShortToast(Context context, String message) {
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

}
