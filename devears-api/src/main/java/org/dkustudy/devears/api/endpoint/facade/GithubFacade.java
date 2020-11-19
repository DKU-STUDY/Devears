package org.dkustudy.devears.api.endpoint.facade;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.config.security.JwtTokenProvider;
import org.dkustudy.devears.api.endpoint.service.GithubAuthService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class GithubFacade {
    private final GithubAuthService githubAuthService;
    private final JwtTokenProvider jwtTokenProvider;

    public String getLoginURL() {
        return githubAuthService.getLoginURL();
    }

    public void authorization(String code) {
        String accessToken = githubAuthService.getAccessToken(code);
        jwtTokenProvider.createToken(accessToken);
    }

    private static void addCookie(Cookie cookie) {
        getResponse().addCookie(cookie);
    }

    private static HttpServletResponse getResponse() {
        ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        return attr.getResponse();
    }
}
