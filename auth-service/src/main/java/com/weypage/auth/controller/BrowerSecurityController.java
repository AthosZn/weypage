package com.weypage.auth.controller;

import com.weypage.auth.properties.SecurityProperties;
import com.weypage.auth.support.SimpleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shiweinan
 */
@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
@RestController
@Slf4j
public class BrowerSecurityController {
    /**
     * 重定向 策略
     */
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    /**
     * 将当前请求缓存到session里去
     */
    private RequestCache requestCache = new HttpSessionRequestCache();
    /**
     * 注入 security 属性配置
     */
    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 当需要身份认证时 跳转到这里
     */
    @RequestMapping("/authentication/require")
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //拿到请求对象
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            //获取跳转url
            String targetUrl = savedRequest.getRedirectUrl();
            log.info("引发跳转的请求是:{}", targetUrl);

            // 判断 targetUrl 是不是.html 结尾,如果是: 跳转到登录页(返回view)
            if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
                String redirectUrl = securityProperties.getBrowser().getLoginPage();
                redirectStrategy.sendRedirect(request, response, redirectUrl);
            }
        }
        return new SimpleResponse("访问的服务需要身份认证,请引导登录页");
    }
}
