package com.LiChongxin.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "HelloFilter",
urlPatterns = {"/hello"}//urlPatterns = {"/*"}
)
public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in HelloFilter --> init()");
    }

    @Override
    public void destroy() {
        System.out.println("i am in HelloFilter --> destroy()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in HelloFilter --> doFilter()- before servlet(request come here )");
        chain.doFilter(request, response);
        System.out.println("i am in HelloFilter --> doFilter()- after servlet(request come here )");
    }
}
