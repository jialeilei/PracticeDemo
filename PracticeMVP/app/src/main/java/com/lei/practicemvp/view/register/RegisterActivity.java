package com.lei.practicemvp.view.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lei.practicemvp.R;
import com.lei.practicemvp.bean.User;
import com.lei.practicemvp.presenter.RegisterPresenter;

public class RegisterActivity extends AppCompatActivity implements IUserRegisterView ,View.OnClickListener{

    private static String TAG="RegisterActivity";
    private EditText mEtUsername, mEtPassword;
    private Button mBtnRegister, mBtnClear;
    private ProgressBar mPbLoading;
    private RegisterPresenter mRegisterPresenter = new RegisterPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView(){
        mBtnRegister=(Button)findViewById(R.id.btnRegister);
        mBtnRegister.setOnClickListener(this);
        mBtnClear=(Button)findViewById(R.id.btnClear);
        mBtnClear.setOnClickListener(this);
        mEtUsername=(EditText)findViewById(R.id.etName);
        mEtPassword=(EditText)findViewById(R.id.etPassWord);
        mPbLoading=(ProgressBar)findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegister:
                mRegisterPresenter.register();
                break;
            case R.id.btnClear:
                mRegisterPresenter.clear();
                break;

        }
    }

    @Override
    public void clearPassword() {
        mEtPassword.setText("");
    }

    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUserName() {
        mEtUsername.setText("");
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {

    }

    @Override
    public void showFailedMessage() {
        Toast.makeText(RegisterActivity.this,"fail",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSuccessMessage() {
        Toast.makeText(RegisterActivity.this,"success",Toast.LENGTH_LONG).show();
    }
}
