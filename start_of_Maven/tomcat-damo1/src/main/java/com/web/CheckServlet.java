package com.web;

import example.informationMapper;
import example.userInformation;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import until.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkServlet")
public class CheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSessionFactory sqlSessionFactory = Tools.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        informationMapper inMapper = sqlSession.getMapper(informationMapper.class);

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        userInformation users = inMapper.search(username,password);
        System.out.println(users);
        if(users != null){
            password = req.getParameter("passNew");
            inMapper.changeUsers(username,password);
            sqlSession.commit();
            sqlSession.close();
            resp.sendRedirect("Main_my_I.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
