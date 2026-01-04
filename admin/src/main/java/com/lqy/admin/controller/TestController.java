package com.lqy.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lqy.admin.common.exception.BusinessException;
import com.lqy.admin.common.result.Result;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/ok")
    public Result<String> ok() {
        return Result.success("hello admin");
    }

    @GetMapping("/error")
    public Result<?> error() {
        throw new BusinessException(400, "测试异常");
    }

    @GetMapping("/info")
    public Result<String> info() {
        return Result.success("需要登录后访问的资源");
    }
    
}

