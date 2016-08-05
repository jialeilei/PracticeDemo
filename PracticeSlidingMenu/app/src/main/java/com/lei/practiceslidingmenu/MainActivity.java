package com.lei.practiceslidingmenu;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private DrawerLayout mDrawerLayout;
    private TextView tvControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView(){
        tvControl=(TextView)findViewById(R.id.tvTest);
        tvControl.setOnClickListener(this);
       /* mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerLayout.get*/


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvTest:

                break;
        }
    }

    /*@Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
        returnsuper.onPrepareOptionsMenu(menu);
    }*/

}
