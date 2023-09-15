package D20230915.Demo.sevice.impl;

import D20230915.Demo.dao.UserDao;
import D20230915.Demo.dao.impl.Nope;
import D20230915.Demo.dao.impl.Simple;
import D20230915.Demo.pojo.User;
import D20230915.Demo.sevice.UserSevice;
import org.apache.taglibs.standard.lang.jstl.BeanInfoProperty;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.expression.BeanResolver;
import org.springframework.validation.BeanPropertyBindingResult;

import java.beans.BeanInfo;
import java.beans.BeanProperty;
import java.beans.PropertyDescriptor;
import java.beans.beancontext.BeanContext;
import java.lang.reflect.Method;

public class UserSeviceSimple implements UserSevice, InitializingBean, DisposableBean {
    protected UserDao userSimple;

    public UserSeviceSimple(UserDao userSimple) {
        this.userSimple = userSimple;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("UserSeviceSimple.afterPropertiesSet");
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
