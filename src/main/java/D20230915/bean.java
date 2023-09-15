package D20230915;


import D20230915.Demo.dao.UserDao;
import D20230915.Demo.sevice.UserSevice;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class bean {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext cpa = new ClassPathXmlApplicationContext("bean.xml");
        UserSevice userSevice = (UserSevice)cpa.getBean("UserSevice");
        UserSevice userSevice1 = (UserSevice)cpa.getBean("UserSevice");
        UserDao userDao = cpa.getBean(UserDao.class);
        System.out.println(userSevice.userLogin("1","1"));
        System.out.println(userSevice1.userLogin("1","1"));
        System.out.println(userDao);
        cpa.close();
    }
}
