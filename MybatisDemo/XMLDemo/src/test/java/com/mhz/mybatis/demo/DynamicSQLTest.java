package com.mhz.mybatis.demo;

import com.mhz.mybatis.demo.mapper.DynamicSQLMapper;
import com.mhz.mybatis.demo.model.Product;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * 动态SQL
 */
@SpringBootTest
public class DynamicSQLTest {

    @Resource
    private DynamicSQLMapper dynamicSQLMapper;



    @Test
    public void testIfTag(){
        List<Product> productList = dynamicSQLMapper.ifTag(null);
        Assert.isTrue(6 == productList.size(),"查询结果不符合预期");


        List<Product> products = dynamicSQLMapper.ifTag("2");
        Assert.isTrue(6 > products.size(),"查询结果不符合预期");
    }


    @Test
    public void testWhereTag(){
        Product product = new Product();
        List<Product> productList = dynamicSQLMapper.whereTag(product);
        Assert.isTrue(6 == productList.size(),"查询结果不符合预期");

        product.setName("b");
        productList = dynamicSQLMapper.whereTag(product);
        Assert.isTrue(6 > productList.size(),"查询结果不符合预期");

        product.setPrice(99F);
        productList = dynamicSQLMapper.whereTag(product);
        Assert.isTrue(0 == productList.size(),"查询结果不符合预期");
    }

    @Test
    public void testTrimWhereTag(){
        Product product = new Product();
        List<Product> productList = dynamicSQLMapper.trimWhereTag(product);
        Assert.isTrue(6 == productList.size(),"查询结果不符合预期");

        product.setName("b");
        productList = dynamicSQLMapper.trimWhereTag(product);
        Assert.isTrue(6 > productList.size(),"查询结果不符合预期");

        product.setPrice(99F);
        productList = dynamicSQLMapper.trimWhereTag(product);
        Assert.isTrue(0 == productList.size(),"查询结果不符合预期");
    }


    @Test
    public void testSetTag(){
        Product product = new Product();
        product.setId(1);
        product.setName("qaq");
        dynamicSQLMapper.setTag(product);

        product.setPrice(99F);
        dynamicSQLMapper.setTag(product);

    }

    @Test
    public void testTrimSetTag(){
        Product product = new Product();
        product.setId(2);
        product.setName("qaq");
        dynamicSQLMapper.trimSetTag(product);

        product.setPrice(99F);
        dynamicSQLMapper.trimSetTag(product);

    }


    @Test
    public void testChooseTag(){

        Product product = new Product();

        List<Product> productList = dynamicSQLMapper.chooseTag(product);
        Assert.isTrue(5 == productList.size(),"查询结果不符合预期");

        product.setName("product");
        productList = dynamicSQLMapper.chooseTag(product);
        Assert.isTrue(4 == productList.size(),"查询结果不符合预期");

        product = new Product();
        product.setPrice(90);
        productList = dynamicSQLMapper.chooseTag(product);
        Assert.isTrue(2 == productList.size(),"查询结果不符合预期");
    }


    @Test
    public void testForeachTag(){


        List<Product> productList = dynamicSQLMapper.foreachTag(1L,2L,3L);
        Assert.isTrue(3 == productList.size(),"查询结果不符合预期");


    }

    @Test
    public void testBindTag(){


        List<Product> products = dynamicSQLMapper.bindTag("2");
        Assert.isTrue(6 > products.size(),"查询结果不符合预期");
    }

}
