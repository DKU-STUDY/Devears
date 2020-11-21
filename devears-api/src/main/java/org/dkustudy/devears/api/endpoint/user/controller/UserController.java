package org.dkustudy.devears.api.endpoint.user.controller;

import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.dkustudy.devears.api.endpoint.component.AccessTokenManager;
import org.dkustudy.devears.api.endpoint.constant.Path;
import org.dkustudy.devears.api.endpoint.facade.UserFacade;
import org.dkustudy.devears.api.endpoint.user.data.response.UserResponse;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @GetMapping(Path.UserApi.USER)
    public UserResponse getUser(
        @CookieValue(name = AccessTokenManager.KEY, defaultValue = "") String accessToken
    ) {
        return userFacade.getUserByToken(accessToken);
    }

    @GetMapping(Path.UserApi.LOGOUT)
    public void logout(HttpServletResponse response) {
        userFacade.logout();
        response.setStatus(HttpStatus.SC_NO_CONTENT);
    }
}
