package org.dkustudy.devears.api.config.auth;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.endpoint.user.service.UserOAuth2Service;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter {

    private final UserOAuth2Service userOAuth2Service;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
                .disable()
            .headers()
                .frameOptions()
                    .disable()
            .and()
                .authorizeRequests()
                .anyRequest()
                    .permitAll()
            .and()
                .logout()
                    .clearAuthentication(true)
                    .logoutSuccessUrl("/")
                        .permitAll()
            .and()
                .oauth2Login()
                    .userInfoEndpoint()
                        .userService(userOAuth2Service);
    }
}
