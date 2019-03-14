//package com.weypage.auth.config.oauth;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
//
///**
// * @author shiweinan
// */
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.csrf().disable()
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
////                .and()
////                .requestMatchers().antMatchers("/**")
////                .and().authorizeRequests()
////                .antMatchers("/**").permitAll()
////                .anyRequest().authenticated()
////                .and().formLogin().permitAll()
////                .and().logout()
////                .logoutUrl("/logout")
////                .clearAuthentication(true)
////                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
//////                .addLogoutHandler(customLogoutHandler);
////    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .and()
//                .authorizeRequests()
//                .anyRequest();
//    }
//}
