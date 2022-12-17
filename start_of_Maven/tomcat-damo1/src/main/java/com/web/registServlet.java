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
import java.nio.charset.StandardCharsets;

@WebServlet("/registServlet")
public class registServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse responce) throws ServletException, IOException {
        SqlSessionFactory sqlSessionFactory = Tools.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();
        informationMapper inMapper = sqlSession.getMapper(informationMapper.class);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+','+password);
        boolean flag = true;
        userInformation jie = inMapper.searchP(username);
        System.out.println(jie);
        if(jie != null){
            responce.getWriter().write(""+flag);
        }
        else {
            flag = false;
            responce.getWriter().write(""+flag);
            userInformation useN = new userInformation();
            useN.setUsername(username);
            System.out.println("userN:username----"+useN.getUsername());
            useN.setPassword(password);
            System.out.println("userN:password----"+useN.getPassword());
            useN.setPer(req.getParameter("per"));
            System.out.println("userN:per----"+useN.getPer());
            String realname = req.getParameter("realname");
            realname = new String(realname.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
            System.out.println(realname);
            useN.setRealname(realname);
            System.out.println("userN:real----"+useN.getRealname());
            useN.setSex(req.getParameter("sex"));
            System.out.println("userN:sex----"+useN.getSex());

            if(!username.equals("")&&username!=null&&password!=null&&!password.equals("")) {
                inMapper.addInf(useN);
                sqlSession.commit();
                sqlSession.close();
                System.out.println("ok");
                responce.sendRedirect("new_file3.html");
            }

//            req.getRequestDispatcher("/registServlet_2").forward(req,responce);
            }

        }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
