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
        JDBCDemo jdbcDemo = getJdbcTest();
        Connection connection = jdbcDemo.getConnection();
        User user = jdbcDemo.getUser(connection, email);
        System.out.println(user == null);
        resp.setHeader("isEmail-log-exist","kajsldjasdjsalkdjalkdla");
        if (user == null) {
            resp.setHeader("info","not found email");
        } else {
            if (user.getPassword().equals(password)) {
                resp.setHeader("info","can found user");
                if (user.getUsername().equals("admin")) {
                    resp.setHeader("isEmail-log-exist","1");
                    List<User> list = jdbcDemo.testPreparedStatement(connection);
                    if (list.size()<10){
                        req.setAttribute("list",list);
                        req.getRequestDispatcher("./D20230823/Admin.jsp").forward(req,resp);
                    }else {
                        if (req.getParameter("page") == null){
                            req.setAttribute("list",list);
                            req.getRequestDispatcher("./D20230823/Admin.jsp").forward(req,resp);
                        }else {
                            int page = Integer.parseInt(req.getParameter("page"));
                            if ((page - 1) * 9 > 0) {
                                list.subList(0, (page - 1) * 9).clear();
                                req.setAttribute("list",list);
                                req.getRequestDispatcher("./D20230823/Admin.jsp").forward(req,resp);
                            }else {
                                req.setAttribute("list",list);
                                req.getRequestDispatcher("./D20230823/Admin.jsp").forward(req,resp);
                            }
                        }
                    }
                } else {
                    resp.setHeader("isEmail-log-exist","2");
                    req.setAttribute("user",user);
                    req.getRequestDispatcher("./D20230823/User.jsp").forward(req,resp);
                }
            }else {
                resp.setHeader("info","password wrong,please input right password");
            }
        }
    }
}
