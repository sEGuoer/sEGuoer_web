package D20230905;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HelloSlf4j {
    private static final Logger logger = LoggerFactory.getLogger(HelloSlf4j.class);
    public static void main(String[] args) {
        String a = "haha";
        logger.info("Hello World {}",a);
        logger.info("Hello World "+a);
        System.out.println("Hello World"+ a);
    }
}
