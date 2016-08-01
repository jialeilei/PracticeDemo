package com.lei.practicemvp.dbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by 磊 on 2016/8/1.
 */
public class UserManager {
    private Context mContext;
    private DataBaseHelper dbHelper;

    public UserManager(Context context){
        mContext=context;
    }

    public void insertUser(String name,String password){
        dbHelper=new DataBaseHelper(mContext,"user.db",null,1);
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("username",name);
        values.put("password",password);
        db.insert("user",null,values);
    }

}
