package org.dkustudy.devears.api.adapter.github.response;

import lombok.*;

@Setter
@NoArgsConstructor
@ToString
public class GithubAccessTokenResponse {
    private String scope;
    private String access_token;
    private String token_type;

    public String getAccessToken() {
        return access_token;
    }
}
