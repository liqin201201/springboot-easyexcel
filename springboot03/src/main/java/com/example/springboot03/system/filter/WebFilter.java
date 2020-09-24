package com.example.springboot03.system.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义统一过滤器
 * @author liqin
 * @date 2020/9/24 11:02
 */

public class WebFilter implements Filter {


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String url = request.getRequestURI();
        System.out.println("请求的url：" + url);
        System.out.println("filter doFilter 前");
        filterChain.doFilter(request, resp);
        System.out.println("filter doFilter 后");
    }

    @Override
    public void destroy() {

    }
}
