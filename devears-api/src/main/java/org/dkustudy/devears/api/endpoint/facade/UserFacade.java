package org.dkustudy.devears.api.endpoint.facade;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.endpoint.user.data.response.UserResponse;
import org.dkustudy.devears.api.endpoint.user.service.UserService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;

    public UserResponse getUserByToken(String token) {
        return userService.getUserByToken(token);
    }
}
