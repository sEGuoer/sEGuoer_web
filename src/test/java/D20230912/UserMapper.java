package D20230912;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class UserMapper {
    private static SqlSessionFactory sqlSessionFactory;
    @BeforeAll
    public static void createSqlSessionFactory() throws IOException {
        String resource = "D20230912/mybatis/mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
   void testInsertUser(){
        SqlSession session = sqlSessionFactory.openSession();
        D20230912.mybatis.mapper.UserMapper mapper = session.getMapper(D20230912.mybatis.mapper.UserMapper.class);
        Assertions.assertTrue(mapper.tableinfo(1).size()>0);
        Assertions.assertNotNull(mapper.tableinfo(1).toString());
//        System.out.println(mapper.tableinfo(1));
    }

    @Test
    void searchBlog(){
        SqlSession session = sqlSessionFactory.openSession();
        D20230912.mybatis.mapper.UserMapper mapper = session.getMapper(D20230912.mybatis.mapper.UserMapper.class);
//        User user = new User();
//        user.setContent("content");
//        user.setTitle("MySQL");
        Map map = new HashMap();
        map.put("title","MySQL");
        map.put("content","content");

        System.out.println(mapper.searchBlog(map).get(0).getContent());
    }
}
