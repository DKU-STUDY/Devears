package org.dkustudy.devears.api.endpoint.user.service;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.domain.entities.User;
import org.dkustudy.devears.api.domain.repository.UserRepository;
import org.dkustudy.devears.api.endpoint.user.data.response.UserResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserOAuth2Service implements OAuth2UserService<OAuth2UserRequest, OAuth2User>, LogoutHandler {
    public static final String SESSION_KEY = "user";

    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = new DefaultOAuth2UserService().loadUser(userRequest);

        User user = saveByGithubUser(oAuth2User.getAttributes());
        httpSession.setAttribute(SESSION_KEY, UserResponse.of(user));

        return new DefaultOAuth2User(
            Collections.singleton(
                new SimpleGrantedAuthority(user.getRoleKey())
            ),
            oAuth2User.getAttributes(),
            userRequest.getClientRegistration()
                       .getProviderDetails()
                       .getUserInfoEndpoint()
                       .getUserNameAttributeName()
        );
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        System.out.println(getUserBySession());
        httpSession.removeAttribute(SESSION_KEY);
        System.out.println(getUserBySession());
    }

    public User saveByGithubUser(Map<String, Object> params) {
        User user = userRepository
            .findByEmailAndActivation((String) params.get("email"), true)
            .orElse(new User());
        user.updateBy(params);
        return userRepository.save(user);
    }

    public UserResponse getUserBySession() {
        return (UserResponse) httpSession.getAttribute(SESSION_KEY);
    }
}
