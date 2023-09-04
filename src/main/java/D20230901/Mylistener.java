package D20230901;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.net.http.WebSocket;

@WebListener
public class Mylistener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("userCounts",0);
        System.out.println(sce.getServletContext().getInitParameter("hello-world"));
        System.out.println("Mylistenner contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Mylistenner contextDestroyed");
    }
}
