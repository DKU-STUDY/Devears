package org.dkustudy.devears.api.endpoint.user.controller;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.endpoint.constant.Path;
import org.dkustudy.devears.api.endpoint.user.data.response.UserResponse;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final HttpSession httpSession;

    @GetMapping(Path.UserApi.USER)
    public UserResponse getUser() {
        return (UserResponse) httpSession.getAttribute("user");
    }

}
