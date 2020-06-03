package com.mhz.mybatis.demo.mapper;

import com.mhz.mybatis.demo.model.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {

    List<Product> ifTag(String name);


    /** where,set,trim 标签就是判断标签内是否以XX开头或结尾 是就去掉 **/
    List<Product> whereTag(Product product);

    List<Product> trimWhereTag(Product product);

    void setTag(Product product);

    void trimSetTag(Product product);


    /**
     * 与JAVA里面的switch句法类似
     * @param product
     * @return
     */
    List<Product> chooseTag(Product product);


    List<Product> foreachTag(@Param("ids") Long ... ids);

    List<Product> bindTag(String name);
}
