package com.alucard.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器拦截所有请求，给指定的地址以及方法设置访问的权限
 */
public class CrosFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter-------->");
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 允许访问的地址
        response.addHeader("Access-Control-Allow-Origin","*");
        // 允许访问的方法
        response.addHeader("Access-Control-Allow-Method","*");
        // 允许Content-Type
//        response.addHeader("Access-Control-Allow-Headers","Content-Type");
        // 用于缓存页面，这样就可以不用每次去预检，但是然并卵刷新页面还是要执行2次
//        response.addHeader("Access-Control-Allow-Max-Age","3600");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
