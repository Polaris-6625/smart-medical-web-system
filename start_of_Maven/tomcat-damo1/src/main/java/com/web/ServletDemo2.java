package com.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;


@WebServlet("/demo4")
public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String headers = req.getHeader("User-agent");
        System.out.println("headersÎª"+headers);
        StringBuffer URL = req.getRequestURL();
        System.out.println(URL);
        String query = req.getQueryString();
        System.out.println(query);
        System.out.println("get");
        Map<String,String[]> map = req.getParameterMap();
        for(String key : map.keySet()){
            System.out.print(key+':');
            String[] values = map.get(key);
            for(String it:values){
                System.out.print(it);
            }
            System.out.println();
        }
        String name = req.getParameter("username");
        resp.setHeader("content-type","text/html;charset=utf-8");
        resp.getWriter().write("<h1>"+name+"»¶Ó­Äú!</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String headers = req.getHeader("User-agent");
        System.out.println("headersÎª"+headers);
        StringBuffer URL = req.getRequestURL();
        System.out.println(URL);
        String query = req.getQueryString();
        System.out.println(query);
        System.out.println("get");
        Map<String,String[]> map = req.getParameterMap();
        for(String key : map.keySet()) {
            System.out.print(key + ':');
            String[] values = map.get(key);
            for (String it : values) {
                System.out.print(it);
            }
            System.out.println();
        }
        String name = req.getParameter("name");
        resp.setHeader("content-type","text/html;charset=utf-8");
        resp.getWriter().write("<h1>"+name+"»¶Ó­Äú!</h1>");
    }
}
