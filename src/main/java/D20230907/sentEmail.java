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
import java.util.Random;

@WebServlet("/sentEmail")
public class sentEmail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected String getVerifyCode(){
        String mumber = "0123456789";
        String verifyCode = "";
        Random random = new Random();
        for (int i = 0; i < 5 ; i++){
            int index = random.nextInt(mumber.length());
            char c = mumber.charAt(index);
            verifyCode += c;
        }
        return verifyCode;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = req.getParameter("email");
        UserDAO userDAO = new JDBCDemo();

        String randomNumber = getVerifyCode();
        session.setAttribute("VerifyCode", randomNumber);
        try {
            userDAO.sentEmail(randomNumber, email);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(randomNumber);
        resp.getWriter().write("{\"exist\":\"true\"}");

    }
}
