package com.lei.practicemvp.user.view.login;

import com.lei.practicemvp.bean.User;

/**
 * Created by lei on 2016/7/30.
 */
public interface IUserLoginView {

    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();

    void toRegisterActivity();
}
