package com.lei.practicemvp.user;

import android.content.Context;
import com.lei.practicemvp.dbHelper.UserManager;
import com.lei.practicemvp.util.LogTools;


/**
 * Created by CCC on 2016/7/30.
 */
public class UserBiz implements IUserBiz {

    UserManager mUserManager;
    private final String TAG="UserBiz";

    @Override
    public void login(final Context context,final String username, final String password, final OnLoginListener loginListener) {
        //模拟子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                mUserManager=new UserManager(context);
                if (mUserManager.getUser(username).size()>0){
                    if (mUserManager.getUser(username).get(0).getPassWord().equals(password)){
                        loginListener.loginSuccess();
                    }
                }else {
                    loginListener.loginFailed();
                }

            }
        }.start();
    }


    @Override
    public void register(final Context context,final String username, final String password, final OnRegisterListener registerListener) {

        //插入数据库
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }

                mUserManager=new UserManager(context);
                if (mUserManager.getUser(username).size()>0){
                    registerListener.registerFailed();
                }else {
                    mUserManager.insertUser(username,password);
                    LogTools.logLei(TAG,"username: "+username+" password: "+password);
                    registerListener.registerSuccess();
                }

            }
        }.start();
    }

}
