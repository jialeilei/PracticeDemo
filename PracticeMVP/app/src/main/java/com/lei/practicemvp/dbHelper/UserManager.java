package com.lei.practicemvp.dbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.lei.practicemvp.bean.User;
import com.lei.practicemvp.util.LogTools;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 磊 on 2016/8/1.
 */

public class UserManager implements IUserManager{
    private Context mContext;
    private DataBaseHelper dbHelper;
    private final String TAG="UserManager";

    public UserManager(Context context){
        mContext=context;
        dbHelper=new DataBaseHelper(mContext,"user.db",null,1);
    }


    public void insertUser(String name,String password){
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("username",name);
        values.put("password", password);
        db.insert("user", null, values);
        db.close();
        LogTools.logLei(TAG,"insert  user success");
    }

    public List<User> getUser(String username){
        List<User> users=new ArrayList<User>();
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        Cursor cursor=db.query("user",null," username=? ",new String[]{String.valueOf(username)},null,null,null);
        if (cursor.moveToFirst()){
            do {
                String name=cursor.getString(cursor.getColumnIndex("username"));
                String password=cursor.getString(cursor.getColumnIndex("password"));
                users.add(new User(name,password));
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return users;
    }


}
