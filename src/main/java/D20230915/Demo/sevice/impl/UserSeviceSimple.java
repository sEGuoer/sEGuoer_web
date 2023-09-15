package D20230915.Demo.sevice.impl;

import D20230915.Demo.dao.UserDao;
import D20230915.Demo.dao.impl.Nope;
import D20230915.Demo.dao.impl.Simple;
import D20230915.Demo.pojo.User;
import D20230915.Demo.sevice.UserSevice;

public class UserSeviceSimple implements UserSevice {
    protected UserDao userSimple;
    public UserSeviceSimple() {
        System.out.println("UserSeviceNope");
    }
    public void setUserSimple(UserDao userSimple) {
        this.userSimple = userSimple;
    }
    public void init() {
        System.out.println("init");
    }
    public void destroy() {
        System.out.println("destroy");
    }

    public String userLogin(String email, String pwd){
        User user = userSimple.getUserByEmail(email,pwd);
        return "email="+user.getEmail()+" password="+user.getPassword();
    }
}
