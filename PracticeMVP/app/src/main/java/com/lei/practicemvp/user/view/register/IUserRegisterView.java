package com.lei.practicemvp.user.view.register;

import com.lei.practicemvp.bean.User;

/**
 * Created by lei on 2016/7/30.
 */
public interface IUserRegisterView {

    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toLoginActivity();

    void showFailedMessage();

    void showSuccessMessage();

}
