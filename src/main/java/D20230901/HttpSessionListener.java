package D20230901;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;

@WebListener
public class HttpSessionListener implements jakarta.servlet.http.HttpSessionListener {
    private int userCount = 0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("HttpSessionListener sessionCreated");
        userCount++;
        se.getSession().getServletContext().setAttribute("userCounts",userCount);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        userCount--;
        se.getSession().getServletContext().setAttribute("userCounts",userCount);
        System.out.println("HttpSessionListener sessionDestroyed");
    }
}
