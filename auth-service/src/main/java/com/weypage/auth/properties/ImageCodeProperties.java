package com.weypage.auth.properties;

import lombok.Data;

@Data
public class ImageCodeProperties {

    private int width = 67;

    private int height = 23;

    private int length = 4;

    private int expireIn = 60;
    /**
     * 需要图形验证码的url
     */
    private String url;
}
