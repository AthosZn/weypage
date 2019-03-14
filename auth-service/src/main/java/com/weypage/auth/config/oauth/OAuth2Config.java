//package com.weypage.auth.config.oauth;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;
//import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
//import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
//
//@Configuration
//@EnableAuthorizationServer
//public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
//
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        super.configure(endpoints);
//    }
//
//    @Bean
//    public TokenStore tokenStore() {
//        return new InMemoryTokenStore();
//    }
//
//    @Bean
//    public AuthorizationServerTokenServices authorizationServerTokenServices() {
//        DefaultTokenServices tokenServices = new DefaultTokenServices();
//        tokenServices.setClientDetailsService(clientDetailsService());
////        CustomAuthorizationTokenServices customTokenServices = new CustomAuthorizationTokenServices();
////        customTokenServices.setTokenStore(tokenStore(redisConnectionFactory));
////        customTokenServices.setSupportRefreshToken(true);
////        customTokenServices.setReuseRefreshToken(false);
////        customTokenServices.setClientDetailsService(clientDetailsService(dataSource));
////        customTokenServices.setTokenEnhancer(accessTokenConverter());
//        return tokenServices;
//    }
//
//    @Bean
//    public InMemoryClientDetailsService clientDetailsService() {
//        InMemoryClientDetailsService inMemoryClientDetailsService = new InMemoryClientDetailsService();
//        return inMemoryClientDetailsService;
//    }
//
//}
