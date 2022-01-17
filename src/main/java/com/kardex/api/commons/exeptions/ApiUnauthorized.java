package com.kardex.api.commons.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ApiUnauthorized extends Exception{

    private static final long serialVersionUID = 1L;
    public ApiUnauthorized(String message){
        super(message);
    }
}
