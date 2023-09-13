package D20230913;

import D20230908.Sevice;
import D20230908.UserSevice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/MySQL")
public class MySQL extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Sevice sevice = new UserSevice();
        String content = sevice.mdFileToHtmlFile("D20230912/mybatis/mybatisConfig.xml","front-end","content");
        System.out.println("123");
        System.out.println(content);
        req.setAttribute("Content",content);
        req.getRequestDispatcher("./post/MySQL.jsp").forward(req, resp);
    }
}
