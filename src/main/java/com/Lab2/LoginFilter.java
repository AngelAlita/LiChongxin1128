package com.Lab2;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns ={ "/lab2/welcome.jsp","/lab2/validate.jsp"}
)
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("i am in LoginFilter--init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("i am in LoginFilter--doFilter()-- request before chain");

        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        filterChain.doFilter(servletRequest, servletResponse);
        if (req.getSession(false) != null && req.getSession(false).getAttribute("user") != null){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            res.sendRedirect(req.getContextPath()+"/lab2/login.jsp");
        }

        System.out.println("i am in LoginFilter--doFilter()-- request after chain");
    }

    @Override
    public void destroy() {
        System.out.println("i am in LoginFilter--doFilter()-- request after chain");
    }
}
