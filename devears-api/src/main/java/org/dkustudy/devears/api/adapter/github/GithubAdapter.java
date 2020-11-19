package org.dkustudy.devears.api.adapter.github;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.adapter.github.path.GithubApiPath;
import org.dkustudy.devears.api.adapter.github.request.GithubAccessTokenRequest;
import org.dkustudy.devears.api.adapter.github.response.GithubAccessTokenResponse;
import org.dkustudy.devears.api.property.GithubProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class GithubAdapter {

    private final RestTemplate githubClient;
    private final RestTemplate githubApiClient;

    public GithubAccessTokenResponse getAccessToken(GithubAccessTokenRequest request) {

        return githubClient
            .postForObject(
                GithubApiPath.OAUTH_PATH,
                request,
                GithubAccessTokenResponse.class
            );
    }

}
