package org.dkustudy.devears.api;

import org.dkustudy.devears.api.property.GithubProperty;
import org.dkustudy.devears.api.property.JWTProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableConfigurationProperties({ GithubProperty.class, JWTProperty.class })
@EnableJpaAuditing
@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
