package D20230815;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/verify")
public class Method extends HttpServlet {
    private List<User> list;

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setUser("admin1", "admin@1", "123");
        User user2 = new User();
        user2.setUser("person1", "person@1", "1234");
        User user3 = new User();
        user3.setUser("person2", "person@2", "12345");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        setList(list);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println(req);
       /* req.setCharacterEncoding("GBK");
        resp.setCharacterEncoding("GBK");*/
        String username = req.getParameter("email");
        String password = req.getParameter("pwd");
        String account = req.getParameter("account");
        System.out.println(account + " " + username + " " + password);
        //如果输入的用户名是abc，密码是123，则表示注册成功，反之注册失败
        resp.getWriter().write("注册成功");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println(req);
//        req.setCharacterEncoding("GBK");
//        resp.setCharacterEncoding("GBK");
        String email = req.getParameter("email");
        String password = req.getParameter("pwd");
        System.out.println(email + " " + password);
        List<User> list = getList();
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

