package com.weypage.auth.config.oauth;

import com.weypage.auth.authentication.AuthenticationFailHandler;
import com.weypage.auth.authentication.AuthenticationSuccessHandler;
import com.weypage.auth.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private AuthenticationFailHandler authenticationFailHandler;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String redirectUrl = securityProperties.getBrowser().getLoginPage();
        http.formLogin()
//                .loginPage("/authentication/require")
                // 登录需要经过的url请求
                .loginProcessingUrl("/authentication/.form")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailHandler)
                .and()
                //请求授权
                .authorizeRequests()
                //不需要权限认证的url
                .antMatchers("/authentication/require", redirectUrl)
                .permitAll()
                // 任何请求
                .anyRequest()
                .authenticated()
                .and()
                // 关闭跨站请求防护
                .csrf().disable();
    }
}
