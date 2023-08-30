package D20230824;

import D20230818.JDBCDemo;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/addUser")
public class addUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
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
        JDBCDemo jdbcDemo = getJdbcTest();
        Connection connection = jdbcDemo.getConnection();
        int panduan = jdbcDemo.add(connection, email, password, account,true);
        if (panduan == 0) {
            jdbcDemo.soutYourInfo(resp, "添加成功");
            resp.sendRedirect("./verify?email=admin@1&pwd=zcy520521");
        } else if (panduan == 1) {
            resp.setHeader("isEmail-exist","kajsldjasdjsalkdjalkdla");
            jdbcDemo.soutYourInfo(resp, "账号和邮箱都重复，请重新添加");
        } else if (panduan == 2) {
            jdbcDemo.soutYourInfo(resp, "账号重复，请重新添加");
        } else if (panduan == 3) {
            resp.setHeader("isEmail-exist","kajsldjasdjsalkdjalkdla");
            jdbcDemo.soutYourInfo(resp, "邮箱重复，请重新添加");
        }
    }
}
