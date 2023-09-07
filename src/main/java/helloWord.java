import D20230904.mybatis.po.User;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.JsonArray;

import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class helloWord {
    public static void main(String[] args) {
        /*Date date = new Date();
        System.out.println(date);
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String loginTime = dateformat.format(date);
        System.out.println(loginTime);
        System.out.println('\'');*/
        User user = new User("1","12","123","1234");
        JSONObject jsonObject = JSONObject.parseObject(user.toString());
        System.out.println(jsonObject.toJSONString());
        System.out.println(user.toString());
    }
}
