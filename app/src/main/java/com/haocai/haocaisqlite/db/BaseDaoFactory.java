package com.haocai.haocaisqlite.db;

import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

/**
 * Created by Xionghu on 2018/2/2.
 * Desc:
 */

public class BaseDaoFactory {

    private static BaseDaoFactory instance = new BaseDaoFactory();

    private String sqliteDatabasePath;

    private SQLiteDatabase sqLiteDatabase;

    public BaseDaoFactory() {
        sqliteDatabasePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/teacher.db";
        openDatabase();
    }

    public static BaseDaoFactory getInstance() {
        return instance;
    }

    public synchronized <T extends BaseDao<M>, M> T getDataHelper(Class<T> clazz, Class<M> entityClass) {
        BaseDao baseDao = null;
        try {
            baseDao = clazz.newInstance();
            baseDao.init(entityClass, sqLiteDatabase);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (T) baseDao;
    }
    /**
     *  targetSdkVersion  大于22时 要申请存储读写权限
     */
    //打开数据库操作
    private void openDatabase() {

        this.sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(sqliteDatabasePath, null);
    }
}
