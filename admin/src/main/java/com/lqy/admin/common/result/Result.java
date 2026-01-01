package com.lqy.admin.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> Result<T> success(T data) {

        return new Result<T>(200, "success", data);
    }
    
    public static Result<?> success(){
        return new Result<>(200, "success", null);
    }
    
    public static  Result<?> fail(Integer code, String msg) {
        return new Result<>(code, msg, null);
    }

    
}
