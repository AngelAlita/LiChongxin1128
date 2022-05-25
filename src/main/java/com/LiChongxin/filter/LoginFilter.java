package com.LiChongxin.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",
        urlPatterns = {"src/main/webapp/lab2/validate.jsp","src/main/webapp/lab2/welcome.jsp"}
)
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in LoginFilter--init()");
    }

    @Override
    public void destroy() {
        System.out.println("i am in LoginFilter--destroy()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in LoginFilter--doFilter()-- request before chain");
        chain.doFilter(request, response);
        System.out.println("i am in LoginFilter--doFilter()-- request after chain");
    }
}
