package com.kardex.api.web.api.rest.security.impl;


import com.kardex.api.configuration.security.AuthValidator;
import com.kardex.api.service.security.IAuthService;
import com.kardex.api.web.api.rest.security.ISecurityApiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import com.kardex.api.commons.exeptions.*;

@RestController
@RequestMapping(path = "v1.0")
public class SecurityApiController implements ISecurityApiController {

    @Autowired
    private IAuthService authService;

    @Autowired
    private AuthValidator authValidator;

    @Override
    @PostMapping(path = "oauth/client_credential/accesToken", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> login(@RequestBody MultiValueMap<String,String> paramMap, @RequestParam("grant_type") String grantType) throws ApiUnauthorized{

        authValidator.validate(paramMap, grantType);
        return ResponseEntity.ok(authService.login(paramMap.getFirst("client_id"), paramMap.getFirst("client_secret")));
    }


}
