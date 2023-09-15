package D20230915.Demo.sevice;

import D20230915.Demo.dao.UserDao;
import D20230915.Demo.dao.impl.Nope;
import D20230915.Demo.pojo.User;

public interface UserSevice {

    public default String userLogin(String email,String pwd){return "";}
}
