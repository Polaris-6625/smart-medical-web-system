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

@WebServlet("/ajaxTrain")
public class AjaxTrain extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse responce) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean flag = true;
        SqlSessionFactory sqlSessionFactory = Tools.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();
        informationMapper inMapper = sqlSession.getMapper(informationMapper.class);
        userInformation users = inMapper.searchP(username);
        if(users != null){
            responce.getWriter().write(""+flag);
        }
        else {
            flag = false;
            responce.getWriter().write(""+flag);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
