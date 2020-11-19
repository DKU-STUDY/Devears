package org.dkustudy.devears.api.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.property.JWTProperty;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {
    private static final long TOKEN_EXPIRATION = 1000L * 60 * 60;

    private final JWTProperty jwtProperty;
    private String secretKey;


    /**
     * WAS가 띄워질 때 자동으로 실행
     * secretKey 초기화
     */
    @PostConstruct
    protected void init () {
        String secret = jwtProperty.getSecret();
        secretKey = Base64.getEncoder()
                          .encodeToString(secret.getBytes());
    }

    public String createToken(String accessToken) {
        Claims claims = Jwts.claims().setSubject(accessToken); // claim 생성
        Date now = new Date();
        Date expiration = new Date(now.getTime() + TOKEN_EXPIRATION);
        return Jwts.builder()
                   .setClaims(claims) // claim 지정
                   .setIssuedAt(now) // 토큰 발행 일자 지정
                   .setExpiration(expiration) // 유효 시간 지정
                   .signWith(SignatureAlgorithm.HS256, secretKey) // 암호화 알고리즘, secret 값 지정
                   .compact(); // 위의 내용을 압축 후 반환
    }

    private Claims getClaims(String jwt) {
        return Jwts.parser()
                   .setSigningKey(secretKey)
                   .parseClaimsJws(jwt)
                   .getBody();
    }

    public String getAccessToken(String jwt) {
        return getClaims(jwt).getSubject();
    }

    public String resolveToken(HttpServletRequest request) {
        return request.getHeader("X-AUTH-TOKEN");
    }

    public boolean validateToken(String jwt) {
        try {
            return !getClaims(jwt).getExpiration().before(new Date());
        } catch (RuntimeException e) {
            return false;
        }
    }
}
