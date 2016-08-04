package com.lei.practicemvp.dbHelper;

import com.lei.practicemvp.bean.User;

import java.util.List;

/**
 * Created by CCC on 2016/8/3.
 */
public interface IUserManager {

    void insertUser(String name,String password);

    List<User> getUser(String username);

}
