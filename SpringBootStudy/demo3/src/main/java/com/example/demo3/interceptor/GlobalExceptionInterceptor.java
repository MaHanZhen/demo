package com.example.demo3.interceptor;

import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice //定义全局处理器
@ResponseBody
public class GlobalExceptionInterceptor {

    @ExceptionHandler(value = Exception.class)  //定义异常处理器
    public String exceptionHandler(HttpServletRequest request,Exception e) {
        String failMessage = null;

        //判断是否为绑定异常
        if(e instanceof BindException){
            BindException ex = (BindException)e;
             failMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        }
        return failMessage;
    }
}
