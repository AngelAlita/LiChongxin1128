package com.LiChongxin.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;


import java.io.IOException;

@WebFilter(filterName = "AuthFilter",
        urlPatterns = {"/hello"}
)
public class AuthFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("In AuthFilter before doFilter" + System.currentTimeMillis());
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("getRequestUrl" + request.getRequestURL());
        System.out.println("getScheme" + request.getScheme());
        System.out.println("getServerName"  + request.getServerName());
        System.out.println("getServerPort" + request.getServerPort());
        System.out.println("getRequestURI" + request.getRequestURI());
        System.out.println("getServletPath" + request.getServletPath());
        System.out.println("getQueryString" + request.getQueryString());
        System.out.println("getMethod" + request.getMethod());
        chain.doFilter(request, response);
        System.out.println("In AuthFilter afer doFilter" + System.currentTimeMillis());

    }
    @Override
    public void init(FilterConfig config) throws ServletException {
    }
}
