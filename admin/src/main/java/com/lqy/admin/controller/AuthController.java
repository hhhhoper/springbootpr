package com.lqy.admin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lqy.admin.common.exception.BusinessException;
import com.lqy.admin.common.result.Result;
import com.lqy.admin.entity.SysUser;
import com.lqy.admin.service.SysUserService;
import com.lqy.admin.until.JwtUtil;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SysUserService systUserService;

    @PostMapping("/regist")
    public Result<?> regist(@RequestBody Map<String,String> registData) {
        //TODO: process POST request
        String username=registData.get("name");
        String password=registData.get("password"); 
        SysUser user=systUserService.registerUser(username, password);
        return Result.success(user);
    }
    

    @PostMapping("/login")
    public Result<?> login(@RequestBody Map<String,String> loginData) {
        //TODO: process POST request
        String username=loginData.get("name");
        String password=loginData.get("password");
        
        SysUser user=systUserService.getByUsername(username);
        if(user==null){

            throw new BusinessException(400,"用户不存在");

        }
        
        //验证密码简单明文后面加密
        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new BusinessException(400,"密码错误");
        }
        String token=JwtUtil.generateToken(username);
        Map<String,String> data=new HashMap<>();
        data.put("token", token);
        return Result.success(data);
    
    
    }
    


    
}