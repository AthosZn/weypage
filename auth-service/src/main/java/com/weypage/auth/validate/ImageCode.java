package com.weypage.auth.validate;

import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

@Data
public class ImageCode {

    private BufferedImage image;

    private String code;

    private LocalDateTime expireTime;

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }

    public ImageCode(BufferedImage image, String code, int exprireIn) {
        this.image = image;
        this.code = code;
        //当前时间 + 设置过期时间
        this.expireTime = LocalDateTime.now().plusSeconds(exprireIn);
    }

    public boolean isExpried() {
        //如果 过期时间 在当前时间之前 ,则验证码过期
        return LocalDateTime.now().isAfter(expireTime);
    }
}
