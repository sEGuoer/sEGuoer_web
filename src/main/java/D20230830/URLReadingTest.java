package D20230830;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


class URLReadingTest {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080/iae_web2_war/CookieForEach");
      /*  InputStream inputStream = url.openStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader io = new BufferedReader(inputStreamReader);
        实际上下面代码等于上面的
        */
        URLConnection uc = url.openConnection();
        uc.setRequestProperty("Cookie","key5*60=value5*60");
        BufferedReader io = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        String inputLine;
        while ((inputLine = io.readLine()) != null) {
            System.out.println(inputLine);
        }
        io.close();
    }
}
