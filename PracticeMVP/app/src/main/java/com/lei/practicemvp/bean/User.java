package com.lei.practicemvp.bean;

/**
 * Created by CCC on 2016/7/30.
 */

public class User {
    private String userName;
    private String passWord;

    public User(String userName,String passWord){
        this.userName=userName;
        this.passWord=passWord;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
