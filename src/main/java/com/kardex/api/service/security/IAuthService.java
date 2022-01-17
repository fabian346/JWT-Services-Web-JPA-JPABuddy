package com.kardex.api.service.security;

import com.kardex.api.model.response.security.ResponseSecurityDTO;

public interface IAuthService {

    ResponseSecurityDTO login(String clientId, String clientSecret);
}
