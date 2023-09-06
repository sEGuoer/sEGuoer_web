package D20230901;

import D20230904.mybatis.po.User;
import D20230818.JDBCDemo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/GetUserList")
public class GetUserList extends HttpServlet {
    private static volatile JDBCDemo jdbcDemo;


    public static JDBCDemo getJdbcTest() {
        if (jdbcDemo == null) {
            synchronized (JDBCDemo.class) {
                if (jdbcDemo == null) {
                    jdbcDemo = new JDBCDemo();
                }
            }
        }
        return jdbcDemo;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int nowPage ;
        String a = req.getParameter("nowPage");
        System.out.println(a);
        if (a == null){
            nowPage = 1;
        }else {
            nowPage = Integer.parseInt(a);
        }
        JDBCDemo jdbcDemo = getJdbcTest();
        Connection connection = jdbcDemo.getConnection();
        List<User> userList = jdbcDemo.testPreparedStatement();
        int pageSum = GetpageSum(userList);
        if ((nowPage - 1) * 9 > 0) {
            userList.subList(0, (nowPage - 1) * 9).clear();
        }
        req.setAttribute("nowPage", nowPage);
        req.setAttribute("list", userList);
        req.setAttribute("pageSum", pageSum);
        req.getRequestDispatcher("./D20230823/Admin.jsp").forward(req,resp);
    }

    public int GetpageSum(List<User> list) {
        int pageSum;
        if (list.size() % 9 == 0) {
            pageSum = list.size() / 9;
        } else {
            pageSum = list.size() / 9 + 1;
        }
        return pageSum;
    }
}
