package D20230907;

import D20230818.JDBCDemo;
import D20230906.UserDAO;
import jakarta.mail.MessagingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

@WebServlet("/sentEmail")
public class sentEmail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        UserDAO userDAO = new JDBCDemo();
        Random random = new Random();
        int randomNumber = random.nextInt(90000) + 10000;
        session.setAttribute("VerifyCode", randomNumber);
        try {
            userDAO.sentEmail(Integer.toString(randomNumber), email);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(randomNumber);
        resp.getWriter().write("{\"exist\":\"true\"}");

    }
}
