package com.lei.practicemvp.dbHelper;

import org.xutils.DbManager;
import org.xutils.x;

/**
 * Created by CCC on 2016/8/18.
 */
public class DetailManager extends UtilsDataBase{


    DbManager dbManager;
    public DetailManager(){
        dbManager= x.getDb(BB.getDaoConfig());
    }



}
