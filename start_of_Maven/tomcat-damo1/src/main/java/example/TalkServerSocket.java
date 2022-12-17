package example;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import until.Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


@WebServlet("/talkServerSocket")
public class TalkServerSocket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSessionFactory sqlSessionFactory = Tools.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        informationMapper inMapper = sqlSession.getMapper(informationMapper.class);

        String talkInformation = req.getParameter("talk");
        talkInformation = new String(talkInformation.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        TalkAbout talkAbout = new TalkAbout();
        talkAbout.setTsingle(talkInformation);
        System.out.println(talkAbout);
        System.out.println(talkInformation);
        if(talkAbout != null){
            inMapper.addTalk(talkAbout);
        }
        System.out.println("ok");
        sqlSession.close();
        resp.sendRedirect("talk.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
