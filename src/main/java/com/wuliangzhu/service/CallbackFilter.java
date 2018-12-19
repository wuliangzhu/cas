package com.wuliangzhu.service;

import org.springframework.beans.factory.annotation.Value;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 You need to define the callback endpoint (CallbackFilter) only for web applications, that is for indirect clients.

 For indirect clients (like Facebook), the user is redirected to an external identity provider for login and then back to the application.
 Thus, a callback endpoint is required in the application. It is managed by the CallbackFilter which has the following behaviour:

 1 the credentials are extracted from the current request to fetch the user profile (from the identity provider) which is then saved in the web session

 2 finally, the user is redirected back to the originally requested url (or to the defaultUrl).
 **/
public class CallbackFilter extends io.buji.pac4j.filter.CallbackFilter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        super.doFilter(servletRequest, servletResponse, filterChain);
        //TODO:
        System.out.println("callback filter");
    }
}