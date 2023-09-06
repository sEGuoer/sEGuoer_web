package D20230829;

import D20230818.JDBCDemo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/clearSession")
public class LogoutClearSession extends HttpServlet {
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
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        JDBCDemo jdbcDemo = getJdbcTest();
        Connection connection = jdbcDemo.getConnection();
        Date date = new Date();
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String logoutTime = dateformat.format(date);
       if (!email.equals("")){
           if (email.equals("admin")){
               jdbcDemo.add_Operation_record(jdbcDemo.getUser_id(email),logoutTime,"管理员注销");
           }else {
               jdbcDemo.add_Operation_record(jdbcDemo.getUser_id(email) ,logoutTime,"用户注销");
           }
       }
        req.getSession().invalidate();
    }
}
