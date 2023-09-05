package D20230905;

import D20230904.mybatis.mapper.UserMapper;
import D20230904.mybatis.po.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//@WebServlet("/updateOnblur")

public class mydatis_updateOnblur extends HttpServlet {
    private static SqlSessionFactory sqlSessionFactory;

    public static void createSqlSessionFactory() throws Exception {
        String resource = "D20230904/mybatis/mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        System.out.println(email);
        HttpSession httpSession = req.getSession();
        try {
            createSqlSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.getUser(email);
            if (user == null) {
                resp.setHeader("isEmail-exist", "1");
            } else {
                resp.setHeader("isEmail-exist", "kajsldjasdjsalkdjalkdla");
            }
            session.commit();
        }
    }
}
