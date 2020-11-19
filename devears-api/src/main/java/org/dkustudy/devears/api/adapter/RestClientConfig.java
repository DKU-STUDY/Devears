package org.dkustudy.devears.api.adapter;

import org.apache.http.impl.client.HttpClientBuilder;
import org.dkustudy.devears.api.adapter.github.GithubPath;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;;

@Configuration
public class RestClientConfig {
    public static final int READ_TIMEOUT = 5000;
    public static final int CONNECT_TIMEOUT = 3000;
    public static final int MAX_CONNECT = 100;
    public static final int MAX_CONNECT_PER_ROUTE = 100;

    @Bean("githubClient")
    public RestTemplate githubClient() {
        RestTemplate restTemplate = new RestTemplate(httpComponentsClientHttpRequestFactory());
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(GithubPath.DOMAIN_URL));
        return restTemplate;
    }

    private HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory () {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(READ_TIMEOUT);
        factory.setConnectTimeout(CONNECT_TIMEOUT);
        factory.setHttpClient(
            HttpClientBuilder.create()
                .setMaxConnTotal(MAX_CONNECT)
                .setMaxConnPerRoute(MAX_CONNECT_PER_ROUTE)
                .build()
        );
        return factory;
    }

}
