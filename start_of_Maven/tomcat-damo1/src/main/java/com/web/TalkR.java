package com.web;

import com.alibaba.fastjson.JSON;
import example.TalkAbout;
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
import java.util.List;

@WebServlet("/talkR")
public class TalkR extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSessionFactory sqlSessionFactory = Tools.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        informationMapper inMapper = sqlSession.getMapper(informationMapper.class);

        List<String> list = inMapper.selectTalkAll();
        String jsonString = JSON.toJSONString(list);
        System.out.println("Json是"+jsonString);
        resp.setContentType("test/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
