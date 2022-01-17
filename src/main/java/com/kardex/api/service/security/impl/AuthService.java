package com.kardex.api.service.security.impl;

import com.kardex.api.commons.util.DateUtils;
import com.kardex.api.configuration.security.JwtIO;
import com.kardex.api.model.response.security.ResponseSecurityDTO;
import com.kardex.api.service.security.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private final JwtIO jwtIO;

    @Autowired
    private final DateUtils dateUtils;

    @Value("${jms.jwt.token.expires-in}")
    private int EXPIRES_IN;

    public AuthService(JwtIO jwtIO, DateUtils dateUtils) {
        this.jwtIO = jwtIO;
        this.dateUtils = dateUtils;
    }

    @Override
    public ResponseSecurityDTO login(String clientId, String clientSecret) {

        ResponseSecurityDTO response = ResponseSecurityDTO.builder()
                .tokenType("bearer")
                .accessToken(jwtIO.generateToken("hola Mundo :V"))
                .issuedAt(dateUtils.getDateMillis() + "")
                .clientId(clientId)
                .expiresIn(EXPIRES_IN)
                .build();

        return response;
    }
}
