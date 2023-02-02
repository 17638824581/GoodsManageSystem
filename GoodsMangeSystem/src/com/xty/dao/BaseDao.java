package com.xty.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * BaseDAO 类中需要提供通用的对于 数据表的操作的方法
 */
public class BaseDao {

    // 通用的执行 增、删、改 的sql的方法
    public int update(Connection conn,String sql,Object... args){
        // 直接使用 bdUtils 中的 QueryRunner 类所提供的方法来执行sql语句。
        QueryRunner queryRunner = new QueryRunner();
        int update = 0;
        try {
            update = queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return update;
    }

    // 通用的执行 查询单条数据的 方法
    public <T> T queryOne(Class<T> clazz,Connection conn,String sql,Object... args){
        QueryRunner queryRunner = new QueryRunner();
        T query = null;
        try {
            query = queryRunner.query(conn, sql, new BeanHandler<>(clazz), args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return query;
    }

    // 通用的执行 查询多条数据的 方法
    public <T> List<T> queryAll(Class<T> clazz, Connection conn, String sql, Object... args){
        List<T> query = null;
        try {
            query = new QueryRunner().query(conn, sql, new BeanListHandler<>(clazz), args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return query;
    }

    //通用的执行 查询单个值 的方法
    public Object queryValue(Connection conn, String sql, Object... args){
        Object query = null;
        try {
            query = new QueryRunner().query(conn, sql, new ScalarHandler<>(), args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return query;
    }



}
