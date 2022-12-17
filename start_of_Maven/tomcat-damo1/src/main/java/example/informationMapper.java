package example;

import com.sun.tools.javac.Main;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface informationMapper {
    userInformation search(@Param("username") String username,@Param("password") String password);

    userInformation searchP(String username);
    void addInf(userInformation users);
    List<MainInformation> searchTable();
    void addMInf(MainInformation mainInformation);
    void changeData(@Param("id") int id,@Param("else") MainInformation users);
    void deleteSingle(int id);
    void addTalk(TalkAbout talkAbout);
    List<String> selectTalkAll();
    void changeUsers(@Param("username") String username,@Param("password") String password);
    MainInformation selectAllInformation(int id);
}
