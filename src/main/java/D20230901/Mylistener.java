package D20230901;

import D20230818.JDBCDemo;
import D20230904.DruidDemo;
import D20230904.mybatis.mapper.UserMapper;
import D20230906.UserDAO;
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
        String MethodToConnectDB = sce.getServletContext().getInitParameter("MethodToConnectDB");
        UserDAO userDAO = null;
        if (MethodToConnectDB == "JDBC"){
            userDAO = new JDBCDemo();
        }else if (MethodToConnectDB == "mybatis"){
            userDAO = UserMapper.createSqlSessionFactory();
        }else if (MethodToConnectDB == "DuridDemo"){
            userDAO = new DruidDemo();
        }
        sce.getServletContext().setAttribute("userDAO",userDAO);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Mylistenner contextDestroyed");
    }
}
