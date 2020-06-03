package com.mhz.mybatis.demo;

import com.mhz.mybatis.demo.mapper.CategoryMapper;
import com.mhz.mybatis.demo.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * 普通CRUD的测试
 */
@SpringBootTest
public class CRUDTest {

    @Resource
    private CategoryMapper categoryMapper;

    @Test
    public void testAddCategory(){
        Category category = new Category();
        category.setName("1");
        this.categoryMapper.addCategory(category);

        category.setName("2");
        this.categoryMapper.addCategory(category);

        category.setName("3");
        this.categoryMapper.addCategory(category);

        List<Category> categoryList = this.categoryMapper.listCategory();
        Assert.isTrue(3 <= categoryList.size(),"添加失败");
    }


    @Test
    public void testDeleteCategory(){

        this.categoryMapper.deleteCategory(2L);

        List<Category> categoryList = this.categoryMapper.listCategory();
        Assert.isTrue(2 == categoryList.size(),"删除失败");
    }


    @Test
    public void testUpdateCategory(){

        Category category = new Category();

        category.setId(2L);
        category.setName("qaq");

        this.categoryMapper.updateCategory(category);

        Category category2 = this.categoryMapper.getCategory(2L);
        Assert.isTrue("qaq".equals(category2.getName()),"更新失败");
    }


    @Test
    public void testListCategoryByNameAndId(){
        List<Category> categories = this.categoryMapper.listCategoryByNameAndId(3L, "2");
        Assert.isTrue(categories .size() > 0 ,"查询失败");
    }


    @Test
    public void testListCategoryByBean(){
        Category category = new Category();
        category.setId(3L);
        category.setName("2");
        List<Category> categories = this.categoryMapper.listCategoryByBean(category);
        Assert.isTrue(categories .size() > 0 ,"查询失败");
    }
}