package org.dkustudy.devears.api.endpoint.facade;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.endpoint.component.AccessTokenManager;
import org.dkustudy.devears.api.endpoint.github.service.GithubAuthService;
import org.dkustudy.devears.api.endpoint.user.service.UserService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GithubFacade {
    private final GithubAuthService githubAuthService;
    private final UserService userService;
    private final AccessTokenManager accessTokenManager;

    public String getLoginURL() {
        return githubAuthService.getLoginURL();
    }

    public void authorization(String code) {
        String accessToken = githubAuthService.getAccessToken(code);
        accessTokenManager.createAuth(accessToken);
        userService.saveByGithubUser(githubAuthService.getUser(accessToken), accessToken);
    }
}
