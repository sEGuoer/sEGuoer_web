package D20230915;


import D20230915.Demo.dao.UserDao;
import D20230915.Demo.sevice.UserSevice;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class bean {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext cpa = new ClassPathXmlApplicationContext("bean.xml");
        UserSevice userSevice = (UserSevice)cpa.getBean("UserSevice");
        UserDao userDao = (UserDao)cpa.getBean("UserDao");
        System.out.println(userSevice);
        System.out.println(userDao);
    }
}
