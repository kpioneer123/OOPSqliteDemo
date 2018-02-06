package com.haocai.haocaisqlite.bean;

import com.haocai.haocaisqlite.db.annotion.DbFiled;
import com.haocai.haocaisqlite.db.annotion.DbTable;

/**
 * Created by Xionghu on 2018/2/5.
 * Desc:
 */

@DbTable("tb_file")
public class FileBean {
    @DbFiled("time")
    public String time;
    @DbFiled("path")
    public String path;
    @DbFiled("description")
    public String description;

    public FileBean(String time, String path, String description) {
        this.time = time;
        this.path = path;
        this.description = description;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
