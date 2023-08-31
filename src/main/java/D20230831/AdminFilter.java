package D20230831;

import D20230815.User;
import com.mysql.cj.Session;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebFilter("/SetSession")
public class AdminFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        String a = (String) req.getSession().getAttribute("role") ;
        if(a == "admin"){
            HttpSession session = req.getSession();
            List<User> list = (List<User>) session.getAttribute("list");
            int pageSum = (int)session.getAttribute("pageSum");
            req.setAttribute("list",list);
            req.setAttribute("pageSum",pageSum);
            chain.doFilter(req,resp);
        }else if (a == "person"){
            HttpSession session = req.getSession();
            User user = (User)session.getAttribute("user");
            req.setAttribute("user",user);
            chain.doFilter(req,resp);
        }else {
            resp.sendRedirect ("./index_login.html");
        }
    }
}
