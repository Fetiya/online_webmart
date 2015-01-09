/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.filter;


import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.Users;
import edu.mum.cs490.smartmart.service.IUserService;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author Senai
 */
public class MyFilter implements Filter {

    @Autowired
    private IUserService userService;

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
        userService = context.getBean("userService", IUserService.class);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Inside filter");
        if (((HttpServletRequest) request).getSession().getAttribute("loggedUser") == null) {
            UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) ((HttpServletRequest) request).getUserPrincipal();
            if (token != null) {
                org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) token.getPrincipal();
                ((HttpServletRequest) request).getSession().setAttribute("loggedUser", userService.getUserByUsername(user.getUsername()));
                System.out.println("User logged in _____________________________________"+((HttpServletRequest) request).getSession().getAttribute("loggedUser"));

            }
        } 
        //re-attach the customer object to the session
        else {
            Users user = (Users) ((HttpServletRequest) request).getSession().getAttribute("loggedUser");
//            if (user instanceof Customer) {
                userService.updateUser(user);
//            }
            
//            ((HttpServletRequest) request).getSession().setAttribute("loggedUser", userService.getUserById(user.getId()));
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}
