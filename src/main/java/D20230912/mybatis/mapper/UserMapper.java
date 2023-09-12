package D20230912.mybatis.mapper;


import D20230906.UserDAO;
import D20230912.mybatis.po.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public interface UserMapper extends UserDAO {

    public static UserMapper createSqlSessionFactory(){
        try {
            String resource = "D20230912/mybatis/mybatisConfig.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession(true);
            UserMapper mapper =session.getMapper(UserMapper.class);
            return mapper ;
        }catch (Exception e){
            e.printStackTrace();
        }return null;
    }

    User getUser(String email);
    int getUser_id( String email);
    int add(@Param("email")String email,@Param("password") String password, @Param("account")String account,@Param("a") boolean verifyCodeIsCorrect);
    int add_Operation_record(@Param("user_id") int user_id,@Param("time") String time,@Param("operation")String operation);
    int delete( String email);
    int update( @Param("email")String email, @Param("account")String account, @Param("password")String password,@Param("updateEmail") String updateEmail);
    int updateLoginTime( @Param("email")String email,@Param("loginTime") String loginTime);

}
