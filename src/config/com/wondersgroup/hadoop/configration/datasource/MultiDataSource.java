package com.wondersgroup.hadoop.configration.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by lenovo on 2018/2/27.
 */
public class MultiDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return MultiDataSourceHolder.getDataSource();
    }
}
