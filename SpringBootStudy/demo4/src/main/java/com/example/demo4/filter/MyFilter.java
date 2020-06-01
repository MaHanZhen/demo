package com.example.demo4.filter;

import com.example.demo4.cont.NeoProperties;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 定义一个过滤器
 */
public class MyFilter implements Filter {

    @Override
    public void destroy() {
    }

    /**
     * 过滤器执行逻辑
     *
     * @param servletRequest
     * @param sresponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse sresponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("this is MyFilter 1111");

        filterChain.doFilter(servletRequest, sresponse);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
