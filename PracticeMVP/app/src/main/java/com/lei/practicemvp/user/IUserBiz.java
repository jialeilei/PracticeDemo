package com.lei.practicemvp.user;

/**
 * Created by CCC on 2016/7/30.
 */
public interface IUserBiz {
    void login(String username, String password, OnLoginListener loginListener);
    void register(String username,String password,OnRegisterListener registerListener);
}
