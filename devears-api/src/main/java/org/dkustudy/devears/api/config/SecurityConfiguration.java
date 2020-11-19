package org.dkustudy.devears.api.config;

import lombok.RequiredArgsConstructor;
import org.dkustudy.devears.api.config.security.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http
            .httpBasic()
                .disable() // spring-security에서 제공하는 /login 과 같은 페이지 비활성
            .csrf()
                .disable() // Cross site request forgery 비활성
            .formLogin()
                .disable()
            .authorizeRequests()
                .anyRequest()
                    .permitAll()
                    .and()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // session을 stateless 형태로 관리
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
