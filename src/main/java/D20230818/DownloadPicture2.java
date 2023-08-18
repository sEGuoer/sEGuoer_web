package D20230818;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/D20230817/GetPicture")
public class DownloadPicture2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = this.getServletContext().getRealPath("D20230817/QQ图片20230807174928.png");
        System.out.println(url);
        FileInputStream fis = new FileInputStream(url);
        //2. 获取response字节输出流
        ServletOutputStream os = resp.getOutputStream();
        //3. 完成流的copy
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode("D20230817/QQ图片20230807174928.png","GBK"));
        IOUtils.copy(fis, os);
        fis.close();
    }
}
