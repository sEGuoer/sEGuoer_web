package D20230905;

import D20230818.JDBCDemo;
import D20230904.mybatis.mapper.UserMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//@WebServlet("/clearSession")
public class mydatis_logout extends HttpServlet {
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
        try {
            createSqlSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            Date date = new Date();
            DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String logoutTime = dateformat.format(date);
            if (!email.equals("")) {
                if (email.equals("admin")) {
                    mapper.add_Operation_record( mapper.getUser_id(email), logoutTime, "管理员注销");
                } else {
                    mapper.add_Operation_record( mapper.getUser_id(email), logoutTime, "用户注销");
                }
            }
            session.commit();
            req.getSession().invalidate();
        }
    }
}
