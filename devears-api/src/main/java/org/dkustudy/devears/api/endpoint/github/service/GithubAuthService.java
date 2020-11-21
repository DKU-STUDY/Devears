package org.dkustudy.devears.api.endpoint.github.service;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.adapter.github.GithubAdapter;
import org.dkustudy.devears.api.adapter.github.request.GithubAccessTokenRequest;
import org.dkustudy.devears.api.adapter.github.response.GithubAccessTokenResponse;
import org.dkustudy.devears.api.adapter.github.response.GithubUserResponse;
import org.dkustudy.devears.api.property.GithubProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class GithubAuthService {
    private final GithubAdapter githubAdapter;
    private final GithubProperty githubProperty;

    public String getLoginURL() {
        return UriComponentsBuilder
                .fromHttpUrl("https://github.com/login/oauth/authorize")
                .queryParam("scope", githubProperty.getScope())
                .queryParam("client_id", githubProperty.getClientId())
                .build()
                .toString();
    }

    public String getAccessToken(String code) {
        return githubAdapter
                .getAccessToken(
                    GithubAccessTokenRequest.builder()
                        .code(code)
                        .client_id(githubProperty.getClientId())
                        .client_secret(githubProperty.getClientSecret())
                        .build())
                .getAccessToken();
    }

    public GithubUserResponse getUser(String accessToken) {
        return githubAdapter.getUser(accessToken);
    }
}
