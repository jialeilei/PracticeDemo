package com.lei.practicemvp.user;

import com.lei.practicemvp.bean.User;

/**
 * Created by CCC on 2016/7/30.
 */
public interface OnLoginListener {

    void loginSuccess(User user);

    void loginFailed();

}
