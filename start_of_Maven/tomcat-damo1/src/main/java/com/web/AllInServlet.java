package com.web;

import com.alibaba.fastjson.JSON;
import example.MainInformation;
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

@WebServlet("/AllInServlet")
public class AllInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSessionFactory sqlSessionFactory = Tools.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();
        informationMapper inMapper = sqlSession.getMapper(informationMapper.class);
        String ids = req.getParameter("id");
        System.out.println(ids);
        int id = Integer.parseInt(ids);
        System.out.println(ids);
        if (ids != null){
//            resp.sendRedirect("Main_Detail.html");
            MainInformation mainInformation = inMapper.selectAllInformation(id);
            String jsonString = JSON.toJSONString(mainInformation);
            System.out.println(jsonString);
            resp.setContentType("test/json;charset=utf-8");
            resp.getWriter().write(jsonString);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
