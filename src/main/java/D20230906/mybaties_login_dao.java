package D20230906;

import D20230904.mybatis.mapper.UserMapper;
import D20230904.mybatis.po.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import static D20230904.mybatis.mapper.UserMapper.createSqlSessionFactory;

//@WebServlet("/verify")
public class mybaties_login_dao extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession httpSession = req.getSession();
            String email = req.getParameter("email");
            UserDAO mapper = Objects.requireNonNull(createSqlSessionFactory()).getMapper(UserMapper.class);
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
    }
}
