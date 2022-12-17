package org.example;

import org.apache.ibatis.annotations.Param;

public interface informationMapper {
    userInformation search(@Param("username") String username,@Param("password") String password);

}
