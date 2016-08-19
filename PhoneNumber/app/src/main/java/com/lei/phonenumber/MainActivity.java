package com.lei.phonenumber;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

    private ListView listView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){

        GetNumber.getNumber(this);
        listView = (ListView)findViewById(R.id.lv);
        myAdapter = new MyAdapter(GetNumber.list,this);
        listView.setAdapter(myAdapter);
    }


}
