package com.LiChongxin.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",
urlPatterns = {"/hello"}
)
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in LoginFilter --> doFilter()- before servlet(request come here )");
        chain.doFilter(request, response);
        System.out.println("i am in LoginFilter --> doFilter()- after servlet(request come here )");
    }
}
