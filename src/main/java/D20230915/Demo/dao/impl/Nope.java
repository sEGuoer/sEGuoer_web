package D20230915.Demo.dao.impl;

import D20230915.Demo.dao.UserDao;
import D20230915.Demo.pojo.User;


public class Nope implements UserDao {
    @Override
    public User getUserByEmail(String email) {
        User user = new User();
        user.setEmail(email);
        user.setPassword("");
        return user;
    }
}
