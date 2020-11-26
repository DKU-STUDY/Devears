package org.dkustudy.devears.api.endpoint.facade;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.endpoint.user.data.response.UserResponse;
import org.dkustudy.devears.api.endpoint.user.service.UserOAuth2Service;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserOAuth2Service userOAuth2Service;

    public UserResponse getUser() {
        return userOAuth2Service.getUserBySession();
    }

}
