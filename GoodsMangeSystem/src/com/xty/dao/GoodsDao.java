package com.xty.dao;

import com.xty.bean.Goods;

import java.util.List;

public interface GoodsDao {

    // 1.向 goods 表中添加数据
    boolean addGoods(String name,double prise, int count);

    // 2.查询 goods 表所有数据
    List<Goods> getAllGoods();

    // 3. 根据商品名查询数据
    Goods queryByName(String name);

    // 4. 根据商品编号查询数据
    Goods queryById(int id);

    // 5. 通过商品名删除数据
    boolean removeByName(String name);

    // 6. 通过商品编号删除数据
    boolean removeById(int id);

    // 7. 通过商品编号修改商品信息
    boolean updateGoods(int id,Goods newGoods);

}
