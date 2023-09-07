package D20230907;

import D20230818.JDBCDemo;
import D20230904.mybatis.po.User;
import D20230906.UserDAO;
import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/searchUser")
public class searchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        String email = req.getParameter("email");
        UserDAO mapper = new JDBCDemo();
        User user = mapper.searchUser(email);
        if (user == null) {
            resp.getWriter().write("{\"exist\":\"false\"}");
            System.out.println(2);
        } else {
            JSONObject jsonObject = JSONObject.parseObject(user.toString());
            System.out.println(jsonObject.toJSONString());
            resp.getWriter().write(jsonObject.toJSONString());
            System.out.println(1);
        }
    }
}
