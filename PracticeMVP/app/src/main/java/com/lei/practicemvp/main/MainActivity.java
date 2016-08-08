package com.lei.practicemvp.main;

import android.app.Dialog;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lei.practicemvp.Constant.Constants;
import com.lei.practicemvp.R;
import com.lei.practicemvp.util.CircleImage;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,IMainView{
    private ImageView imgSlide;
    private DrawerLayout mDrawerLayout;
    private CircleImage imgHead;
    private TextView tvName;
    private MainPresenter mMainPresenter=new MainPresenter(this);

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
        imgHead=(CircleImage)findViewById(R.id.imgHead);
        imgHead.setOnClickListener(this);
        tvName=(TextView)findViewById(R.id.tvName);
        mMainPresenter.showUserInfo();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgLeft:
                mDrawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.imgHead:
                chooseHeadDialog();
                break;
        }
    }

    @Override
    public void setUserInfo() {
        tvName.setText(Constants.USER_NAME);
    }

    private void chooseHeadDialog() {
        View  view = getLayoutInflater().inflate(R.layout.photo_choose_dialog, null);
        final Dialog dialog = new Dialog(MainActivity.this, R.style.transparentFrameWindowStyle);
        dialog.setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.x = 0;
        //changed
        wl.y = getWindowManager().getDefaultDisplay().getHeight();
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        dialog.onWindowAttributesChanged(wl);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
        Button btnGallery=(Button)view.findViewById(R.id.btnGallery);
        btnGallery.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //choseHeadImageFromGallery();
                dialog.cancel();
            }
        });

        Button btnCamera=(Button)view.findViewById(R.id.btncamera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dialog.cancel();
            }
        });
        Button btnCancel=(Button)view.findViewById(R.id.btncancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                dialog.cancel();
            }
        });
    }

}
