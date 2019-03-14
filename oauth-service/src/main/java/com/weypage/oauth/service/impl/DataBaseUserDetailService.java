//package com.weypage.oauth.service.impl;
//
//import java.util.HashSet;
//import java.util.Set;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@Primary
//public class DataBaseUserDetailService implements UserDetailsService {
//
//  @Autowired
//  private PasswordEncoder passwordEncoder;
//
//  @Override
//  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    SimpleGrantedAuthority roleAdmin = new SimpleGrantedAuthority("ROLE_admin");
//    Set<SimpleGrantedAuthority> roles = new HashSet<>();
//    roles.add(roleAdmin);
//    return new User("admin", passwordEncoder.encode("123456"), roles);
//  }
//}
