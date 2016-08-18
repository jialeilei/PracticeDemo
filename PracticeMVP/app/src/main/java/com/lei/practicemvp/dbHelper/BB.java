package com.lei.practicemvp.dbHelper;

import org.xutils.DbManager;

/**
 * Created by CCC on 2016/8/18.
 */
public class BB {
    private static DbManager.DaoConfig daoConfig;

    public static DbManager.DaoConfig getDaoConfig(){
        if(daoConfig==null) {
            daoConfig = new DbManager.DaoConfig();
            daoConfig.setDbName("dbTest.db")    //设置数据库名称
                    //.setDbDir(new File(DB_PATH))  //数据库路径
//                .setDbDir(new File("/sdcard/download/"))
                    .setDbVersion(1)  //数据库版本
                    .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                        @Override
                        public void onUpgrade(DbManager db, int oldVersion, int newVersion) {

                        }
                    });
        }
        return daoConfig;

    }
}
