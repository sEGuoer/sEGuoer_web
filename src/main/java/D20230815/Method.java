package D20230815;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/verify")
public class Method extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println(req);
        req.setCharacterEncoding("GBK");
        resp.setCharacterEncoding("GBK");
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
        req.setCharacterEncoding("GBK");
        resp.setCharacterEncoding("GBK");
        String username = req.getParameter("email");
        String password = req.getParameter("pwd");
        System.out.println(username + " " + password);
        //如果输入的用户名是abc，密码是123，则表示注册成功，反之注册失败
        if ("abc@123".equals(username) && "123".equals(password)) {
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
                            "<p>"+username+"</p>"+
                            "</body>\n" +
                            "</html>\n"
            );
        } else {
            resp.getWriter().write("登陆失败");
        }
    }
}

