package org.dkustudy.devears.api.config;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.domain.entities.User;
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
            .csrf().disable()
            .headers().frameOptions().disable()
            .and()
                .authorizeRequests()
                .antMatchers("/", "/h2-console")
                    .permitAll()
                .antMatchers("/api/user/**")
                    .hasRole(User.Role.USER.name())
                .anyRequest()
                    .permitAll()
            .and()
                .logout()
                    .logoutSuccessUrl("/")
            .and()
                .oauth2Login()
                    .userInfoEndpoint()
                        .userService(userOAuth2Service);
    }
}
