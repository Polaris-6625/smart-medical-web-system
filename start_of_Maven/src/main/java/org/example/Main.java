package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.UserMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Main {
    public static void main(String[] args) throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //List<User> users = sqlSession.selectList("search.selectALL");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        List<User> users = userMapper.selectALL();
//        User user = new User();
//        for (User user1 : users) {
//             System.out.println(user1.getDescription());
//            }
        int id = 3;
        User user = null;
        user = userMapper.selectById(id);
        System.out.println(user);
        int status = 1;
        String cName = '%' + "iqoo" + '%';
        String gName = '%' + "vivo" + '%';
        Map map = new HashMap();
        map.put("status",status);
//        map.put("name",cName);
        map.put("Qname",gName);
//        List<User> users = userMapper.selectSome(status,cName,gName);
        List<User> users = userMapper.selectSome(map);
        for(User user1 :users){
            System.out.println(user1);
        }
        System.out.println("------------------------");
        User user6 = new User();
        user6.setStatus(1);
        List<User> users2 = userMapper.selectSingle(user6);
        for(User user3 :users2)
            System.out.println(user3);

        System.out.println("--------------------------------------------");



//        String newName = "iqoo8";
//        String newQname = "vivo公司";
//        int newOrdered = 98;
//        String newDescription = "KPL专用机，晓龙888";
//        int newStatus = 1;
//        User userN = new User();
////
//        userN.setName(newName);
//        userN.setQname(newQname);
//        userN.setOrdered(newOrdered);
//        userN.setDescription(newDescription);
//        userN.setStatus(newStatus);
//        userMapper.add(userN);
//
//        System.out.println(userN.getId());

//        User userN = new User();
//        userN.setId(4);
//        userN.setOrdered(43);
//        userMapper.change(userN);
//        System.out.println("修改完成");
        //手动提交一下
        sqlSession.commit();


        sqlSession.close();

    }
}