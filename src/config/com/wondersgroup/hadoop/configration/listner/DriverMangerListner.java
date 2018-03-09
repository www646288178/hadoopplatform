package com.wondersgroup.hadoop.configration.listner;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * Created by lenovo on 2018/2/27.
 */
public class DriverMangerListner implements ServletContextListener {
    private final static Logger logger = Logger.getLogger(DriverMangerListner.class);
    public void contextInitialized(ServletContextEvent sce) {

    }

    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("[DriverMangerListner]:-------DriverManager deregisterDriver start...");
        com.mysql.jdbc.AbandonedConnectionCleanupThread.uncheckedShutdown();
        Enumeration<Driver> enumeration = DriverManager.getDrivers();
        while (enumeration.hasMoreElements()) {
            try {
                DriverManager.deregisterDriver(enumeration.nextElement());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        logger.debug("[DriverMangerListner]:-------DriverManager deregisterDriver end...");
    }
}
