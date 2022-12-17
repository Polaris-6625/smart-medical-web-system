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
import java.nio.charset.StandardCharsets;
import java.util.Calendar;

@WebServlet("/ChangeServlet")
public class ChangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSessionFactory sqlSessionFactory = Tools.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();
        informationMapper inMapper = sqlSession.getMapper(informationMapper.class);
        String ids = req.getParameter("id");
        int id = Integer.parseInt(ids);
        System.out.println(ids);
        if(ids != null){
            // 转发一下，还没有写
            req.setCharacterEncoding("UTF-8");

            String place = req.getParameter("place");
            place = new String(place.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
            String score = req.getParameter("score");
            score = new String(score.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
            Calendar cal=Calendar.getInstance();
            int y=cal.get(Calendar.YEAR);
            int m=cal.get(Calendar.MONTH);
            int d=cal.get(Calendar.DATE);
            int h=cal.get(Calendar.HOUR_OF_DAY);
            int mi=cal.get(Calendar.MINUTE);
            int s=cal.get(Calendar.SECOND);
            String time = ""+y+m+d+h+mi+s;
            String name = req.getParameter("name");
            name = new String(name.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
            String description = req.getParameter("description");
            description = new String(description.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
            // 想获取一下id
            if(!place.equals("") && !time.equals("") && !description.equals("") && !name.equals("")){
                MainInformation mainInformation = new MainInformation();
                mainInformation.setPlace(place);
                mainInformation.setName(name);
                mainInformation.setScore(score);
                mainInformation.setDescription(description);
                inMapper.changeData(id,mainInformation);
                sqlSession.commit();
                System.out.println("修改完成");
                resp.sendRedirect("Ts.html");
            }
            sqlSession.close();

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
