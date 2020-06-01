package com.example.demo4.config;

import com.example.demo4.filter.MyFilter;
import com.example.demo4.filter.MyFilter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //同等与XML配置中的 beans
public class WebConfiguration {

    /**
     * 默认情况下，过滤器执行的顺序与添加的顺序相同
     *
     * @return
     */
    @Bean //同等与XML配置中的 bean
    public FilterRegistrationBean testFilterRegistration2() {

        //下面同等与XML中的Bean配置属性

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter2());
        registration.addUrlPatterns("/*");  //设置拦截路径
        registration.addInitParameter("paramName2", "paramValue2");
//        registration.setName("MyFilter");  // 同名称，后续添加的过滤器不生效
        //如果设置了优先级，则按优先级执行
        registration.setOrder(2);
        return registration;
    }


    @Bean //同等与XML配置中的 bean
    public FilterRegistrationBean testFilterRegistration1() {

        //下面同等与XML中的Bean配置属性

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");  //设置拦截路径
        registration.addInitParameter("paramName", "paramValue");
//        registration.setName("MyFilter");  //设置过滤器名称
        registration.setOrder(1);
        return registration;
    }


}
