package bobing;

import bobing.method.randomGenerationCount.impl.AdminRandomGeneration;
import bobing.method.randomGenerationCount.randomGenerationCount;

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

}
