package com.bs.mycareer.jwt;

import com.auth0.jwt.algorithms.Algorithm;
import io.jsonwebtoken.Jwts;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;

@Component
@ConfigurationProperties(prefix = "app.security.jwt")
@Getter
@Setter
public class JWTProperties {
    private final String prefix = "Bearer ";
    private final String refreshTokenSubject = "REFRESH_TOKEN";
    private final String accessTokenSubject = "ACCESS_TOKEN";
    private final Key accessSecretKey;
    private final Key refreshSecretKey;


    public JWTProperties(@Value("${spring.jwt.accessSecret}") String accessSecret,
                         @Value("${spring.jwt.refreshSecret}") String refreshSecret) {

        this.accessSecretKey = new SecretKeySpec(accessSecret.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm());
        this.refreshSecretKey = new SecretKeySpec(refreshSecret.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm());
    }

    public Algorithm getAccessSign() {
        // 시크릿 키를 이용하여 Algorithm 생성
        return Algorithm.HMAC256(accessSecretKey.getEncoded());
    }

    public Algorithm getRefreshSign(){

        return Algorithm.HMAC256(refreshSecretKey.getEncoded());
    }



}