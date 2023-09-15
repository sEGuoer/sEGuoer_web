package D20230915.Demo.controller;

import D20230915.Demo.sevice.UserSevice;
import D20230915.Demo.sevice.impl.UserSeviceNope;

public class UserController {
    protected static UserSevice userSeviceNope = new UserSeviceNope();
    public static void main(String[] args) {
        userSeviceNope.userLogin("");
    }
}
