package com.web;

import example.informationMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import until.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSessionFactory sqlSessionFactory = Tools.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();
        informationMapper inMapper = sqlSession.getMapper(informationMapper.class);
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);
        System.out.println(ids);
        if(ids != null){
            inMapper.deleteSingle(id);
            sqlSession.commit();
            sqlSession.close();
            resp.sendRedirect("Main_new.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
