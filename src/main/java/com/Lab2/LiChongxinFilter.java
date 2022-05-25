package com.Lab2;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;


public class LiChongxinFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("LiChongxinFilter-->before chain");
        chain.doFilter(request, response);
        System.out.println("LiChongxinFilter-->after chain");
    }
}

