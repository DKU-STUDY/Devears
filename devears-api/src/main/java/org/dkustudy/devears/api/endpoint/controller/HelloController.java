package org.dkustudy.devears.api.endpoint.controller;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.adapter.github.GithubAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final GithubAdapter githubAdapter;

    @GetMapping("/github")
    public Map getGithub() {
        return githubAdapter.getAuth();
    }
}
