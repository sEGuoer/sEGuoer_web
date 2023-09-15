package D20230915.Demo.controller;

import D20230915.Demo.sevice.UserSevice;
import D20230915.Demo.sevice.impl.UserSeviceNope;
import D20230915.Demo.sevice.impl.UserSeviceSimple;

public class UserController {
    protected static UserSevice userSeviceNope = new UserSeviceSimple();
    public static void main(String[] args) {
        System.out.println(userSeviceNope.userLogin("123", "123"));
    }
}
