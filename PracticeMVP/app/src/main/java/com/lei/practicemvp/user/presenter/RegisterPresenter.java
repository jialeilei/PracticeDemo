package com.lei.practicemvp.user.presenter;

import android.content.Context;
import android.os.Handler;
import com.lei.practicemvp.user.IUserBiz;
import com.lei.practicemvp.user.OnRegisterListener;
import com.lei.practicemvp.user.UserBiz;
import com.lei.practicemvp.user.view.register.IUserRegisterView;

/**
 * Created by CCC on 2016/7/30.
 */
public class RegisterPresenter {

    private IUserBiz userBiz;
    private IUserRegisterView userRegisterView;
    private Handler mHandler = new Handler();

    public RegisterPresenter(IUserRegisterView iUserLoginView){
        this.userRegisterView=iUserLoginView;
        this.userBiz=new UserBiz();
    }

    public void clear(){
        userRegisterView.clearPassword();
        userRegisterView.clearUserName();
    }

    public void register(Context context){
        userRegisterView.showLoading();
        userBiz.register(context,userRegisterView.getUserName(), userRegisterView.getPassword(), new OnRegisterListener() {
            @Override
            public void registerSuccess() {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userRegisterView.showSuccessMessage();
                        userRegisterView.hideLoading();
                        userRegisterView.toLoginActivity();
                    }
                });

            }

            @Override
            public void registerFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userRegisterView.showFailedMessage();
                        userRegisterView.hideLoading();
                    }
                });
            }
        });
    }

}
