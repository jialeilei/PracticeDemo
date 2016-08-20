package com.lei.phonenumber;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    private String TAG="MainActivity";
    private ListView listView;
    private MyAdapter myAdapter;
    private TextView tvSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        listView = (ListView)findViewById(R.id.lv);
        tvSearch = (TextView) findViewById(R.id.tvSearch);
        tvSearch.setOnClickListener(this);
    }

    private void showData(){
        GetNumber.getNumber(this);
        myAdapter = new MyAdapter(GetNumber.list,this);
        listView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.tvSearch:
                showData();
                break;

            default:

                break;
        }
    }
}
