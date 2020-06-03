package com.mhz.mybatis.demo;

import com.mhz.mybatis.demo.mapper.CategoryMapper;
import com.mhz.mybatis.demo.mapper.OrderMapper;
import com.mhz.mybatis.demo.mapper.ProductMapper;
import com.mhz.mybatis.demo.model.Category;
import com.mhz.mybatis.demo.model.Order;
import com.mhz.mybatis.demo.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * 链接查询测试
 * 一对多 多对一 多对多
 */
@SpringBootTest
public class JoinTest {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private ProductMapper productMapper;


    @Resource
    private OrderMapper orderMapper;

    @Test
    public void testListCategoryOneAndMore(){
        List<Category> categories = categoryMapper.listCategoryOneAndMore();
        Assert.isTrue(2 == categories.size(),"查询失败");
    }

    @Test
    public void testListProductMoreAndOne(){
        List<Product> products = productMapper.listProductMoreAndOne();
        Assert.isTrue(6 == products.size(),"查询失败");
    }

    @Test
    public void testListOrderMoreAndMore(){
        //多对多与一堆多查询配置一直  可以根据情况自由拓展对象与XML映射的关系
        //具体表现为
        //如果是集合->使用collection
        //如果是单个对象->使用association
        List<Order> orders = orderMapper.listOrderMoreAndMore();
        Assert.isTrue(2 == orders.size(),"查询失败");
    }
}
