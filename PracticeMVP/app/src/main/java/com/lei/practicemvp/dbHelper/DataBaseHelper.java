package com.lei.practicemvp.dbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 磊 on 2016/8/1.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    private Context mContext;
    private final String TAG="DataBaseHelper";

    public static final String CREATE_TABLE="create table user ("
            +"id integer primary key autoincrement, "
            +"username text, "
            +"password text ) ";

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.i(TAG, "data base is created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
