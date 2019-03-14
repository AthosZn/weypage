package com.weypage.auth.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * security 属性类
 *
 * @author shiweinan
 */
@ConfigurationProperties(prefix = "com.weypage.auth")
@Data
@Component
public class SecurityProperties {
    /**
     * 浏览器属性类
     */
    private BrowserProperties browser = new BrowserProperties();
    /**
     * 验证码属性类
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();

}
