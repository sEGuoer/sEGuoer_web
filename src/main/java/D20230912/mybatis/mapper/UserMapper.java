package D20230912.mybatis.mapper;


import D20230906.UserDAO;
import D20230912.mybatis.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface UserMapper extends UserDAO {



    List<User> tableinfo(int id);
    D20230904.mybatis.po.User UserInfo(int id);
    int add(@Param("email")String email,@Param("password") String password, @Param("account")String account,@Param("a") boolean verifyCodeIsCorrect);
    int add_Operation_record(@Param("user_id") int user_id,@Param("time") String time,@Param("operation")String operation);
    int update( @Param("email")String email, @Param("account")String account, @Param("password")String password,@Param("updateEmail") String updateEmail);
    int updateUser(Map map);
    int deleteUser(Map map);
    int updateLoginTime( @Param("email")String email,@Param("loginTime") String loginTime);
    int addUser(Map map);
    int deleteManyUser(int[] ints);
    List<User> searchBlog(@Param("title")String title, @Param("content")String content);
    List<User> searchBlog(User user);
    List<User> searchBlog(Map map);

}
