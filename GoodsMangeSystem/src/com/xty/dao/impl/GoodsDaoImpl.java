package com.xty.dao.impl;

import com.xty.bean.Goods;
import com.xty.dao.BaseDao;
import com.xty.dao.GoodsDao;
import com.xty.utils.JdbcUtils;

import java.sql.Connection;
import java.util.List;

public class GoodsDaoImpl extends BaseDao implements GoodsDao {
    @Override
    public boolean addGoods(String name, double prise, int count) {
        Connection conntion = JdbcUtils.getConntion();
        String sql = "insert into `goods`(`name`,`prise`,`count`) values(?,?,?);";
        int update = update(conntion, sql, name, prise, count);
        JdbcUtils.close(conntion);
        return update>=1;
    }

    @Override
    public List<Goods> getAllGoods() {
        Connection conntion = JdbcUtils.getConntion();
        String sql = "select * from `goods`;";
        List<Goods> goods = queryAll(Goods.class, conntion, sql);
        JdbcUtils.close(conntion);

        return goods;
    }

    @Override
    public Goods queryByName(String name) {
        Connection conntion = JdbcUtils.getConntion();
        String sql = "select * from `goods` where `name` = ?;";
        Goods goods = queryOne(Goods.class, conntion, sql, name);
        JdbcUtils.close(conntion);

        return goods;
    }

    @Override
    public Goods queryById(int id) {
        Connection conntion = JdbcUtils.getConntion();
        String sql = "select * from `goods` where `id` = ?;";
        Goods goods = queryOne(Goods.class, conntion, sql, id);
        JdbcUtils.close(conntion);
        return goods;
    }

    @Override
    public boolean removeByName(String name) {
        Connection conntion = JdbcUtils.getConntion();
        String sql = "delete from `goods` where `name` = ?;";
        int update = update(conntion, sql, name);
        JdbcUtils.close(conntion);
        return update>=1;
    }

    @Override
    public boolean removeById(int id) {
        Connection conntion = JdbcUtils.getConntion();
        String sql = "delete from `goods` where `id` = ?;";
        int update = update(conntion, sql, id);
        JdbcUtils.close(conntion);
        return update>=1;
    }

    @Override
    public boolean updateGoods(int id, Goods newGoods) {

        Connection conntion = JdbcUtils.getConntion();
        String sql = "update `goods` set `name` = ?,`prise`=?,`count`=? where `id` = ?;";
        int update = update(conntion, sql, newGoods.getName(),newGoods.getPrise(),newGoods.getCount(),id);
        JdbcUtils.close(conntion);

        return update>=1;
    }
}
