package com.kardex.api.configuration.security;

import com.kardex.api.commons.util.GsonUtils;
import io.fusionauth.jwt.Signer;
import io.fusionauth.jwt.Verifier;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.hmac.HMACSigner;
import io.fusionauth.jwt.hmac.HMACVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.TimeZone;

@Component
public class JwtIO {

    @Value("${jms.jwt.token.secret}")
    private String SECRET;

    @Value("${jms.jwt.time-zone}")
    private String TIMEZONE;

    @Value("${jms.jwt.token.expires-in}")
    private int EXPIRES_IN;

    @Value("${jms.jwt.issuer}")
    private String ISSUER;

    public String generateToken(Object src){

        String subject = GsonUtils.serialize(src);

        // Construir un HMAC signer usando SHA-256

        Signer signer = HMACSigner.newSHA256Signer(SECRET);

        TimeZone timeZone = TimeZone.getTimeZone(TIMEZONE);

        ZonedDateTime zdt = ZonedDateTime.now(timeZone.toZoneId()).plusSeconds(EXPIRES_IN);

        JWT jwt = new JWT()
                .setIssuer(ISSUER)
                .setIssuedAt(ZonedDateTime.now(timeZone.toZoneId()))
                .setSubject(subject)
                .setExpiration(zdt);

        return JWT.getEncoder().encode(jwt, signer);
    }

    public boolean validateToken(String encodedJWT){

        JWT jwt = jwt(encodedJWT);

        return jwt.isExpired();
    }

    public String getPayload(String encodedJWT){

        JWT jwt = jwt(encodedJWT);

        return jwt.subject;
    }

    private JWT jwt(String encodedJWT){
        Verifier verifier = HMACVerifier.newVerifier(SECRET);

        return JWT.getDecoder().decode(encodedJWT, verifier);
    }
}
