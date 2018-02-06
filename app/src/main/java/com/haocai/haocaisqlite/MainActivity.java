package com.haocai.haocaisqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.haocai.haocaisqlite.bean.User;
import com.haocai.haocaisqlite.dao.UserDao;
import com.haocai.haocaisqlite.db.BaseDaoFactory;
import com.haocai.haocaisqlite.db.IBaseDao;

import java.util.List;


/**
 *
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Main";
    IBaseDao<User> baseDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseDao = BaseDaoFactory.getInstance().getDataHelper(UserDao.class, User.class);

    }

    public void save(View view) {

        for (int i = 0; i < 20; i++) {
            User user = new User(i, "teacher", "123456");
            baseDao.insert(user);
        }

/**
 *写入文件数据
 */
//        BaseDao<FileBean> fileBeanBaseDao = BaseDaoFactory.getInstance().getDataHelper(FileDao.class, FileBean.class);
//        fileBeanBaseDao.insert(new FileBean("2019-12-13", Environment.getExternalStorageDirectory() + "/kpioneer", "asdfg"));

    }

    public void update(View view) {
        for (int i = 10; i < 20; i++) {
            User where = new User();
            where.setUserId(i);
            User user = new User(i, "kpioneer", "8888");

            //更新原name = teacher的数据
            baseDao.update(user, where);
        }

    }

    public void delete(View view) {
        User user = new User();
        user.setName("teacher");
        baseDao.delete(user);
    }

    public void query(View view) {
        User where = new User();
        where.setName("teacher");
        List<User> list = baseDao.query(where);

        Log.i(TAG, "查询到 " + list.size() + " 条数据");
        for (User user : list) {
            Log.i(TAG, user.toString());
        }

        System.out.println("--------查询某条数据-------");
        User where2 = new User();
        where2.setName("teacher");
        where2.setUserId(5);
        List<User> list2 = baseDao.query(where2);
        Log.i(TAG, "查询到 " + list2.size() + " 条数据");
    }

    public void queryAll(View view) {
        List<User> list = baseDao.query(new User());

        Log.i(TAG, "查询到 " + list.size() + " 条数据");
        for (User user : list) {
            Log.i(TAG, user.toString());
        }

    }
}
