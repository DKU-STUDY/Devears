package org.dkustudy.devears.api.adapter.github.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GithubAccessTokenResponse {
    private String access_token;
    private String scope;
    private String token_type;
}
