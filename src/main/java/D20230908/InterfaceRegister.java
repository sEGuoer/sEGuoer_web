package D20230908;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/RegisterVerify")
public class InterfaceRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    public void soutYourInfo(HttpServletResponse resp, String info) throws IOException {
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
                        "<p>" + info + "</p>" +
                        "</body>\n" +
                        "</html>\n"
        );
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String email = req.getParameter("email");
        String password = req.getParameter("pwd");
        String account = req.getParameter("account");
        String verifyCode = req.getParameter("VerifyCode");
        HttpSession session = req.getSession();
        String sessionCode = (String) session.getAttribute("VerifyCode");
        Sevice sevice = new UserSevice();
        String register = sevice.userRegister(email,password,account,sessionCode.equals(verifyCode));
        System.out.println(sessionCode.equals(verifyCode));
        if (register.equals("啥也不干")){
            resp.setHeader("isEmail-exist", "kajsldjasdjsalkdjalkdla");
        }else {
            if (password != "" && account != "") {
                switch (register) {
                    case "注册成功", "验证码错误，请重新注册" -> {
                        if (register.equals("注册成功")) {
                            resp.setHeader("info", "can found user");
                            req.getRequestDispatcher("./verify").forward(req, resp);
                        } else {
                            soutYourInfo(resp, "验证码错误，请重新注册");
                        }
                    }
                    case "账号和邮箱都重复，请重新注册" -> {
                        resp.setHeader("isEmail-exist", "kajsldjasdjsalkdjalkdla");
                        soutYourInfo(resp, "账号和邮箱都重复，请重新注册");
                    }
                    case "账号重复，请重新注册" -> soutYourInfo(resp, "账号重复，请重新注册");
                    case "邮箱重复，请重新注册" -> {
                        resp.setHeader("isEmail-exist", "kajsldjasdjsalkdjalkdla");
                        soutYourInfo(resp, "邮箱重复，请重新注册");
                    }
                }
            }
        }
    }
}
