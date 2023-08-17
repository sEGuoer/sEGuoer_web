package D20230816;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/D20230816/ServletRequest1")
public class reqMethod1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("GBK");
        resp.setCharacterEncoding("GBK");
        resp.getWriter().write("req.getMethod()="+req.getMethod()+"\n");
        resp.getWriter().write("req.getContextPath()=" + req.getContextPath() + "\n");
        resp.getWriter().write("req.getRequestURL()=" + String.valueOf(req.getRequestURL()) + "\n");
        resp.getWriter().write("req.getRequestURI()=" + req.getRequestURI() + "\n");
        resp.getWriter().write("req.getQueryString()=" + req.getQueryString() + "\n");
        System.out.println(req.getMethod());
        System.out.println(req.getContextPath());
        System.out.println(req.getRequestURL());
        System.out.println(req.getRequestURI());
        System.out.println(req.getQueryString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("GBK");
        resp.setCharacterEncoding("GBK");
        System.out.println(req.getMethod());
        System.out.println(req.getContextPath());
        System.out.println(req.getRequestURL());
        System.out.println(req.getRequestURI());
        System.out.println(req.getQueryString());    }
}
