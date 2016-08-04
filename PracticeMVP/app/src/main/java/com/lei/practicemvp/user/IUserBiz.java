package com.lei.practicemvp.user;

import android.content.Context;

/**
 * Created by CCC on 2016/7/30.
 */
public interface IUserBiz {

    void login(String username, String password, OnLoginListener loginListener);

    void register(Context context,String username,String password,OnRegisterListener registerListener);

}
