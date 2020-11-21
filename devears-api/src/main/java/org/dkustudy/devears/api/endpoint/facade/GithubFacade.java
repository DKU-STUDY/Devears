package org.dkustudy.devears.api.endpoint.facade;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.adapter.github.response.GithubUserResponse;
import org.dkustudy.devears.api.domain.entities.User;
import org.dkustudy.devears.api.domain.repository.UserRepository;
import org.dkustudy.devears.api.endpoint.github.service.GithubAuthService;
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
    private final UserRepository userRepository;

    public String getLoginURL() {
        return githubAuthService.getLoginURL();
    }

    public void authorization(String code) {
        String accessToken = githubAuthService.getAccessToken(code);
        Cookie cookie = new Cookie("accessToken", accessToken);
        cookie.setMaxAge(ACCESS_TOKEN_EXPIRATION);
        cookie.setPath("/");
        addCookie(cookie);

        GithubUserResponse response =  githubAuthService.getUser(accessToken);
        User user = userRepository
            .findByGithubId(response.getLogin())
            .orElse(User.builder().build());
        user.setGithubId(response.getLogin());
        user.setProfileUrl(response.getAvatar_url());
        user.setName(response.getName());
        user.setCompany(response.getCompany());
        user.setBlog(response.getBlog());
        user.setEmail(response.getEmail());
        user.setDescription(response.getBio());
        user.setFollowers(response.getFollowers());
        user.setFollowing(response.getFollowing());
        userRepository.save(user);
    }

    private static void addCookie(Cookie cookie) {
        getResponse().addCookie(cookie);
    }

    private static HttpServletResponse getResponse() {
        ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
        return attr.getResponse();
    }
}
