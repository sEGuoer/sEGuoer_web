package D20230904.mybatis.mapper;


import D20230904.mybatis.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User selectUser(int id);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
    List<D20230815.User> testPreparedStatement();
    User getUser(String email);
    int getUser_id( String email);
    int add(@Param("email")String email,@Param("password") String password, @Param("account")String account,@Param("a") boolean a);
    int add_Operation_record(@Param("user_id") int user_id,@Param("time") String time,@Param("operation")String operation);
    int delete( String email);
    int update( @Param("email")String email, @Param("account")String account, @Param("password")String password,@Param("updateEmail") String updateEmail);
    int updateLoginTime( @Param("email")String email,@Param("loginTime") String loginTime);

}
