package D20230905;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloSlf4j {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HelloSlf4j.class);
        logger.info("Hello World");
    }
}
