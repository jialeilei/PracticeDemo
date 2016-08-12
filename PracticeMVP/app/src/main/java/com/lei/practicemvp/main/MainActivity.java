package com.lei.practicemvp.main;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.lei.practicemvp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView imgSlide;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        imgSlide=(ImageView)findViewById(R.id.imgLeft);
        imgSlide.setOnClickListener(this);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgLeft:
                mDrawerLayout.openDrawer(Gravity.LEFT);
                break;
        }
    }
}
