package D20230818;

import D20230815.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Objects;

@WebServlet("/verify")
public class addUserInformationToDatabase extends HttpServlet {
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("pwd");
        String account = req.getParameter("account");
        JDBCDemo jdbcDemo = getJdbcTest();
        Connection connection = jdbcDemo.getConnection();
        int panduan = jdbcDemo.add(connection, email, password, account);
        resp.setHeader("isEmail-exist","kajsldjasdjsalkdjalkdla");
        if (panduan == 0) {
            jdbcDemo.soutYourInfo(resp, "注册成功");
        } else if (panduan == 1) {
            jdbcDemo.soutYourInfo(resp, "账号和邮箱都重复，请重新注册");
        } else if (panduan == 2) {
            jdbcDemo.soutYourInfo(resp, "账号重复，请重新注册");
        } else if (panduan == 3) {
            jdbcDemo.soutYourInfo(resp, "邮箱重复，请重新注册");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req);
//        req.setCharacterEncoding("GBK");
//        resp.setCharacterEncoding("GBK");
        String email = req.getParameter("email");
        String password = req.getParameter("pwd");
//        System.out.println(email + " " + password);
        JDBCDemo jdbcDemo = getJdbcTest();
        Connection connection = jdbcDemo.getConnection();
        User user = jdbcDemo.getUser(connection, email);
        System.out.println(user == null);
        if (user == null) {
            jdbcDemo.soutYourInfo(resp, "没有找到该用户");
        } else {
            if (user.getPassword().equals(password)) {
                if (user.getUsername().equals("admin")) {
                    jdbcDemo.soutYourInfo(resp, jdbcDemo.testPreparedStatement(connection).toString());
                } else {
                    jdbcDemo.soutYourInfo(resp, user.toString());
                }
            }else {
                jdbcDemo.soutYourInfo(resp, "密码错误，请重新输入");
            }
        }
    }
}
