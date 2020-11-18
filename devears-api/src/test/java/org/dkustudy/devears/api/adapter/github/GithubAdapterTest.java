package org.dkustudy.devears.api.adapter.github;

import org.dkustudy.devears.api.adapter.RestClientConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class GithubAdapterTest {

    @Mock
    private RestClientConfig restClientConfig;

    @Mock
    private RestTemplate githubClient;

    @InjectMocks
    private GithubAdapter githubAdapter;

    @Test
    public void 인증_테스트() {
        assertThat(githubAdapter.getAuth().get("current_user_url")).isEqualTo("https://api.github.com/user");
    }

}
