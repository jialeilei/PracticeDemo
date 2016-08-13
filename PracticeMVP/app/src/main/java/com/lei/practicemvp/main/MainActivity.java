package com.lei.practicemvp.main;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
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
import com.lei.practicemvp.util.Common;
import com.lei.practicemvp.util.LogTools;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,IMainView{
    private final String TAG="MainActivity";
    private ImageView imgSlide;
    private DrawerLayout mDrawerLayout;
    private CircleImage imgHead;
    private TextView tvName;
    private Uri imageUri;
    private MainPresenter mMainPresenter=new MainPresenter(this);
    private Common mCommon=new Common();
    private Bitmap bitmap;

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

    private void takePhoto(){
        File outputImage = new File(Environment.getExternalStorageDirectory(),"output_image.jpg");
        try{
            if (outputImage.exists()){
                outputImage.delete();
            }
            outputImage.createNewFile();
        }catch (Exception e){
            e.printStackTrace();
        }
        imageUri = Uri.fromFile(outputImage);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode==RESULT_OK){
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri,"image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                    startActivityForResult(intent,2);
                }
                break;
            case 2:
                if (resultCode==RESULT_OK){
                    try {
                        LogTools.logLei(TAG,"img uri: "+imageUri);
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        LogTools.logLei(TAG,"bitmap count: "+bitmap.getByteCount());
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                        LogTools.logLei(TAG, "bitmap count byte: " + baos.toByteArray().length/1024);

                        Bitmap bitmap2 = mCommon.compressImage(bitmap);
                        //Bitmap bitmap2 = mCommon.comp(bitmap);
                        imgHead.setImageBitmap(bitmap2);
                        bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                        LogTools.logLei(TAG,"result bitmap2 count: "
                                +bitmap2.getByteCount()+" byte: "+baos.toByteArray().length/1024);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    //imgHead.setImageResource(R.mipmap.icon);
                }
                break;
            default:

                break;
        }
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
                takePhoto();
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
