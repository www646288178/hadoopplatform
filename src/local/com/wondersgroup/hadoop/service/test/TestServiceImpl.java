package com.wondersgroup.hadoop.service.test;

import com.wondersgroup.hadoop.configration.common.CommonCode;
import com.wondersgroup.hadoop.configration.datasource.MultiDataSourceHolder;
import com.wondersgroup.hadoop.dao.test.TestDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lenovo on 2018/2/27.
 */
@Service
@Transactional
public class TestServiceImpl implements TestService {
    private final static Logger logger = Logger.getLogger(TestServiceImpl.class);
    @Autowired
    private TestDao testDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void TestMutiDataSource() {
        MultiDataSourceHolder.setDataSource(CommonCode.MULTI_DATA_SOURCE_DEFAULT);
        int count = testDao.selectCountTest();
        logger.info("------------------[CURRENT DATASOURCE IS:"+ MultiDataSourceHolder.getDataSource()+"&&" +
                "RESULTSET IS :"+count+"]---------------------");

        testDao.insertInto(199);
//        throw new RuntimeException("回滚事务");
    }

//    @Transactional(propagation = Propagation.REQUIRED)
    public void TestMultDataSourceOracle() {
//        MultiDataSourceHolder.setDataSource(CommonCode.MULTI_DATA_SOURCE_BUSINESS);//同一个service方法，datasource只确定一次，即在第一次执行sql或这个方法的时候确定，后面即使调用方法也不会改变
        int count = testDao.selectCountTest();
        logger.info("------------------[CURRENT DATASOURCE IS:"+ MultiDataSourceHolder.getDataSource()+"&&" +
                "RESULTSET IS :"+count+"]---------------------");
        testDao.insertInto(9999);
//        throw new RuntimeException("回滚事务");
    }

    public void TestMultDataSourceDefault() {
        int count = testDao.selectCountTest();
        logger.info("------------------[CURRENT DATASOURCE IS:"+ MultiDataSourceHolder.getDataSource()+"&&" +
                "RESULTSET IS :"+count+"]---------------------");
    }
}
