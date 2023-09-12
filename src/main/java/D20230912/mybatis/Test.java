package D20230912.mybatis;


import D20230912.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
//            User user = new User("person","12938123@213","mypwd","12930123921");
//            User user1 = mapper.getUser("12938123@213");
            Date date = new Date();
            DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String loginTime = dateformat.format(date);
            int user_id =  mapper.getUser_id("709074535@qq.com");
            System.out.println(user_id);
            mapper.add_Operation_record(user_id,loginTime,"管理员登录");
//            int id = mapper.insertUser(user);
            session.commit();
//            System.out.println(id);
//            System.out.println(user1);
        }
    }
}
