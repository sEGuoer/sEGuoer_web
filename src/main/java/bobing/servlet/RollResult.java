package bobing.servlet;

import bobing.method.randomGenerationCount.impl.AdminRandomGeneration;
import bobing.method.randomGenerationCount.randomGenerationCount;
import bobing.pojo.Present;
import bobing.sevice.BoBing;
import bobing.sevice.impl.AdminRule;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/bobing/RollResult")
public class RollResult extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        randomGenerationCount count = new AdminRandomGeneration();
        List<String> list =  count.getEveryCode();
        BoBing boBing = new AdminRule();
        String award = boBing.getDiceCount(list);
        Present present = boBing.getPrestent(award);
        resp.getWriter().write(list+"\n"+present);
    }
}
