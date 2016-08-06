package com.lei.practiceslidingmenu;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

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
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);

        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvTest:
                mDrawerLayout.openDrawer(Gravity.LEFT);
                break;
        }
    }
}

