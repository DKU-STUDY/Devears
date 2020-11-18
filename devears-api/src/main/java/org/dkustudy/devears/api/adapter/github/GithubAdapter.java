package org.dkustudy.devears.api.adapter.github;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class GithubAdapter {

    private final RestTemplate githubClient;

    public Map getAuth() {
        System.out.println(githubClient);
        return githubClient.getForObject("/", Map.class);
    }

}
