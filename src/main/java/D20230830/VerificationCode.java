package D20230830;


import com.mysql.cj.Session;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.QuadCurve2D;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;


import static com.wf.captcha.base.Randoms.num;

@WebServlet("/VerificationCode")
public class VerificationCode extends HttpServlet {
    protected String chars = null;
    public static final char ALPHA[] ={'1','2','3','4','5','6','7','8','9','0'};
    protected static final SecureRandom RANDOM = new SecureRandom();
    protected static final int numMaxIndex = 10;
    public static final int[][] COLOR = {{0, 135, 255}, {51, 153, 51}, {255, 102, 102}, {255, 153, 0}, {153, 102, 0}, {153, 102, 153}, {51, 153, 153}, {102, 102, 255}, {0, 102, 204}, {204, 51, 51}, {0, 153, 204}, {0, 51, 102}};

    protected Color color(int fc, int bc) {
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + num(bc - fc);
        int g = fc + num(bc - fc);
        int b = fc + num(bc - fc);
        return new Color(r, g, b);
    }
    protected Color color() {
        int[] color = COLOR[num(COLOR.length)];
        return new Color(color[0], color[1], color[2]);
    }
    public static char alpha() {
        return ALPHA[RANDOM.nextInt(ALPHA.length)];
    }
    public static int num(int num) {
        return RANDOM.nextInt(num);
    }
    public static char alpha(int num) {
        return ALPHA[num(num)];
    }
    public String text() {
        alphas();
        return chars;
    }
    protected void alphas() {
        char[] cs = new char[5];
        for (int i = 0; i < 5; i++) {
            cs[i] = alpha(numMaxIndex);
        }
        chars = new String(cs);
    }
    public boolean out(OutputStream out) {
        return graphicsImage(textChar(), out);
    }
    public char[] textChar() {
        return chars.toCharArray();
    }
    private Font font = null; // 验证码的字体
    private static final String[] FONT_NAMES = new String[]{"actionj.ttf", "epilog.ttf", "fresnel.ttf", "headache.ttf", "lexo.ttf", "prefix.ttf", "progbot.ttf", "ransom.ttf", "robot.ttf", "scandal.ttf"};

    public void setFont(int font, int style, float size) throws IOException, FontFormatException {
        this.font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/" + FONT_NAMES[font])).deriveFont(style, size);
    }
    public void setFont(int font, float size) throws IOException, FontFormatException {
        setFont(font, Font.BOLD, size);
    }
    public void setFont(int font) throws IOException, FontFormatException {
        setFont(1, 32f);
    }
    public void setFont(Font font) {
        this.font = font;
    }
    public Font getFont() {
        if (font == null) {
            try {
                setFont(0);
            } catch (Exception e) {
                setFont(new Font("Arial", Font.BOLD, 32));
            }
        }
        return font;
    }
    public void drawOval(int num, Graphics2D g) {
        drawOval(num, null, g);
    }
    public void drawOval(int num, Color color, Graphics2D g) {
        for (int i = 0; i < num; i++) {
            g.setColor(color == null ? color() : color);
            int w = 5 + num(10);
            g.drawOval(num(130 - 25), num(48 - 15), w, w);
        }
    }
    public void drawBesselLine(int num, Graphics2D g) {
        drawBesselLine(num, null, g);
    }
    public static int num(int min, int max) {
        return min + RANDOM.nextInt(max - min);
    }
    public void drawBesselLine(int num, Color color, Graphics2D g) {
        for (int i = 0; i < num; i++) {
            g.setColor(color == null ? color() : color);
            int x1 = 5, y1 = num(5, 48 / 2);
            int x2 = 130 - 5, y2 = num(48 / 2, 48 - 5);
            int ctrlx = num(130 / 4, 130 / 4 * 3), ctrly = num(5, 48 - 5);
            if (num(2) == 0) {
                int ty = y1;
                y1 = y2;
                y2 = ty;
            }
            if (num(2) == 0) {  // 二阶贝塞尔曲线
                QuadCurve2D shape = new QuadCurve2D.Double();
                shape.setCurve(x1, y1, ctrlx, ctrly, x2, y2);
                g.draw(shape);
            } else {  // 三阶贝塞尔曲线
                int ctrlx1 = num(130 / 4, 130 / 4 * 3), ctrly1 = num(5, 48 - 5);
                CubicCurve2D shape = new CubicCurve2D.Double(x1, y1, ctrlx, ctrly, ctrlx1, ctrly1, x2, y2);
                g.draw(shape);
            }
        }
    }

    private boolean graphicsImage(char[] strs, OutputStream out) {
        try {
            BufferedImage bi = new BufferedImage(130, 48, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = (Graphics2D) bi.getGraphics();
            // 填充背景
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, 130, 48);
            // 抗锯齿
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // 画干扰圆
            drawOval(2, g2d);
            // 画干扰线
            g2d.setStroke(new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
            drawBesselLine(1, g2d);
            // 画字符串
            g2d.setFont(getFont());
            FontMetrics fontMetrics = g2d.getFontMetrics();
            int fW = 130 / strs.length;  // 每一个字符所占的宽度
            int fSp = (fW - (int) fontMetrics.getStringBounds("W", g2d).getWidth()) / 2;  // 字符的左右边距
            for (int i = 0; i < strs.length; i++) {
                g2d.setColor(color());
                int fY = 48 - ((48 - (int) fontMetrics.getStringBounds(String.valueOf(strs[i]), g2d).getHeight()) >> 1);  // 文字的纵坐标
                g2d.drawString(String.valueOf(strs[i]), i * fW + fSp + 3, fY - 3);
            }
            g2d.dispose();
            ImageIO.write(bi, "png", out);
            out.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求头为输出图片类型
        resp.setContentType("image/gif");
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        // 三个参数分别为宽、高、位数
//        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        // 设置类型，纯数字、纯字母、字母数字混合
//        specCaptcha.setCharType(Captcha.TYPE_NUM_AND_UPPER);
//        System.out.println("验证码=" + specCaptcha.text());
        // 输出图片流
//        specCaptcha.out(resp.getOutputStream());
        HttpSession session = req.getSession();
        String a = text();
        System.out.println("验证码="+ a);
        session.setAttribute("VerifyCode",a);
        out(resp.getOutputStream());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
