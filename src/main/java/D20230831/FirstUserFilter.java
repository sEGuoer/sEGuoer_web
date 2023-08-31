package D20230831;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/FisrtFilter")
public class FirstUserFilter extends HttpFilter {



    @Override
    public void doFilter(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("请求前过滤");
        Cookie cookie = new Cookie("cookie","value");
        servletResponse.addCookie(cookie);
        servletRequest.setAttribute("key","value");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("请求后过滤");
    }
}
