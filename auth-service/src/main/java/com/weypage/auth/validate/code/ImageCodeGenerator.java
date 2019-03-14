package com.weypage.auth.validate.code;

import com.weypage.auth.properties.SecurityProperties;
import com.weypage.auth.validate.ImageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ImageCodeGenerator implements ValidateCodeGenerator {

    /**
     * 引入security 属性属性类
     */
    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 创建验证码
     */
    @Override
    public ImageCode createCode(ServletWebRequest request) {
        //如果请求中有with 参数,则用请求参数中的with,否则使用配置属性中的
        int with = ServletRequestUtils.getIntParameter(request.getRequest(), "with",
                securityProperties.getCode().getImage().getWidth());
        int height = ServletRequestUtils.getIntParameter(request.getRequest(), "height",
                securityProperties.getCode().getImage().getHeight());
        //图片验证码字符个数
        int length = securityProperties.getCode().getImage().getLength();
        int expireIn = securityProperties.getCode().getImage().getExpireIn();

        BufferedImage image = new BufferedImage(with, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();

        Random random = new Random();

        g.setColor(getRanColor(200, 250));
        g.fillRect(0, 0, with, height);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        g.setColor(getRanColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(with);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }
        String sRand = "";
//        g.setColor(getRanColor(20 + random.nextInt(110), 20 + random.nextInt(110)));
//        g.drawString(rand);

        return null;
    }

    private Color getRanColor(int fc, int bc) {
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
