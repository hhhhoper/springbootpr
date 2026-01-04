package com.lqy.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean 
    PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();  
    } 

     @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 1. 关闭 CSRF
            .csrf(csrf -> csrf.disable())

            // 2. 放行所有请求
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            )

            // 3. 关闭默认表单登录
            .formLogin(form -> form.disable())

            // 4. 关闭 http basic（一起关干净）
            .httpBasic(basic -> basic.disable());

        return http.build();
    }
    
}