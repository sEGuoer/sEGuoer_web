package D20230831;

import D20230904.mybatis.po.User;
import D20230818.JDBCDemo;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
//@WebFilter("/verify")
public class LoginFilter extends HttpFilter {

    private static volatile JDBCDemo jdbcDemo;


    public static JDBCDemo getJdbcTest() {
        if (jdbcDemo == null){
            synchronized (JDBCDemo.class){
                if (jdbcDemo == null){
                    jdbcDemo = new JDBCDemo();
                }
            }
        }
        return jdbcDemo;
    }
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        String email = req.getParameter("email");
        String password = req.getParameter("pwd");
        System.out.println(email + " " + password);
        System.out.println(req.getAttribute("Content-type"));
        JDBCDemo jdbcDemo = getJdbcTest();
        User user = jdbcDemo.getUser( email);
        req.setAttribute("email",email);
        System.out.println(user == null);
        resp.setHeader("isEmail-log-exist","2");
        if (user == null) {
            resp.setHeader("isEmail-log-exist","kajsldjasdjsalkdjalkdla");
            resp.setHeader("info","not found email");
        } else {
            if (user.getPassword().equals(password)) {
                chain.doFilter(req,resp);
            }else {
                resp.setHeader("info","password wrong,please input right password");
            }
        }
    }
}
