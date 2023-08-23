package D20230822;

import D20230815.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ej")
public class ELServlet extends HttpServlet {
    List<User> list = new ArrayList<User>();
    @Override
    public void init(ServletConfig config) throws ServletException {
        User user1 = new User();
        user1.setUser("admin","1@qq.com","111","123");
        list.add(user1);
        User user2 = new User();
        user2.setUser("person","2@qq.com","222","321");
        list.add(user2);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("user",list);
        req.getRequestDispatcher("./D20230822/jsp4.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
