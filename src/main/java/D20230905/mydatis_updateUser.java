package D20230905;



import D20230904.mybatis.mapper.UserMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/updateUser")
public class mydatis_updateUser extends HttpServlet {
    private static SqlSessionFactory sqlSessionFactory;

    public static void createSqlSessionFactory() throws Exception {
        String resource = "D20230904/mybatis/mybatisConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("pwd");
        String account = req.getParameter("account");
        String update = req.getParameter("updateEmail");
        try {
            createSqlSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (SqlSession session = sqlSessionFactory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            Date date = new Date();
            DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String updateUserTime = dateformat.format(date);
            mapper.update(email,account,password,update);
            mapper.add_Operation_record(mapper.getUser_id(email),updateUserTime,"用户更新");
            session.commit();
        }
    }
}
