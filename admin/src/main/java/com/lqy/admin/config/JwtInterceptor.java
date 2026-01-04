package com.lqy.admin.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.lqy.admin.common.exception.BusinessException;
import com.lqy.admin.until.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // TODO Auto-generated method stub
        String token=request.getHeader("Authorization");
        //验证token
        if(token==null || token.isEmpty()) {
            throw new BusinessException(401,"未登录");
    }
    try{
        JwtUtil.getUsernameFromToken(token);
    }catch(Exception e){
        throw new BusinessException(401,"无效或过期");
    }
        return true;
    }
}
