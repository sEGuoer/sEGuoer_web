package D20230818;

import D20230815.User;
import com.mysql.cj.Session;
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
import java.util.List;

@WebServlet("/verify")
public class addUserInformationToDatabase extends HttpServlet {
    private static volatile JDBCDemo jdbcDemo;


    public static JDBCDemo getJdbcTest() {
        if (jdbcDemo == null) {
            synchronized (JDBCDemo.class) {
                if (jdbcDemo == null) {
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
        HttpSession session = req.getSession();
        JDBCDemo jdbcDemo = getJdbcTest();
        Connection connection = jdbcDemo.getConnection();
        String email = req.getParameter("email");
        User user = jdbcDemo.getUser(connection, email);
        resp.setHeader("info", "can found user");
        Date date = new Date();
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String loginTime = dateformat.format(date);

        if (user.getUsername().equals("admin")) {
            resp.setHeader("isEmail-log-exist", "1");
            List<User> list = jdbcDemo.testPreparedStatement(connection);
            int pageSum;
            if (list.size() % 9 == 0) {
                pageSum = list.size() / 9;
            } else {
                pageSum = list.size() / 9 + 1;
            }
            if (list.size() < 10) {
                req.setAttribute("AdminOrUser", "Admin");
                session.setAttribute("list", list);
                session.setAttribute("pageSum", pageSum);
                session.setAttribute("role", "admin");
            } else {
                if (req.getParameter("page") == null) {
                    req.setAttribute("AdminOrUser", "Admin");
                    session.setAttribute("list", list);
                    session.setAttribute("pageSum", pageSum);
                    session.setAttribute("role", "admin");
                } else {
                    int page = Integer.parseInt(req.getParameter("page"));
                    if ((page - 1) * 9 > 0) {
                        list.subList(0, (page - 1) * 9).clear();
                        session.setAttribute("list", list);
                        session.setAttribute("pageSum", pageSum);
                        session.setAttribute("role", "admin");
                    } else {
                        session.setAttribute("list", list);
                        session.setAttribute("pageSum", pageSum);
                        session.setAttribute("role", "admin");

                    }
                }
            }
            jdbcDemo.add_Operation_record(connection,email,loginTime,"管理员登录");
        } else {
            resp.setHeader("isEmail-log-exist", "2");
            session.setAttribute("user", user);
            session.setAttribute("role", "person");
            jdbcDemo.add_Operation_record(connection,email,loginTime,"用户登录");
        }
        jdbcDemo.updateLoginTime(connection,email,loginTime);
        resp.sendRedirect("./SetSession");
    }
}
