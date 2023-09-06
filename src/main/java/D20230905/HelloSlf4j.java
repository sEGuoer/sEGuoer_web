package D20230905;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class HelloSlf4j {
    public static void main(String[] args) {
//        String a = "haha";
//        log.info("Hello World {}",a);
//        System.out.println("Hello World"+ a);
        log.debug("debug msg");
        log.info("info msg");
        log.warn("warn msg");
        log.error("error msg");
    }
}
