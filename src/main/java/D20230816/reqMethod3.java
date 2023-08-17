package D20230816;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/D20230816/ServletRequest3")
public class reqMethod3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("req.getParameterMap()="+ req.getParameterMap()+"\n");
        resp.getWriter().write("req.getParameterValues('pwd')=" + Arrays.toString(req.getParameterValues("pwd"))+"\n");
        resp.getWriter().write(req.getParameter("pwd")+"\n");
        req.setAttribute("haha","asd-as");
    }
}
