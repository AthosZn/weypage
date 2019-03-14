package com.weypage.auth.properties;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * browser(浏览器) 配置文件里的 com.weypage.oauth.browser.loginPage 属性类
 *
 * @author shiweinan
 */
@Slf4j
@Data
public class BrowserProperties {

    private String loginPage = "/login";

    private LoginType loginType = LoginType.JSON;


}
