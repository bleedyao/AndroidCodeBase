package cn.bleedyao.library.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

public class SingleToast {
    private static Toast toast;

    private SingleToast(){}

    @SuppressLint("ShowToast")
    public static void showToastShort(Context context, String text) {
        if (toast == null) {
            toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        }
        toast.setText(text);
        toast.show();
    }

    @SuppressLint("ShowToast")
    public static void showToastLong(Context context, String text) {
        if (toast == null) {
            toast = Toast.makeText(context, "", Toast.LENGTH_LONG);
        }
        toast.setText(text);
        toast.show();
    }

}
