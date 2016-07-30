package com.lei.practicemvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.lei.practicemvp.R;
import com.lei.practicemvp.bean.User;
import com.lei.practicemvp.presenter.UserLoginPresenter;

public class RegisterActivity extends AppCompatActivity implements IUserLoginView{
    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnClear;
    private ProgressBar mPbLoading;
    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView(){
        mBtnLogin=(Button)findViewById(R.id.btnLogin);
        mBtnClear=(Button)findViewById(R.id.btnClear);
        mEtUsername=(EditText)findViewById(R.id.etName);
        mEtPassword=(EditText)findViewById(R.id.etPassWord);
        mPbLoading=(ProgressBar)findViewById(R.id.progressBar);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.login();
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.clear();
            }
        });

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
        Toast.makeText(RegisterActivity.this, "success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(RegisterActivity.this,"fail",Toast.LENGTH_LONG).show();
    }
}
