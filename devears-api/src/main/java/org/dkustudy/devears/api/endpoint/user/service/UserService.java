package org.dkustudy.devears.api.endpoint.user.service;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.adapter.github.response.GithubUserResponse;
import org.dkustudy.devears.api.domain.entities.User;
import org.dkustudy.devears.api.domain.repository.UserRepository;
import org.dkustudy.devears.api.endpoint.user.data.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void saveByGithubUser(GithubUserResponse response, String accessToken) {
        User user = userRepository
            .findByGithubIdAndActivation(response.getLogin(), true)
            .orElse(new User());
        user.updateBy(response);
        userRepository.save(user);
    }

    public UserResponse getUserByToken(String token) {
        User user = userRepository.findByAccessToken(token);
        if (user == null) return null;
        return UserResponse.of(user);
    }

}
