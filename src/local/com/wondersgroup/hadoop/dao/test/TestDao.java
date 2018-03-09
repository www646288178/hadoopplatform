package com.wondersgroup.hadoop.dao.test;

import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2018/2/27.
 */
@Repository
public interface TestDao {
    public int selectCountTest();

    public void insertInto(int col1);
}
