package D20230901;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebFilter("/UserInfo")
public class UserCheckFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String role = (String) session.getAttribute("role");
        if (role == null){
            res.sendRedirect("./");
        }else {
            if (role.equals("user")){
                chain.doFilter(req,res);
            }else {
                res.sendRedirect("./");
            }
        }
    }
}
