package com.mhz.mybatis.demo.mapper;

import com.mhz.mybatis.demo.model.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {

    void addCategory(Category category);

    void deleteCategory(Long id);

    Category getCategory(Long id);

    void updateCategory(Category category);

    List<Category> listCategory();


    /**
     * 多个参数
     * @param id
     * @param name
     * @return
     */
    List<Category> listCategoryByNameAndId(@Param("id") Long id ,@Param("name") String name);


    ///不支持方法重载
////    List<Category> listCategoryByNameAndId(Category category);

    List<Category> listCategoryByBean(Category category);


    List<Category> listCategoryOneAndMore();

}
