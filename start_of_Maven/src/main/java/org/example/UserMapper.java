package org.example;

import org.apache.ibatis.annotations.Param;
import org.example.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> selectALL();
    User selectById(int id);
    //List<User>  selectSome(@Param("status") int status,@Param("name") String name,@Param("Qname") String Qname);
    List<User> selectSome(Map map);
    List<User> selectSingle(User user);
    void add(User user);
    void change(User user);
    void del(@Param("ids") int[] ids);
}
