package D20230825;


import D20230815.User;
import D20230818.JDBCDemo;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/updateUser")
public class updateUser extends HttpServlet {
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

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        JDBCDemo jdbcTest = new JDBCDemo();
        setJdbcTest(jdbcTest);
        User user = new User();
        setUser(user);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("pwd");
        String account = req.getParameter("account");
        String update = req.getParameter("updateEmail");
        JDBCDemo jdbcDemo = getJdbcTest();
        Connection connection = jdbcDemo.getConnection();
        jdbcDemo.update(connection,email,account,password,update);
    }
}

