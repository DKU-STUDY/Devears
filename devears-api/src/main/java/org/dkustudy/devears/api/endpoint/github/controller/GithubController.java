package org.dkustudy.devears.api.endpoint.github.controller;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.adapter.github.GithubAdapter;
import org.dkustudy.devears.api.endpoint.constant.ApiPath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiPath.Github.ROOT)
public class GithubController {

    private final GithubAdapter githubAdapter;

    @GetMapping(ApiPath.Github.AUTH)
    public String getAuth() {
        return "auth";
    }

    @GetMapping(ApiPath.Github.AUTH_CALLBACK)
    public String initAuth() {
        return "callback";
    }

}
