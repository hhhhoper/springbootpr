package com.lqy.admin.controller;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassWordTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // 原密码
        String rawPassword = "123456";

        // 数据库里存的加密密码
        String encodedPassword = "$2a$10$9Ib5cckrtSL5Bya0K.jk5ukhumS.ewQS8RvLtfJeBj7wAQrCBNsRRe";

        // matches 返回 true/false
        boolean result = passwordEncoder.matches(rawPassword, encodedPassword);
        System.out.println(result);
    }
}
