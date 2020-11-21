package org.dkustudy.devears.api.endpoint.user.controller;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.endpoint.component.AccessTokenManager;
import org.dkustudy.devears.api.endpoint.constant.Path;
import org.dkustudy.devears.api.endpoint.facade.UserFacade;
import org.dkustudy.devears.api.endpoint.user.data.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @GetMapping(Path.UserApi.USER)
    public UserResponse getUser(
        @CookieValue(name = AccessTokenManager.KEY, defaultValue = "") String jwt
    ) {
        return userFacade.getUserByToken(jwt);
    }

    @GetMapping(Path.UserApi.LOGOUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean logout() {
        userFacade.logout();
        return true;
    }

}
