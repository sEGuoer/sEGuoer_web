import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/tet")
public class HelloServlet extends HttpServlet {
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servletinit");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setCharacterEncoding("GBK");
        String username = request.getParameter("email");
        String password = request.getParameter("pwd");
            System.out.println(username+" "+password);
        //如果输入的用户名是abc，密码是123，则表示注册成功，反之注册失败
        if("abc".equals(username)&&"123".equals(password)){
            response.getWriter().write("登陆成功");
        }else{
            response.getWriter().write("登陆失败");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setCharacterEncoding("GBK");
        String username = request.getParameter("email");
        String password = request.getParameter("pwd");
            System.out.println(username+" "+password);
        //如果输入的用户名是abc，密码是123，则表示注册成功，反之注册失败
        if("abc".equals(username)&&"123".equals(password)){
            response.getWriter().write("登陆成功");
        }else{
            response.getWriter().write("登陆失败");
        }
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("destroy");
    }
}
