package com.lei.practicemvp.application;

import android.util.Log;

import org.xutils.DbManager;
import org.xutils.x;

import java.io.File;

/**
 * Created by CCC on 2016/8/18.
 */
public class Application extends android.app.Application {

    private  final static  String TAG = "Application";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "application create ");
        x.Ext.init(this);
        x.Ext.setDebug(true);// 开启debug会影响性能


    }


}
