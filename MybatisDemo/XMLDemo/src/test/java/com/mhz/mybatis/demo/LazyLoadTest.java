package com.mhz.mybatis.demo;

import com.mhz.mybatis.demo.mapper.LazyLoadMapper;
import com.mhz.mybatis.demo.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 链接查询测试
 * 一对多 多对一 多对多
 */
@SpringBootTest
public class LazyLoadTest {


    @Resource
    private LazyLoadMapper lazyLoadMapper;


    @Test
    public void testListLazyLoadOrder(){

        List<Order> orders = lazyLoadMapper.listLazyLoadOrder();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //当调用GEI方法是否，延迟加载数据
        for (Order order : orders) {
            order.getProducts();
        }
    }
}
