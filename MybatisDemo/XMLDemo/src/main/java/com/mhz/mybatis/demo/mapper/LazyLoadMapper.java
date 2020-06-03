package com.mhz.mybatis.demo.mapper;

import com.mhz.mybatis.demo.model.Order;

import java.util.List;

public interface LazyLoadMapper {

    List<Order> listLazyLoadOrder();
}
