package com.lei.practicemvp.main;

/**
 * Created by lei on 2016/8/8.
 */
public class MainPresenter {

    private IMainView mMainView;

    public MainPresenter(IMainView iMainView){
        this.mMainView=iMainView;
    }

   public void showUserInfo(){
       mMainView.setUserInfo();
   }
}
