package com.example.tavernelli.daniele.libreriadidanieletavernelli.Methods;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Display;

import java.io.ByteArrayOutputStream;



public class LayoutMethods {
    //ritorna i dp dati i pixel
    public static float fromPixelToDp(Context c, float pixel) {
        float density = c.getResources().getDisplayMetrics().density;
        return pixel / density;
    }

    //ritorna un array di byte data un drawable
    public static byte[] fromDrawableToByteArray(Drawable drawable) {
        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    //ritorna un Bitmap from array di byte
    public static Bitmap fromByteArrayToBitmap(byte[] byteArray) {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    //ritorna drawable from array di Byte
    public static Drawable fromByteArrayToDrawable(Context context,byte[] byteArray) {
        return new BitmapDrawable(context.getResources(),BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length));
    }

    //ritorna l'altezza dello schermo
    public static float getScreenHeight(Activity c) {
        Display display = c.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }

    //ritorna l'altezza dello schermo
    public static float getScreenWidth(Activity c) {
        Display display = c.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }

    //resize bitmap
    public static Bitmap scaleBitmap(Bitmap bitmap, int targetW, int temporaryH) {

        float percentage;
        percentage = (float) (targetW) / (float) bitmap.getWidth();
        temporaryH = (int)(Math.ceil(bitmap.getHeight() * percentage));
        while (temporaryH> temporaryH) {
            targetW=targetW-1;
            percentage = (float) (targetW) / (float) bitmap.getWidth();
            temporaryH = (int)(Math.ceil(bitmap.getHeight() * percentage));
        }
        return Bitmap.createScaledBitmap(bitmap, targetW, temporaryH, true);

    }
}
