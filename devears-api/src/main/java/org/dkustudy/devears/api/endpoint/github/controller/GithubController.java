package org.dkustudy.devears.api.endpoint.github.controller;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.adapter.github.GithubAdapter;
import org.dkustudy.devears.api.adapter.github.request.GithubAccessTokenRequest;
import org.dkustudy.devears.api.adapter.github.response.GithubAccessTokenResponse;
import org.dkustudy.devears.api.endpoint.constant.ApiPath;
import org.dkustudy.devears.api.property.GithubProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class GithubController {

    private final GithubAdapter githubAdapter;
    private final GithubProperty githubProperty;

    @GetMapping(ApiPath.Github.LOGIN)
    public void getAuth(HttpServletResponse response) throws IOException {
        response.sendRedirect(
            UriComponentsBuilder
                .fromHttpUrl("https://github.com/login/oauth/authorize")
                .queryParam("scope", githubProperty.getScope())
                .queryParam("client_id", githubProperty.getClientId())
                .build()
                .toString()
        );
    }

    @GetMapping(ApiPath.Github.LOGIN_CALLBACK)
    public GithubAccessTokenResponse initAuth(@RequestParam String code) {
        return githubAdapter.getAccessToken(
            GithubAccessTokenRequest.builder()
                .code(code)
                .client_id(githubProperty.getClientId())
                .client_secret(githubProperty.getClientSecret())
                .build()
        );
    }

}
