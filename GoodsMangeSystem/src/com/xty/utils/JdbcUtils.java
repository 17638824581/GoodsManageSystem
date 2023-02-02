package com.xty.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/*
*   提供一些关于获取数据库连接，以及关闭数据库连接的方法
* */
public class JdbcUtils {

    private static DataSource ds;

    static {
        // 创建数据库连接池，初始化ds
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("druidConfig.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 获取数据库连接的方法
    public static Connection getConntion(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 关闭数据库连接的方法
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
