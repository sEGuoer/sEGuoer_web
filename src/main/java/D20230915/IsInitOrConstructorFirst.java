package D20230915;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/IsInitOrConstructorFirst")
public class IsInitOrConstructorFirst implements Servlet {


    public IsInitOrConstructorFirst() {
        System.out.println("IsInitOrConstructorFirst");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
    }


}
