package com.wondersgroup.hadoop.controller.test;

import com.wondersgroup.hadoop.configration.common.CommonCode;
import com.wondersgroup.hadoop.configration.datasource.MultiDataSourceHolder;
import com.wondersgroup.hadoop.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lenovo on 2018/2/27.
 */
@Controller
@RequestMapping("/test/")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("TestMultDataSource.action")
    public String TestMultDataSource() {
        testService.TestMutiDataSource();
        return "login";
    }

    @RequestMapping("TestMultDataSourceOracle.action")
    public String TestMultDataSourceOracle() {
        MultiDataSourceHolder.setDataSource(CommonCode.MULTI_DATA_SOURCE_BUSINESS);
        testService.TestMultDataSourceOracle();
        return "login";
    }

    @RequestMapping("TestMultDataSourceDefault.action")
    public String TestMultDataSourceDefault() {
        testService.TestMultDataSourceDefault();
        return "login";
    }

    @RequestMapping("mainFrame.action")
    public String mainFrame() {
        return "mainFrame";
    }

    @RequestMapping("logout.action")
    public String logout() {
        return "login";
    }
}
