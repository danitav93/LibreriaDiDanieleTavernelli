package com.example.tavernelli.daniele.libreriadidanieletavernelli.Methods;

import android.app.Activity;
import android.content.Intent;

import java.io.Serializable;

/**
 * Created by Daniele on 14/10/2017.
 */

public class IntentMethods {

    //comincia una nuova activity
    public static void startActivity (Activity actualActivity, Class newActivity) {
        Intent intent = new Intent(actualActivity,newActivity);
        actualActivity.startActivity(intent);
    }

    //comincia una nuova activity inserendo degli argomenti
    public static void startActivityWithExtra (Activity actualActivity, Class newActivity, String extraTag, Serializable extra) {
        Intent intent = new Intent(actualActivity,newActivity);
        intent.putExtra(extraTag,extra);
        actualActivity.startActivity(intent);
    }

    //comincia una nuova activity terminando l'auutale
    public static void startActivityFinishActual (Activity actualActivity, Class newActivity) {
        Intent intent = new Intent(actualActivity,newActivity);
        actualActivity.startActivity(intent);
        actualActivity.finish();
    }

    //comincia una nuova activity inserendo degli argomenti e finendo l'attuale
    public static void startActivityWithExtraFinishActual (Activity actualActivity, Class newActivity, String extraTag, Serializable extra) {
        Intent intent = new Intent(actualActivity,newActivity);
        intent.putExtra(extraTag,extra);
        actualActivity.startActivity(intent);
        actualActivity.finish();
    }




}
