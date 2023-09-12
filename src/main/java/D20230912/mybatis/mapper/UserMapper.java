package D20230912.mybatis.mapper;


import D20230906.UserDAO;
import D20230912.mybatis.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface UserMapper extends UserDAO {



    List<User> tableinfo(int id);
    int add(@Param("email")String email,@Param("password") String password, @Param("account")String account,@Param("a") boolean verifyCodeIsCorrect);
    int add_Operation_record(@Param("user_id") int user_id,@Param("time") String time,@Param("operation")String operation);
    int update( @Param("email")String email, @Param("account")String account, @Param("password")String password,@Param("updateEmail") String updateEmail);
    int updateLoginTime( @Param("email")String email,@Param("loginTime") String loginTime);

}
