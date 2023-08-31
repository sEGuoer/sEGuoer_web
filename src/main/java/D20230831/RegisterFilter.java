package D20230831;

import D20230815.User;
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

@WebFilter("/RegisterVerify")

public class RegisterFilter extends HttpFilter {
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
        String account = req.getParameter("account");
        String verifyCode = req.getParameter("VerifyCode");
        JDBCDemo jdbcDemo = getJdbcTest();
        Connection connection = jdbcDemo.getConnection();
        HttpSession session = req.getSession();
        String sessionCode = (String) session.getAttribute("VerifyCode");
        System.out.println(sessionCode.equals(verifyCode));
        int panduan = jdbcDemo.add(connection, email, password, account,sessionCode.equals(verifyCode));
        if (panduan == 5 ){
            resp.setHeader("isEmail-exist", "kajsldjasdjsalkdjalkdla");
        }else {
            if (password != "" && account != "") {
                if (panduan == 0) {
                    if (sessionCode.equals(verifyCode) ) {
                        chain.doFilter(req,resp);
                    } else {
                        jdbcDemo.soutYourInfo(resp, "验证码错误，请重新注册");
                    }
                } else if (panduan == 1) {
                    resp.setHeader("isEmail-exist", "kajsldjasdjsalkdjalkdla");
                    jdbcDemo.soutYourInfo(resp, "账号和邮箱都重复，请重新注册");
                } else if (panduan == 2) {
                    jdbcDemo.soutYourInfo(resp, "账号重复，请重新注册");
                } else if (panduan == 3) {
                    resp.setHeader("isEmail-exist", "kajsldjasdjsalkdjalkdla");
                    jdbcDemo.soutYourInfo(resp, "邮箱重复，请重新注册");
                }
            }
        }
    }
}
