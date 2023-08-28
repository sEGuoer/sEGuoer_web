package D20230828;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/CookieForEach")
public class ForEachCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Cookie cookie1 = new Cookie("key2","value2");
//        resp.addCookie(cookie1);
        if (req.getCookies() == null){
        }else {
            Cookie[] cookies = req.getCookies();
            for (Cookie cookie : cookies){
                resp.getWriter().write(cookie.getName() +System.lineSeparator());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
