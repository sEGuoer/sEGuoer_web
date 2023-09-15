package D20230915.Demo.sevice.impl;

import D20230915.Demo.dao.UserDao;
import D20230915.Demo.dao.impl.Nope;
import D20230915.Demo.pojo.User;
import D20230915.Demo.sevice.UserSevice;

public class UserSeviceNope implements UserSevice {

    protected UserDao userNope = new Nope();
    public String userLogin(String email){
          User user = userNope.getUserByEmail(email);
        return user.getPassword();}
}
