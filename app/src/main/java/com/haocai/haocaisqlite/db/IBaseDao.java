package com.haocai.haocaisqlite.db;

import java.util.List;

/**
 * Created by Xionghu on 2018/2/2.
 * Desc:
 */

public interface IBaseDao<T>{
    /**
     * @param entity
     * @return
     */
    Long insert(T entity);

    /**
     * 更新数据
     * @param entity
     * @param where
     * @return
     */
    int update(T entity,T where);

    /**
     * 删除数据
     * @param where
     * @return
     */
    int delete(T where);

    List<T> query(T where);

    List<T> query(T where,String orderBy,Integer startIndex,Integer limit);
}
