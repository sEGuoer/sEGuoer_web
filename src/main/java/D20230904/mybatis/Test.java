package D20230904.mybatis;


import D20230904.mybatis.mapper.UserMapper;
import D20230904.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test {
    private static SqlSessionFactory sqlSessionFactory;

    public static void createSqlSessionFactory()throws Exception{
        String resource = "D20230904/mybatis/mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static void main(String[] args)  {
        try {
            createSqlSessionFactory();
        }catch (Exception e){
            e.printStackTrace();
        }
        try (SqlSession session = sqlSessionFactory.openSession()){
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = new User();
            user.setUser("person","12938123@213","mypwd","12930123921");
            int id = mapper.insertUser(user);
            session.commit();
            System.out.println(id);
        }
    }
}
