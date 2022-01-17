package com.kardex.api.web.api.rest.security;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import com.kardex.api.commons.exeptions.*;

public interface ISecurityApiController {

    ResponseEntity<Object> login(MultiValueMap<String,String> paramMap, String grantType) throws ApiUnauthorized;
}
