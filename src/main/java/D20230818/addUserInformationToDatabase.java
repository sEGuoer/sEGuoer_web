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
        String email = req.getParameter("email");
        String password = req.getParameter("pwd");
        String account = req.getParameter("account");
        JDBCDemo jdbcDemo = getJdbcTest();
        Connection connection = jdbcDemo.getConnection();
        jdbcDemo.add(connection,email,password,account);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req);
//        req.setCharacterEncoding("GBK");
//        resp.setCharacterEncoding("GBK");
        String email = req.getParameter("email");
        String password = req.getParameter("pwd");
        System.out.println(email + " " + password);
        JDBCDemo jdbcDemo = getJdbcTest();
        Connection connection = jdbcDemo.getConnection();
        List<User> list = jdbcDemo.testPreparedStatement(connection);
        boolean isEmail = false;
        //如果输入的用户名是abc，密码是123，则表示注册成功，反之注册失败
        for (int i = 0; i < list.size(); i++) {
            User useri = list.get(i);
            if (useri.getEmail().equals(email)) {
                isEmail = true;
                if (useri.getPassword().equals(password)) {
                    if (useri.getUsername().equals("admin1")) {
                        resp.getWriter().write(
                                "<!doctype html>\n" +
                                        "<html lang=\"en\">\n" +
                                        "<head>\n" +
                                        "    <meta charset=\"UTF-8\">\n" +
                                        "    <meta name=\"viewport\"\n" +
                                        "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                                        "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                                        "    <title>sEGuoer's_website</title>" +
                                        "</head>\n" +
                                        "<body>\n" +
                                        "<p>" + list.toString() + "</p>" +
                                        "</body>\n" +
                                        "</html>\n"
                        );
                    } else {
                        resp.getWriter().write(
                                "<!doctype html>\n" +
                                        "<html lang=\"en\">\n" +
                                        "<head>\n" +
                                        "    <meta charset=\"UTF-8\">\n" +
                                        "    <meta name=\"viewport\"\n" +
                                        "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                                        "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                                        "    <title>sEGuoer's_website</title>" +
                                        "</head>\n" +
                                        "<body>\n" +
                                        "<p>" + email + "</p>" +
                                        "</body>\n" +
                                        "</html>\n"
                        );
                    }
                    break;
                } else {
                    resp.getWriter().write(
                            "<!doctype html>\n" +
                                    "<html lang=\"en\">\n" +
                                    "<head>\n" +
                                    "    <meta charset=\"UTF-8\">\n" +
                                    "    <meta name=\"viewport\"\n" +
                                    "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                                    "    <title>sEGuoer's_website</title>" +
                                    "</head>\n" +
                                    "<body>\n" +
                                    "<p>" + "密码错误,登陆失败" + "</p>" +
                                    "</body>\n" +
                                    "</html>\n"
                    );
                }
            }
        }
        if (isEmail == false) {
            resp.getWriter().write("<!doctype html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta name=\"viewport\"\n" +
                    "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                    "    <title>sEGuoer's_website</title>" +
                    "</head>\n" +
                    "<body>\n" +
                    "<p>" + "找不到邮箱,登陆失败" + "</p>" +
                    "</body>\n" +
                    "</html>\n");
        }
    }
}
