package com.xty.service;

import com.xty.service.impl.GoodsServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoodsServiceTest {

    @Test
    public void addGoods() {

        boolean b = new GoodsServiceImpl().addGoods("旺仔奶糖", 9.9, 50);


    }
}