package org.dkustudy.devears.api.endpoint.component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.property.JwtProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class AccessTokenManager {
    public static final int EXPIRATION = 60 * 60 * 24;
    public static final String KEY = "X-AUTH-TOKEN";

    private final JwtProperty jwtProperty;
    private String secretKey;

    @PostConstruct
    public void init() {
        secretKey = Base64.getEncoder()
                          .encodeToString(jwtProperty.getSecret().getBytes());
    }

    public String getJwtByAccessToken(String accessToken) {
        Claims claims = Jwts.claims().setSubject(accessToken); // claim 생성
        Date now = new Date();
        return Jwts.builder()
            .setClaims(claims) // claim 지정
            .setIssuedAt(now) // 토큰 발행 일자 지정
            .setExpiration(new Date(now.getTime() + EXPIRATION * 1000)) // 유효 시간 지정
            .signWith(SignatureAlgorithm.HS256, secretKey) // 암호화 알고리즘, secret 값 지정
            .compact(); // 위의 내용을 압축 후 반환
    }

    public String getAccessTokenByJwt(String jwt) {
        return getClaimsByJwt(jwt)
                   .getSubject();
    }

    public boolean validateJwt(String jwt) {
        try {
            return !getClaimsByJwt(jwt)
                    .getExpiration()
                    .before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    private Claims getClaimsByJwt(String jwt) {
        return Jwts.parser()
                   .setSigningKey(secretKey)
                   .parseClaimsJws(jwt)
                   .getBody();
    }

    private static void addCookie(Cookie cookie) {
        getResponse().addCookie(cookie);
    }

    private static HttpServletResponse getResponse() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getResponse();
    }

}
