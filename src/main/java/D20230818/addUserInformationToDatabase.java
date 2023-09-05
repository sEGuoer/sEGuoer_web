package D20230818;

import D20230815.User;
import D20230904.DruidDemo;
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
    private static volatile DruidDemo druidDemo;


    public static DruidDemo getdruidDemo() {
        if (druidDemo == null) {
            synchronized (DruidDemo.class) {
                if (druidDemo == null) {
                    druidDemo = new DruidDemo();
                }
            }
        }
        return druidDemo;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        DruidDemo druidDemo = getdruidDemo();
        String email = req.getParameter("email");
        User user = druidDemo.getUser(email);
        resp.setHeader("info", "can found user");
        Date date = new Date();
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String loginTime = dateformat.format(date);
        if (user.getUsername().equals("admin")) {
            req.setAttribute("AdminOrUser", "Admin");
            session.setAttribute("role", "admin");
            druidDemo.add_Operation_record(email, loginTime, "管理员登录");
            resp.sendRedirect("./GetUserList");
        } else {
            session.setAttribute("user", user);
            session.setAttribute("role", "user");
            druidDemo.add_Operation_record( email, loginTime, "用户登录");
            resp.sendRedirect("./UserInfo");
        }
        if (req.getParameter("nowPage") == null) {
            druidDemo.updateLoginTime(email, loginTime);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
