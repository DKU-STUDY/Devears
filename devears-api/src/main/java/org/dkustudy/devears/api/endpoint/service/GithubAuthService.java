package org.dkustudy.devears.api.endpoint.service;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.adapter.github.GithubAdapter;
import org.dkustudy.devears.api.adapter.github.request.GithubAccessTokenRequest;
import org.dkustudy.devears.api.adapter.github.response.GithubAccessTokenResponse;
import org.dkustudy.devears.api.adapter.github.response.GithubUserResponse;
import org.dkustudy.devears.api.endpoint.response.GithubUser;
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

    public GithubUser getUser(String accessToken) {
        GithubUserResponse response = githubAdapter.getUser(accessToken);
        return GithubUser.builder()
                .avatarUrl(response.getAvatar_url())
                .bio(response.getBio())
                .blog(response.getBlog())
                .company(response.getCompany())
                .email(response.getEmail())
                .followers(response.getFollowers())
                .following(response.getFollowing())
                .login(response.getLogin())
                .name(response.getName())
                .build();
    }
}
