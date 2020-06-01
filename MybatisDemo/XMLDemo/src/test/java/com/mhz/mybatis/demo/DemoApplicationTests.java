package com.mhz.mybatis.demo;

import com.mhz.mybatis.demo.mapper.CategoryMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@MapperScan("com.mhz.mybatis.demo.mapper")
class DemoApplicationTests {

    @Resource
    private CategoryMapper categoryMapper;

    @Test
    void contextLoads() {
    }



}
