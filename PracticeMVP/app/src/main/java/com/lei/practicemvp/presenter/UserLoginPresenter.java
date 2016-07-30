package com.lei.practicemvp.presenter;

import android.os.Handler;

import com.lei.practicemvp.bean.User;
import com.lei.practicemvp.biz.IUserBiz;
import com.lei.practicemvp.biz.OnLoginListener;
import com.lei.practicemvp.biz.UserBiz;
import com.lei.practicemvp.view.IUserLoginView;

/**
 * Created by CCC on 2016/7/30.
 */
public class UserLoginPresenter {

    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView iUserLoginView){
        this.userLoginView=iUserLoginView;
        this.userBiz=new UserBiz();
    }

    public void login(){
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
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

    public void toRegister(){
        userLoginView.toRegisterActivity();
    }

}
