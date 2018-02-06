package com.haocai.haocaisqlite.dao;

import com.haocai.haocaisqlite.db.BaseDao;

import java.util.List;

/**
 * Created by Xionghu on 2018/2/3.
 * Desc:
 */

public class UserDao extends BaseDao {

    @Override
    protected String createTable() {
        return "create table if not exists tb_user(userId int,name varchar(20),password varchar(20))";
    }

}
