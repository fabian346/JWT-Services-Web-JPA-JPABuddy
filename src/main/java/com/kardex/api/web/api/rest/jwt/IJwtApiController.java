package com.kardex.api.web.api.rest.jwt;

import org.springframework.http.ResponseEntity;

public interface IJwtApiController {

    ResponseEntity<Object> version();
}
