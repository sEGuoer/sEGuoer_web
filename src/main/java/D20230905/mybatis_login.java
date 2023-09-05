package D20230905;

import D20230904.mybatis.mapper.UserMapper;
import D20230904.mybatis.po.User;
import jakarta.servlet.ServletException;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//@WebServlet("/verify")
public class mybatis_login extends HttpServlet {
    private static SqlSessionFactory sqlSessionFactory;

    public static void createSqlSessionFactory() throws Exception {
        String resource = "D20230904/mybatis/mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession httpSession = req.getSession();
        try {
            createSqlSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (SqlSession session = sqlSessionFactory.openSession()) {
            String email = req.getParameter("email");
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.getUser(email);
            resp.setHeader("info", "can found user");
            Date date = new Date();
            DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String loginTime = dateformat.format(date);
            if (user.getUsername().equals("admin")) {
                req.setAttribute("AdminOrUser", "Admin");
                httpSession.setAttribute("role", "admin");
                mapper.add_Operation_record(mapper.getUser_id(email), loginTime, "管理员登录");
                resp.sendRedirect("./GetUserList");
            } else {
                httpSession.setAttribute("user", user);
                httpSession.setAttribute("role", "user");
                mapper.add_Operation_record(mapper.getUser_id(email), loginTime, "用户登录");
                resp.sendRedirect("./UserInfo");
            }
            if (req.getParameter("nowPage") == null) {
                mapper.updateLoginTime(email, loginTime);
            }
            session.commit();
        }
    }
}