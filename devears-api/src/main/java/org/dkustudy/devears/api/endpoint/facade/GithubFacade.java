package org.dkustudy.devears.api.endpoint.facade;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.endpoint.service.GithubAuthService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class GithubFacade {
    private static final int ACCESS_TOKEN_EXPIRATION = 60 * 60 * 24;
    private final GithubAuthService githubAuthService;

    public String getLoginURL() {
        return githubAuthService.getLoginURL();
    }

    public void authorization(String code) {
        Cookie cookie = new Cookie("accessToken", githubAuthService.getAccessToken(code));
        cookie.setMaxAge(ACCESS_TOKEN_EXPIRATION);
        cookie.setPath("/");
        addCookie(cookie);
    }

    private static void addCookie(Cookie cookie) {
        getResponse().addCookie(cookie);
    }

    private static HttpServletResponse getResponse() {
        ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        return attr.getResponse();
    }
}
