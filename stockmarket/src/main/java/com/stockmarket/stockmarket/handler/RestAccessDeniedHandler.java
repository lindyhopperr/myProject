package com.stockmarket.stockmarket.handler;

import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import org.springframework.security.access.AccessDeniedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class RestAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        httpServletResponse.setHeader("error", e.getMessage());
        httpServletResponse.getOutputStream().println("{ \"error\": \"" + e.getMessage() + "\" }");
    }
}