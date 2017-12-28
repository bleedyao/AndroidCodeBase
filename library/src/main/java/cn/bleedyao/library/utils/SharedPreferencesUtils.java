package cn.bleedyao.library.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Yaoluhao on 2016/6/3.
 */
public class SharedPreferencesUtils {

    private static SharedPreferences sp;

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getBoolean(key,defValue);
    }
    public static void setBoolean(Context context, String key, boolean value) {
        sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean(key,value);
        edit.apply();
    }
    public static String getString(Context context, String key, String defValue) {
        sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getString(key,defValue);
    }
    public static void setString(Context context, String key, String value) {
        sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key,value);
        edit.apply();
    }

    public static int getInt(Context context, String key, int defValue) {
        sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getInt(key,defValue);
    }
    public static void setInt(Context context, String key, int value) {
        sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putInt(key,value);
        edit.apply();
    }

    public static void setPswString(Context context, String key, String value){
        sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(key,value);
        edit.apply();
    }

    public static String getPswString(Context context, String key, String defValue) {
        sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getString(key,defValue);
    }
}
