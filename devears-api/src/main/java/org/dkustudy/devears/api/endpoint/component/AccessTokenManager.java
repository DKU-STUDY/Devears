package org.dkustudy.devears.api.endpoint.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Component
public class AccessTokenManager {
    public static final int EXPIRATION = 60 * 60 * 24;
    public static final String KEY = "accessToken";

    public void setToken(String token) {
        Cookie cookie = new Cookie(KEY, token);
        cookie.setMaxAge(EXPIRATION);
        cookie.setPath("/");
        addCookie(cookie);
    }

    public void removeToken() {
        Cookie cookie = new Cookie(KEY, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        addCookie(cookie);
    }

    private static void addCookie(Cookie cookie) {
        getResponse().addCookie(cookie);
    }

    private static HttpServletResponse getResponse() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getResponse();
    }

}
