package com.xty.service.impl;

import com.xty.dao.impl.GoodsDaoImpl;
import com.xty.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {
    @Override
    public boolean addGoods(String name, double price, int count) {
        boolean b;
        try {
            b = new GoodsDaoImpl().addGoods(name, price, count);
        }catch (RuntimeException e){
            System.out.println("添加商品名重复！");
            return false;
        }
        return b;
    }
}
