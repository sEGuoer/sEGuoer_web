package D20230821;

import D20230904.mybatis.po.User;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/RegisterVerify")
public class RegisterVerify extends HttpServlet {
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JDBCDemo jdbcDemo = getJdbcTest();
        String email = req.getParameter("email");
        Connection connection = jdbcDemo.getConnection();
        Date date = new Date();
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String registerTime = dateformat.format(date);
        jdbcDemo.add_Operation_record(jdbcDemo.getUser_id(email),registerTime,"用户注册");
        req.getRequestDispatcher("./verify").forward(req, resp);
    }
}
