package D20230829;

import D20230815.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/SetSession")
public class SetSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String a = (String) req.getSession().getAttribute("role") ;
        if(a == "admin"){
            List<User> list = (List<User>) session.getAttribute("list");
            int pageSum = (int)session.getAttribute("pageSum");
            req.setAttribute("list",list);
            req.setAttribute("pageSum",pageSum);
            req.getRequestDispatcher("./D20230823/Admin.jsp").forward(req,resp);
        }else if (a == "person"){
            User user = (User)session.getAttribute("user");
            req.setAttribute("user",user);
            req.getRequestDispatcher("./D20230823/User.jsp").forward(req,resp);
        }
    }
}
