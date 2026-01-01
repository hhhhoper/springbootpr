package com.lqy.admin.common.result;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(200,"SUCCESS"),
    UNAUTHORIZED(401,"UNAUTHORIZED"),
    FORBIDDEND(403,"FORBIDDEN"),
    ERROR(500,"ERROR"); 
    private Integer code;
    private String msg;
    ResultCode(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
    
}
