package com.mohan.config;

import com.mohan.interceptor.AuthorizationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor()).addPathPatterns("/**").addPathPatterns();
    }

    @Bean
    public AuthorizationInterceptor authorizationInterceptor(){
        return new AuthorizationInterceptor();
    }

   @Bean
    public CorsFilter getCorsFilter(){
         CorsConfiguration config=new CorsConfiguration();
         config.addAllowedOrigin("*");
         config.addAllowedMethod("*");
         config.addAllowedHeader("*");

       UrlBasedCorsConfigurationSource configurationSource=new UrlBasedCorsConfigurationSource();
       configurationSource.registerCorsConfiguration("/**",config);
       return new CorsFilter(configurationSource);
   }
}
