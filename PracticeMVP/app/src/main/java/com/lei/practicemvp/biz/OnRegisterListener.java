package com.lei.practicemvp.biz;

import com.lei.practicemvp.bean.User;

/**
 * Created by CCC on 2016/7/30.
 */
public interface OnRegisterListener {

    void registerSuccess(User user);

    void registerFailed();

}
