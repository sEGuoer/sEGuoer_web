package D20230817;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Base64;

@WebServlet("/D20230817/GetPicture")
public class GetPicture extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode("D20230817/QQ图片20230807174928.png","GBK"));
        下载图片*/
        String url = this.getServletContext().getRealPath("D20230817/QQ图片20230807174928.png");
        System.out.println(url);
        FileInputStream fis = new FileInputStream(url);
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
