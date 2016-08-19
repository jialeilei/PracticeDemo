package com.lei.phonenumber;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CCC on 2016/8/17.
 */

public class GetNumber {
    private static String TAG="GetNumber";
    public static List<PhoneInfo> list = new ArrayList<PhoneInfo>();

    public static String getNumber(Context context){
        Cursor cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        String phoneNumber;
        String name;
        if (cursor !=null){
            while (cursor.moveToNext()){
                phoneNumber = cursor.getColumnName(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                name = cursor.getColumnName(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                list.add(new PhoneInfo(name,phoneNumber));
                Log.i(TAG, "name: "+name+ " number: "+phoneNumber);
            }
        }

        return null;
    }

}
