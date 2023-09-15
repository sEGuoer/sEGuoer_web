package D20230915.Demo.sevice.impl;

import D20230915.Demo.dao.UserDao;
import D20230915.Demo.dao.impl.Nope;
import D20230915.Demo.dao.impl.Simple;
import D20230915.Demo.pojo.User;
import D20230915.Demo.sevice.UserSevice;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class UserSeviceSimple implements UserSevice, InitializingBean,DisposableBean  {
    protected UserDao userSimple;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("UserSeviceSimple.afterPropertiesSet");
    }

    public UserSeviceSimple() {
        System.out.println("UserSeviceNope");
    }
    public void setUserSimple(UserDao userSimple) {
        this.userSimple = userSimple;
    }

    public String userLogin(String email, String pwd){
        User user = userSimple.getUserByEmail(email,pwd);
        return "email="+user.getEmail()+" password="+user.getPassword();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("UserSeviceSimple.destroy");
    }
}
