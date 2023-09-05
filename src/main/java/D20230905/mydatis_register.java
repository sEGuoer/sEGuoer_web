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

//@WebServlet("/RegisterVerify")
public class mydatis_register extends HttpServlet {
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
        try {
            createSqlSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (SqlSession session = sqlSessionFactory.openSession()) {
            String email = req.getParameter("email");
            UserMapper mapper = session.getMapper(UserMapper.class);
            Date date = new Date();
            DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String registerTime = dateformat.format(date);
            mapper.add_Operation_record(mapper.getUser_id(email) , registerTime, "用户注册");
            session.commit();
            req.getRequestDispatcher("./verify").forward(req, resp);
        }
    }
}
