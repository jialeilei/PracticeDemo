package com.lei.phonenumber;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.Contacts;
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
        if (list.size()>0) {
            list.clear();
        }
        ContentResolver cr = context.getContentResolver();
        //取得电话本中开始一项的光标
        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        String PhoneNumber="";
        String name;
        //向下移动光标
        while(cursor.moveToNext())
        {
            //取得联系人名字
            name = cursor.getString(cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME));
            //取得电话号码
            String ContactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            Cursor phone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + ContactId, null, null);

            while(phone.moveToNext())
            {
                PhoneNumber = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                //格式化手机号
                PhoneNumber = PhoneNumber.replace("-","");
                PhoneNumber = PhoneNumber.replace(" ","");
            }
            list.add(new PhoneInfo(name, PhoneNumber));
            //Log.i(TAG, "name: "+name+" number: "+PhoneNumber);
        }

        return null;
    }

}
