package com.haocai.haocaisqlite.dao;

import com.haocai.haocaisqlite.db.BaseDao;

/**
 * Created by Xionghu on 2018/2/5.
 * Desc:
 */

public class FileDao extends BaseDao {
    @Override
    protected String createTable() {
        return "create table if not exists tb_file(time varchar(20),path varchar(20),description varchar(20))";
    }
}
