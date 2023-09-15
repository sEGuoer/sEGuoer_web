package D20230915.Demo.dao.impl;

import D20230915.Demo.dao.UserDao;
import D20230915.Demo.pojo.User;

import java.util.*;

public class InjectDemoUserDao implements UserDao {
    public InjectDemoUserDao(int straightValue, int[] array, List<String> list, Set<String> set, Map<String, String> map, Properties properties) {
        this.straightValue = straightValue;
        this.array = array;
        this.list = list;
        this.set = set;
        this.map = map;
        this.properties = properties;
    }

    private int straightValue;

    private int[] array;

    private List<String> list;

    private Set<String> set;

    private Map<String,String> map;

    private Properties properties;



    public int getStraightValue() {
        return straightValue;
    }

    public int[] getArray() {
        return array;
    }

    public List<String> getList() {
        return list;
    }

    public Set<String> getSet() {
        return set;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public Properties getProperties() {
        return properties;
    }

    @Override
    public User getUserByEmail(String email, String pwd) {
        System.out.println("InjectDemoUserDao.getUserByEmail");
        System.out.println("自动注入的straight Value=" +getStraightValue());
        System.out.println("自动注入的数组=" + Arrays.toString(getArray()));
        System.out.println("自动注入的List=" + getList().toString());
        System.out.println("自动注入的Set=" + getSet().toString());
        System.out.println("自动注入的Map=" + getMap().toString());
        System.out.println("自动注入的properties=" + getProperties().toString());


        return null;
    }
}
