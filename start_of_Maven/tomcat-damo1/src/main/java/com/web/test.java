package com.web;

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
import java.util.Calendar;

@WebServlet("/test")
public class test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSessionFactory sqlSessionFactory = Tools.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        informationMapper inMapper = sqlSession.getMapper(informationMapper.class);

        String place = req.getParameter("place");
        String score = req.getParameter("score");
        Calendar cal=Calendar.getInstance();
        int y=cal.get(Calendar.YEAR);
        int m=cal.get(Calendar.MONTH);
        int d=cal.get(Calendar.DATE);
        int h=cal.get(Calendar.HOUR_OF_DAY);
        int mi=cal.get(Calendar.MINUTE);
        int s=cal.get(Calendar.SECOND);
        String time = ""+y+m+d+h+mi+s;
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        if(!place.equals("") && !time.equals("") && !description.equals("") && !name.equals("")){
            MainInformation mainInformation = new MainInformation();
            mainInformation.setPlace(place);
            mainInformation.setName(name);
            mainInformation.setScore(score);
            mainInformation.setDescription(description);
            inMapper.addMInf(mainInformation);
            sqlSession.commit();
            System.out.println("增加完成");
            resp.sendRedirect("Main_new.html");
        }
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
