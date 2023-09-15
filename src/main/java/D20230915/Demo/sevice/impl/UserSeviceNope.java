package D20230915.Demo.sevice.impl;

import D20230915.Demo.dao.UserDao;
import D20230915.Demo.dao.impl.Nope;
import D20230915.Demo.pojo.User;
import D20230915.Demo.sevice.UserSevice;

public class UserSeviceNope implements UserSevice {

    protected UserDao userNope;



    public void setUserNope(UserDao userNope) {
        this.userNope = userNope;
    }

    public String userLogin(String email, String pwd){
          User user = userNope.getUserByEmail(email,pwd);
        return user.getPassword();}
}
