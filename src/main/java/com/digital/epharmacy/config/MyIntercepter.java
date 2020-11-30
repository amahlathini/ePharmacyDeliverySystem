package com.digital.epharmacy.config;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyIntercepter extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        response.addHeader("Access-Control-Expose-Headers", "Content-Range");
        response.addHeader("Access-Control-Expose-Headers", "X-Total-Count");
        response.addHeader("Content-Range", "100");
        response.addHeader("X-Total-Count", "100");

        return true;
    }
}