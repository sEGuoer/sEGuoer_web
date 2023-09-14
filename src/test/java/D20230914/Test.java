package D20230914;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Test {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeAll
    public static void createSqlSessionFactory() throws IOException {
        String resource = "D20230912/mybatis/mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @org.junit.jupiter.api.Test
    void searchBlog() {
        SqlSession session = sqlSessionFactory.openSession();
        D20230912.mybatis.mapper.UserMapper mapper = session.getMapper(D20230912.mybatis.mapper.UserMapper.class);
//        User user = new User();
//        user.setContent("content");
//        user.setTitle("MySQL");
        Map map = new HashMap();
        map.put("title", "MySQL");
        map.put("creator", "admin");

        System.out.println(mapper.searchBlog(map).get(0).getContent());
    }
}
