package com.kardex.api.web.api.rest.jwt.impl;

import com.kardex.api.web.api.rest.jwt.IJwtApiController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1.0")
public class JwtControllerImpl implements IJwtApiController {

    @Override
    @GetMapping(path = "version")
    public ResponseEntity<Object> version() {
        return ResponseEntity.ok("Version 1.0");
    }
}
