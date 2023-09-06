import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class helloWord {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String loginTime = dateformat.format(date);
        System.out.println(loginTime);
        System.out.println('\'');
    }
}
