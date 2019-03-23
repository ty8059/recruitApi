package com.admn.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.geom.QuadCurve2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author wangyi
 */
public class CaptchaUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CaptchaUtil.class);
    public static final String CAPTCHA_NAME = "captcha";
    /**
     * 默认的验证码大小
     */
    private static final int WIDTH = 130, HEIGHT = 50;
    /**
     * 验证码随机字符数组
     */
    private static final String[] STR_ARR = {"3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y"};

    /**
     * 验证码随机字符数组
     */
    private static final String[] NUM_STR_ARR = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    /**
     * 验证码字体
      */
    private static final Font[] RANDOM_FONT = new Font[] {
            new Font("nyala", Font.BOLD, 45),
            new Font("Arial", Font.BOLD, 38),
            new Font("Bell MT", Font.BOLD, 38),
            new Font("Credit valley", Font.BOLD, 40),
            new Font("Impact", Font.BOLD, 38),
            new Font(Font.MONOSPACED, Font.BOLD, 48)
    };

    public static void render(HttpServletRequest request, HttpServletResponse response) {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        String vCode = drawGraphic(image);
        // 转成大写重要
        vCode = vCode.toUpperCase();
        String vCodeSession = vCode;
        // 图片转base64
        byte[] bytes = vCode.getBytes();
        Base64 base64 = new Base64();
        bytes = base64.encode(bytes);
        vCode = new String(bytes);
        // 验证码存入session
        HttpSession session = request.getSession();
        session.setAttribute(CAPTCHA_NAME, vCodeSession);
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        ServletOutputStream sos = null;
        try {
            sos = response.getOutputStream();
            ImageIO.write(image, "jpeg", sos);
        } catch (Exception e) {
            LOGGER.error(">>captchaUtil, 绘制验证码图片出错", e.getMessage());
        } finally {
            if (sos != null) {
                try {
                    sos.close();
                } catch (IOException e) {
                    LOGGER.error(">>captchaUtil, 连接未正常关闭", e.getMessage());
                }
            }
        }
    }

    /**
     * 仅能验证一次，验证后立即销毁
     * @param session 会话
     * @param userInputCaptcha 用户输入的验证码
     * @return 验证通过返回 true, 否则返回 false
     */
    public static boolean validate(HttpSession session, String userInputCaptcha) {
        boolean result;
        try {
            if (StringUtils.isBlank(userInputCaptcha)) {
                return false;
            }
            // 转成大写重要
            userInputCaptcha = userInputCaptcha.toUpperCase();
            result = userInputCaptcha.equals(session.getAttribute(CAPTCHA_NAME));
            if (result) {
                session.removeAttribute(CAPTCHA_NAME);
            }
        } catch (Exception e) {
            return false;
        }
        return result;
    }

    /**
     * 取随机产生的认证码(6位数字)
     */
    public static String getValidateCode() {
        Random random = new Random();
        StringBuilder sRand = new StringBuilder();
        for (int i = 0; i < 6; i++){
            String rand = NUM_STR_ARR[random.nextInt(NUM_STR_ARR.length)];
            sRand.append(rand);
        }
        return sRand.toString();
    }

    /**
     * 绘制图片
     * @param  image image
     * @return string 验证码
     */
    private static String drawGraphic(BufferedImage image){
        // 获取图形上下文
        Graphics2D g = image.createGraphics();

        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        // 图形抗锯齿
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // 字体抗锯齿
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // 设定背景色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        //生成随机类
        Random random = new Random();
        //设定字体
        g.setFont(RANDOM_FONT[random.nextInt(RANDOM_FONT.length)]);

        // 画蛋蛋，有蛋的生活才精彩
        Color color;
        for(int i = 0; i < 10; i++){
            color = getRandColor(120, 200);
            g.setColor(color);
            g.drawOval(random.nextInt(WIDTH), random.nextInt(HEIGHT), 5 + random.nextInt(10), 5 + random.nextInt(10));
            color = null;
        }

        // 取随机产生的认证码(4位数字)
        StringBuilder sRand = new StringBuilder();
        for (int i = 0; i < 4; i++){
            String rand = String.valueOf(STR_ARR[random.nextInt(STR_ARR.length)]);
            sRand.append(rand);
            //旋转度数 最好小于45度
            int degree = random.nextInt(28);
            if (i % 2 == 0) {
                degree = degree * (-1);
            }
            //定义坐标
            int x = 26 * i, y = 25;
            //旋转区域
            g.rotate(Math.toRadians(degree), x, y);
            //设定字体颜色
            color = getRandColor(20, 130);
            g.setColor(color);
            //将认证码显示到图象中
            g.drawString(rand, x + 8, y + 10);
            //旋转之后，必须旋转回来
            g.rotate(-Math.toRadians(degree), x, y);
            color = null;
        }
        //图片中间线
        g.setColor(getRandColor(0, 60));
        //width是线宽,float型
        BasicStroke bs = new BasicStroke(3);
        g.setStroke(bs);
        //画出曲线
        QuadCurve2D.Double curve = new QuadCurve2D.Double(0d, random.nextInt(HEIGHT - 8) + 4, WIDTH / 2, HEIGHT / 2, WIDTH, random.nextInt(HEIGHT - 8) + 4);
        g.draw(curve);
        // 销毁图像
        g.dispose();
        return sRand.toString();
    }

    /**
     * 给定范围获得随机颜色
     * @param fc fc
     * @param bc bc
     * @return Color
     */
    private static Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
