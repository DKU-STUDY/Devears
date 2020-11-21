package org.dkustudy.devears.api.endpoint.user.controller;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.adapter.github.response.GithubUserResponse;
import org.dkustudy.devears.api.domain.entities.User;
import org.dkustudy.devears.api.endpoint.constant.Path;
import org.dkustudy.devears.api.endpoint.user.data.response.UserResponse;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    @GetMapping(Path.UserApi.USER)
    public String getUser(@CookieValue String accessToken) {
        return accessToken;
    }
}
