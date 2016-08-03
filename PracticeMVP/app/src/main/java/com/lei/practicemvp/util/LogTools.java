package com.lei.practicemvp.util;


import android.util.Log;

/**
 * Created by lei on 2016/8/3.
 */
public class LogTools {

    private static boolean showLog=true;

    public static void logLei(String msg){
        if (showLog){
            Log.i("Lei", msg);
        }
    }
}
