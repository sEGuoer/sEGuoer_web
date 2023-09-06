package D20230904.mybatis.mapper;


import D20230904.mybatis.po.User;
import D20230906.UserDAO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public interface UserMapper extends UserDAO {

    public static SqlSession createSqlSessionFactory(){
        try {
            String resource = "D20230904/mybatis/mybatisConfig.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession(true);
            return session ;
        }catch (Exception e){
            e.printStackTrace();
        }return null;
    }

    List<D20230904.mybatis.po.User> testPreparedStatement();
    User getUser(String email);
    int getUser_id( String email);
    int add(@Param("email")String email,@Param("password") String password, @Param("account")String account,@Param("a") boolean a);
    int add_Operation_record(@Param("user_id") int user_id,@Param("time") String time,@Param("operation")String operation);
    int delete( String email);
    int update( @Param("email")String email, @Param("account")String account, @Param("password")String password,@Param("updateEmail") String updateEmail);
    int updateLoginTime( @Param("email")String email,@Param("loginTime") String loginTime);

}
