package D20230915.Demo.dao;

import D20230915.Demo.pojo.User;

public interface UserDao {
    public User getUserByEmail(String email,String pwd);
}
