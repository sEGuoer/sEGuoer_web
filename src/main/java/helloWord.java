import D20230818.JDBCDemo;
import D20230904.mybatis.po.User;
import D20230906.UserDAO;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;
import jakarta.mail.MessagingException;

import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class helloWord {
    public static void main(String[] args) throws MessagingException {
        /*Date date = new Date();
        System.out.println(date);
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String loginTime = dateformat.format(date);
        System.out.println(loginTime);
        System.out.println('\'');*/
      /*  User user = new User("1","12","123","1234");
        JSONObject jsonObject = JSONObject.parseObject(user.toString());
        System.out.println(jsonObject.toJSONString());
        System.out.println(user.toString());*//*
        UserDAO userDAO = new JDBCDemo();
        userDAO.sentEmail("12345","709074535@qq.com");*/
        String mumber = "0123456789";
        String verifyCode = "";
        Random random = new Random();
        for (int i = 0; i < 5 ; i++){
            int index = random.nextInt(mumber.length());
            char c = mumber.charAt(index);
            verifyCode += c;
        }
        System.out.println(verifyCode);
    }
}
