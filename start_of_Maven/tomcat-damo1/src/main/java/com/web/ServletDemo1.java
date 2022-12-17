//package com.web;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebServlet;
//import java.io.IOException;
//
//@WebServlet("/demo1")
//public class ServletDemo1 implements Servlet {
//
//    private ServletConfig servletConfig;
//    @Override
//    public void init(ServletConfig servletConfig) throws ServletException {
//        this.servletConfig = servletConfig;
//        System.out.println("init.....");
//    }
//
//    @Override
//    public ServletConfig getServletConfig()
//    {
//        return servletConfig;
//    }
//
//    @Override
//    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        System.out.println("Selvet hello word!!");
//    }
//
//    @Override
//    public String getServletInfo()
//    {
//        return null;
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
