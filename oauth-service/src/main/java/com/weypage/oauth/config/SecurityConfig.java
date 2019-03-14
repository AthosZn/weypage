package com.weypage.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // @formatter:off
    http
        .authorizeRequests()
          .antMatchers("/", "/home","/login","/oauth/authorize").permitAll()
          .anyRequest().authenticated()
          .and()
        .formLogin()
//          .loginPage("/login")
          .and()
        .httpBasic()
          .disable()
        .exceptionHandling()
         .accessDeniedPage("/login?authorization_error=true")
          .and()
        .csrf()
          .requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))
          .disable();
    // @formatter:on
  }


  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
  }

  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Bean
  @Override
  protected UserDetailsService userDetailsService(){
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    // 创建两个 qq 用户
    manager.createUser(User.withUsername("250577914").password(passwordEncoder.encode("123456")).authorities("USER").build());
    manager.createUser(User.withUsername("920129126").password(passwordEncoder.encode("123456")).authorities("USER").build());
    return manager;
  }


}
