package com.lei.practicemvp.biz;


import com.lei.practicemvp.bean.User;
import com.lei.practicemvp.dbHelper.UserManager;


/**
 * Created by CCC on 2016/7/30.
 */
public class UserBiz implements IUserBiz {

    UserManager mUserManager;

    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
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
                //模拟登录成功
                if ("zhy".equals(username) && "123".equals(password))
                {
                    User user = new User(username,password);
                    loginListener.loginSuccess(user);
                } else
                {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }


    @Override
    public void register(final String username, final String password, final OnRegisterListener registerListener) {
        //插入数据库
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }

                mUserManager.insertUser(username,password);
                //模拟登录成功
                if ("zhy".equals(username) && "123".equals(password))
                {
                    User user = new User(username,password);
                    registerListener.registerSuccess(user);
                } else
                {
                    registerListener.registerFailed();
                }
            }
        }.start();
    }

}
