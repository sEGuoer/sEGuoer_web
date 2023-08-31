package D20230831;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/FisrtFilter")
public class FirstFilterServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getAttribute("key") == null){
        }else {
            req.setAttribute("key","value/update");
        }
        System.out.println("doGet");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies){
            resp.getWriter().write(cookie.getName() + "=" + cookie.getValue() +System.lineSeparator());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
