package com.lei.practicemvp.user.presenter;

import android.content.Context;
import android.os.Handler;

import com.lei.practicemvp.Constant.Constants;
import com.lei.practicemvp.bean.User;
import com.lei.practicemvp.user.IUserBiz;
import com.lei.practicemvp.user.OnLoginListener;
import com.lei.practicemvp.user.UserBiz;
import com.lei.practicemvp.user.view.login.IUserLoginView;

/**
 * Created by CCC on 2016/7/30.
 */
public class LoginPresenter {

    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public LoginPresenter(IUserLoginView iUserLoginView){
        this.userLoginView=iUserLoginView;
        this.userBiz=new UserBiz();
    }

    public void login(Context context){
        userLoginView.showLoading();
        userBiz.login(context,userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess() {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Constants.USER_NAME=userLoginView.getUserName();
                        userLoginView.hideLoading();
                        userLoginView.toMainActivity();
                    }
                });
            }

            @Override
            public void loginFailed() {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });

            }
        });
    }

    public void clear(){
        userLoginView.clearPassword();
        userLoginView.clearUserName();
    }

    public void toJump(){
        userLoginView.toRegisterActivity();
    }

}
