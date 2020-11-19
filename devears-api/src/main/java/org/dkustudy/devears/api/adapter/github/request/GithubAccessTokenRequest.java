package org.dkustudy.devears.api.adapter.github.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GithubAccessTokenRequest {
    private final String client_id;
    private final String client_secret;
    private final String code;
}
