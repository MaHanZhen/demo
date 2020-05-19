package com.example.demo4.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter2 implements Filter {

    @Override
    public void destroy() {
    }

    /**
     * 过滤器执行逻辑
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
        System.out.println("this is MyFilter2222222");

        filterChain.doFilter(servletRequest, sresponse);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }
}
