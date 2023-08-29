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
import java.util.List;

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
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req);
//        req.setCharacterEncoding("GBK");
//        resp.setCharacterEncoding("GBK");
        String email = req.getParameter("email");
        String password = req.getParameter("pwd");
//        System.out.println(email + " " + password);
        HttpSession session = req.getSession();
        JDBCDemo jdbcDemo = getJdbcTest();
        Connection connection = jdbcDemo.getConnection();
        User user = jdbcDemo.getUser(connection, email);
        System.out.println(user == null);
        resp.setHeader("isEmail-log-exist","2");
        if (user == null) {
            resp.setHeader("isEmail-log-exist","kajsldjasdjsalkdjalkdla");
            resp.setHeader("info","not found email");
        } else {
            if (user.getPassword().equals(password)) {
                resp.setHeader("info","can found user");
                if (user.getUsername().equals("admin")) {
                    resp.setHeader("isEmail-log-exist","1");
                    List<User> list = jdbcDemo.testPreparedStatement(connection);
                    int pageSum;
                    if (list.size()%9 == 0){
                        pageSum = list.size()/9;
                    }else {
                        pageSum = list.size()/9 + 1;
                    }
                    if (list.size()<10){
                        session.setAttribute("list",list);
                        session.setAttribute("pageSum",pageSum);
                        session.setAttribute("role","admin");
                        resp.sendRedirect ("./SetSession");
                    }else {
                        if (req.getParameter("page") == null){
                            session.setAttribute("list",list);
                            session.setAttribute("pageSum",pageSum);
                            session.setAttribute("role","admin");
                            resp.sendRedirect ("./SetSession");
                        }else {
                            int page = Integer.parseInt(req.getParameter("page"));
                            if ((page - 1) * 9 > 0) {
                                list.subList(0, (page - 1) * 9).clear();
                                session.setAttribute("list",list);
                                session.setAttribute("pageSum",pageSum);
                                session.setAttribute("role","admin");
                                resp.sendRedirect ("./SetSession");
                            }else {
                                session.setAttribute("list",list);
                                session.setAttribute("pageSum",pageSum);
                                session.setAttribute("role","admin");
                                resp.sendRedirect ("./SetSession");
                            }
                        }
                    }
                } else {
                    resp.setHeader("isEmail-log-exist","2");
                    session.setAttribute("user",user);
                    session.setAttribute("role","person");
                    resp.sendRedirect ("./SetSession");
                }
            }else {
                resp.setHeader("info","password wrong,please input right password");
            }
        }
    }
}
