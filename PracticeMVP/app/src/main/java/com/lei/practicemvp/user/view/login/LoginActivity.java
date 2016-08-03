package com.lei.practicemvp.user.view.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.lei.practicemvp.R;
import com.lei.practicemvp.bean.User;
import com.lei.practicemvp.user.presenter.LoginPresenter;
import com.lei.practicemvp.user.view.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements IUserLoginView,View.OnClickListener{
    private static String TAG="LoginActivity";
    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnClear;
    private TextView mTvRegister;
    private ProgressBar mPbLoading;
    private LoginPresenter mUserLoginPresenter = new LoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView(){
        mTvRegister=(TextView)findViewById(R.id.tvRegister);
        mTvRegister.setOnClickListener(this);
        mBtnLogin=(Button)findViewById(R.id.btnLogin);
        mBtnLogin.setOnClickListener(this);
        mBtnClear=(Button)findViewById(R.id.btnClear);
        mBtnClear.setOnClickListener(this);
        mEtUsername=(EditText)findViewById(R.id.etName);
        mEtPassword=(EditText)findViewById(R.id.etPassWord);
        mPbLoading=(ProgressBar)findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                mUserLoginPresenter.login();
                break;
            case R.id.btnClear:
                mUserLoginPresenter.clear();
                break;
            case R.id.tvRegister:
                Log.i(TAG, "onClick: ");
                mUserLoginPresenter.toJump();
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
        Toast.makeText(LoginActivity.this,"success",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(LoginActivity.this,"fail",Toast.LENGTH_LONG).show();
    }

    @Override
    public void toRegisterActivity() {
        Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
