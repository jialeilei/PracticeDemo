package com.lei.practicemvp.dbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.lei.practicemvp.bean.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 磊 on 2016/8/1.
 */
public class UserManager {
    private Context mContext;
    private DataBaseHelper dbHelper;
    private final String TAG="UserManager";

    public UserManager(Context context){
        mContext=context;
        //dbHelper=new DataBaseHelper(mContext);
        //dbHelper=new DataBaseHelper(mContext,"user.db",null,1);
    }

    public void insertUser(String name,String password){
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("username",name);
        values.put("password",password);
        db.insert("user", null, values);
        db.close();
        Log.i(TAG, "insert User ");
    }

    public List<User> getUser(){
        List<User> users=new ArrayList<User>();
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        Cursor cursor=db.query("user",null,null,null,null,null,null);
        if (cursor.moveToFirst()){
            do {
                String name=cursor.getString(cursor.getColumnIndex("username"));
                String password=cursor.getString(cursor.getColumnIndex("password"));
                users.add(new User(name,password));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return users;
    }

}
