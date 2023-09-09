package D20230908;

import D20230818.JDBCDemo;
import D20230904.mybatis.po.User;
import D20230906.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/verify")

public class InterfaceLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession httpSession = req.getSession();
        String email = req.getParameter("email");
        String password = req.getParameter("pwd");
        UserDAO jdbcDemo = new JDBCDemo();
        User user = jdbcDemo.getUser(email);
        System.out.println(email + " " + password);
        System.out.println(req.getAttribute("Content-type"));
        Sevice sevice = new UserSevice();
        String userTypes = sevice.userLogin(email,password);
        req.setAttribute("email", email);
        resp.setHeader("isEmail-log-exist", "2");
        if (userTypes.equals("NoUser")) {
            resp.setHeader("isEmail-log-exist", "kajsldjasdjsalkdjalkdla");
            resp.setHeader("info", "not found email");
        } else {
            if (userTypes.equals("AdminLogin") || userTypes.equals("UserLogin")) {
                resp.setHeader("info", "can found user");
                Date date = new Date();
                DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String loginTime = dateformat.format(date);
                if (userTypes.equals("AdminLogin")) {
                    req.setAttribute("AdminOrUser", "Admin");
                    httpSession.setAttribute("role", "admin");
                    resp.sendRedirect("./GetUserList");
                } else {
                    httpSession.setAttribute("user", user);
                    httpSession.setAttribute("role", "user");
                    resp.sendRedirect("./UserInfo");
                }
                if (req.getParameter("nowPage") == null) {
                    jdbcDemo.updateLoginTime(email, loginTime);
                }
            } else {
                resp.setHeader("info", "password wrong,please input right password");
            }
        }
    }
}
