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
        user.setAccessToken(accessToken);
        user.setGithubId(response.getLogin());
        user.setProfileUrl(response.getAvatar_url());
        user.setName(response.getName());
        user.setCompany(response.getCompany());
        user.setBlog(response.getBlog());
        user.setEmail(response.getEmail());
        user.setDescription(response.getBio());
        user.setFollowers(response.getFollowers());
        user.setFollowing(response.getFollowing());
        userRepository.save(user);
    }

    public UserResponse getUserByToken(String token) {
        return UserResponse.of(userRepository.findByAccessToken(token));
    }

}
