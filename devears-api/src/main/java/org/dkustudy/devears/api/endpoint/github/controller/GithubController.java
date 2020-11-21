package org.dkustudy.devears.api.endpoint.github.controller;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.adapter.github.response.GithubUserResponse;
import org.dkustudy.devears.api.endpoint.constant.ApiPath;
import org.dkustudy.devears.api.endpoint.facade.GithubFacade;
import org.dkustudy.devears.api.endpoint.response.GithubUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class GithubController {

    private final GithubFacade githubFacade;

    @GetMapping(ApiPath.Github.LOGIN)
    public void login(HttpServletResponse response) throws IOException {
        response.sendRedirect(githubFacade.getLoginURL());
    }

    @GetMapping(ApiPath.Github.LOGIN_CALLBACK)
    public GithubUser initAuth(@RequestParam String code, HttpServletResponse response) {
        return githubFacade.authorization(code);
    }

}
