package org.dkustudy.devears.api.endpoint.facade;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.adapter.github.response.GithubUserResponse;
import org.dkustudy.devears.api.endpoint.response.GithubUser;
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

    public GithubUser authorization(String code) {
        String accessToken = githubAuthService.getAccessToken(code);
        Cookie cookie = new Cookie("accessToken", accessToken);
        cookie.setMaxAge(ACCESS_TOKEN_EXPIRATION);
        cookie.setPath("/");
        addCookie(cookie);

        return githubAuthService.getUser(accessToken);
    }

    private static void addCookie(Cookie cookie) {
        getResponse().addCookie(cookie);
    }

    private static HttpServletResponse getResponse() {
        ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        return attr.getResponse();
    }
}
