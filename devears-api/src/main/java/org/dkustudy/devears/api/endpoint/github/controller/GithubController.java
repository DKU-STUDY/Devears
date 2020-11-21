package org.dkustudy.devears.api.endpoint.github.controller;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.endpoint.constant.Path;
import org.dkustudy.devears.api.endpoint.facade.GithubFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class GithubController {

    private final GithubFacade githubFacade;

    @GetMapping(Path.Github.LOGIN)
    public void login(HttpServletResponse response) throws IOException {
        response.sendRedirect(githubFacade.getLoginURL());
    }

    @GetMapping(Path.Github.LOGIN_CALLBACK)
    public void initAuth(@RequestParam String code, HttpServletResponse response) throws IOException {
        githubFacade.authorization(code);
        response.sendRedirect("/");
    }

}
