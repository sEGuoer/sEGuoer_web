package D20230908;

import D20230818.JDBCDemo;
import D20230904.mybatis.po.User;
import D20230906.UserDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserSevice implements Sevice {
    public String userRegister(String email, String password, String account, boolean IsVerifyCodeCorrect) {
        UserDAO jdbcDemo = new JDBCDemo();
        System.out.println(IsVerifyCodeCorrect);
        int panduan = jdbcDemo.add(email, password, account, IsVerifyCodeCorrect);
        if (panduan == 5) {
            return "啥也不干";
        } else {
            if (password != "" && account != "") {
                if (panduan == 0) {
                    if (IsVerifyCodeCorrect) {
//                        resp.setHeader("info", "can found user");
                        Date date = new Date();
                        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        String registerTime = dateformat.format(date);
                        jdbcDemo.add_Operation_record(jdbcDemo.getUser_id(email), registerTime, "用户注册");
                        return "注册成功";
                    } else {
                        return "验证码错误，请重新注册";
                    }
                } else if (panduan == 1) {
                    return "账号和邮箱都重复，请重新注册";
                } else if (panduan == 2) {
                    return "账号重复，请重新注册";
                } else if (panduan == 3) {
                    return "邮箱重复，请重新注册";
                }
            }
            return "密码或账号为空";
        }
    }

    public String userLogin(String email, String password) {
        UserDAO jdbcDemo = new JDBCDemo();
        User user = jdbcDemo.getUser(email);
        if (user == null) {
            return "NoUser";
        } else {
            if (user.getPassword().equals(password)) {
                Date date = new Date();
                DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String loginTime = dateformat.format(date);
                if (user.getUsername().equals("admin")) {
                    jdbcDemo.add_Operation_record(jdbcDemo.getUser_id(email), loginTime, "管理员登录");
                    return "AdminLogin";
                } else {
                    jdbcDemo.add_Operation_record(jdbcDemo.getUser_id(email), loginTime, "用户登录");
                    return "UserLogin";
                }
            }
            return "密码错误";
        }
    }

    public String mdFileToHtmlFile(String resource,String title ,String content) throws IOException {
        Parser parser = Parser.builder().build();
        String xml = resource;
        InputStream inputStream = Resources.getResourceAsStream(xml);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        D20230912.mybatis.mapper.UserMapper mapper = session.getMapper(D20230912.mybatis.mapper.UserMapper.class);
        Map map = new HashMap();
        map.put("title",title);
        map.put("content",content);
        String input = mapper.searchBlog(map).get(0).getContent();
        Node document = parser.parse(input);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String Content = renderer.render(document);
        System.out.println(Content);
        return Content;
    }

}
