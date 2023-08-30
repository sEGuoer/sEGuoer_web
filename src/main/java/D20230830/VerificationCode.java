package D20230830;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

@WebServlet("/VerificationCode")
public class VerificationCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode("D20230817/QQ图片20230807174928.png","GBK"));
        下载图片*/
        String url1 = this.getServletContext().getRealPath("D20230817/QQ图片20230807174928.png");
        String url2 = this.getServletContext().getRealPath("D20230817/img.png");
        String[] url = {url1,url2};
        Random random = new Random();
        double randomMumber = random.nextDouble();
        int result;
        if (randomMumber < 0.5){
            result = 0;
        }else {result = 1;}
        FileInputStream fis = new FileInputStream(url[result]);
        //2. 获取response字节输出流
        ServletOutputStream os = resp.getOutputStream();
        //3. 完成流的copy
        byte[] buff = new byte[1024];
        int len = 0;
        while ((len = fis.read(buff)) != -1) {
            os.write(buff, 0, len);
        }
        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
