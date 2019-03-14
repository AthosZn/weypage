package com.weypage.auth.validate;

import com.weypage.auth.authentication.AuthenticationFailHandler;
import com.weypage.auth.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {

    /**
     * 登录失败处理器
     */
    @Autowired
    private AuthenticationFailHandler failHandler;

    @Autowired
    private SecurityProperties securityProperties;
    /**
     * 创建一个set 集合,存放需要验证码的url
     */
    private Set<String> urls = new HashSet<>();

    /**
     * spring 的一个工具类,用来判断两个字符串是否匹配
     */
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    /**
     * 初始化完成后运行此方法
     *
     * @throws ServletException
     */
    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
//        securityProperties.ge
        new Httpsessionsess
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        boolean action = false;

        for (String url : urls) {
            if (pathMatcher.match(url, request.getRequestURI())) {
                action = true;
                break;
            }
        }

        if (action) {
            log.info("拦截成功:{}", request.getRequestURI());
            //如果是登录请求

        }

    }

    private void validate(ServletWebRequest request) throws ServletRequestBindingException {
        // 从session获取验证码
        HttpSession session = request.getRequest().getSession();
        session.getAttribute(ValidateCodeController.SESSION_KEY)
        String imageCode = ServletRequestUtils.getStringParameter(request.getRequest(), "imageCode");

        if (StringUtils.isBlank(imageCode)) {
            log.info("验证码不能为空");
            throw new ValidateCodeException("验证码不能为空");
        }
        if(){

        }
    }


}
