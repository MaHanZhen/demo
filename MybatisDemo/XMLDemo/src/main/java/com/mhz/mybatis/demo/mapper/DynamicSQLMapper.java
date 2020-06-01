package com.mhz.mybatis.demo.mapper;

import com.mhz.mybatis.demo.model.Product;

import java.util.List;

public interface DynamicSQLMapper {

    List<Product> ifTag(String name);


    /** where,set,trim 标签就是判断标签内是否以XX开头或结尾 是就去掉 **/
    List<Product> whereTag(Product product);

    List<Product> trimWhereTag(Product product);

    void setTag(Product product);

    void trimSetTag(Product product);

}
