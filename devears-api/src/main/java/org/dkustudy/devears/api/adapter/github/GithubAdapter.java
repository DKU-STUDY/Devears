package org.dkustudy.devears.api.adapter.github;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class GithubAdapter {

    private final RestTemplate githubClient;

    public String getAuth() {
        Map<String, String> map = githubClient.getForObject("/", Map.class);
        System.out.println(map);
        return "test";
    }

}
