package D20230821;

import D20230815.User;
import D20230818.JDBCDemo;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/RegisterVerify")
public class RegisterVerify extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    private JDBCDemo jdbcTest;

    public JDBCDemo getJdbcTest() {
        return jdbcTest;
    }

    public void setJdbcTest(JDBCDemo jdbcTest) {
        this.jdbcTest = jdbcTest;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        JDBCDemo jdbcTest = new JDBCDemo();
        setJdbcTest(jdbcTest);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("pwd");
        String account = req.getParameter("account");
        String verifyCode = req.getParameter("VerifyCode");
        JDBCDemo jdbcDemo = getJdbcTest();
        Connection connection = jdbcDemo.getConnection();
        HttpSession session = req.getSession();
        String sessionCode = (String) session.getAttribute("VerifyCode");
        System.out.println(sessionCode.equals(verifyCode));
        User user = jdbcDemo.getUser(connection, email);
        int panduan = jdbcDemo.add(connection, email, password, account,sessionCode.equals(verifyCode));
        if (panduan == 5 ){
            resp.setHeader("isEmail-exist", "kajsldjasdjsalkdjalkdla");
        }else {
            if (password != "" && account != "") {
                if (panduan == 0) {
                    if (sessionCode.equals(verifyCode) ) {
                        jdbcDemo.soutYourInfo(resp, "注册成功");
                        req.getRequestDispatcher("./verify").forward(req, resp);
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
