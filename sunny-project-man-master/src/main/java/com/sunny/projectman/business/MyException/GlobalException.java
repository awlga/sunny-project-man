package com.sunny.projectman.business.MyException;

import org.springframework.stereotype.Component;

@Component
public class GlobalException extends Exception {
    public GlobalException(){}
    public GlobalException(String msg){
        super(msg);
    }
}
