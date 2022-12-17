package com.web;

import example.informationMapper;
import example.userInformation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import until.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/loginServet")
public class loginServet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        SqlSessionFactory sqlSessionFactory = Tools.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();
        informationMapper inMapper = sqlSession.getMapper(informationMapper.class);
        System.out.println(username+','+password);
        userInformation userinformation = inMapper.search(username,password);
        sqlSession.close();
        resp.setContentType("text/html;charset = utf-8");
        PrintWriter printWriter = resp.getWriter();
        if(userinformation != null ){
            printWriter.write("<h1>"+username+"»¶Ó­Äú!</h1>");
            resp.getWriter().write("successful~");
//            req.getRequestDispatcher("src/main/webapp/new_file.html");
            resp.sendRedirect("Main_new.html");
        }
        else {
            resp.sendRedirect("login.html");
            resp.getWriter().write("error~");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
