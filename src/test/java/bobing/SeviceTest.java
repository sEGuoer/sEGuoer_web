package bobing;

import bobing.method.randomGenerationCount.impl.AdminRandomGeneration;
import bobing.method.randomGenerationCount.randomGenerationCount;
import bobing.pojo.Present;
import bobing.sevice.impl.AdminRule;
import org.junit.jupiter.api.Test;
import bobing.sevice.BoBing;

import java.util.ArrayList;
import java.util.List;

public class SeviceTest {
    @Test
    void getDiceCount() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        System.out.println(list);
        BoBing boBing = new AdminRule();
        String award = boBing.getDiceCount(list);
        System.out.println(award);
    }
    @Test
    void getPrestentTest() {
        BoBing boBing = new AdminRule();
        Present award = boBing.getPrestent("对堂");
        System.out.println(award);
    }
}
