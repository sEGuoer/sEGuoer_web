package bobing;

import bobing.method.randomGenerationCount.impl.AdminRandomGeneration;
import bobing.method.randomGenerationCount.randomGenerationCount;
import bobing.sevice.BoBing;
import bobing.sevice.impl.AdminRule;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MethodTest {
    @Test
    void AdminRandomGeneration() {
        randomGenerationCount count = new AdminRandomGeneration();
        String s = count.randomGeneration();
        System.out.println(s);
    }
    @Test
    void getEveryCode() {
        randomGenerationCount count = new AdminRandomGeneration();
        List<String> list =  count.getEveryCode();
        System.out.println(list);
    }
    @Test
    void getDiceCount() {
        randomGenerationCount count = new AdminRandomGeneration();
        List<String> list =  count.getEveryCode();
        System.out.println(list);
        BoBing boBing = new AdminRule();
        String award = boBing.getDiceCount(list);
        System.out.println(award);
    }
}
