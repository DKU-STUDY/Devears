package org.dkustudy.devears.api.adapter.github;

import org.dkustudy.devears.api.adapter.RestClientConfig;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GithubAdapterTest {

    private final GithubAdapter githubAdapter = new GithubAdapter(
        new RestClientConfig().githubClient()
    );

    @Test
    public void 인증_테스트() {
        assertThat(githubAdapter.getAuth().get("current_user_url"))
            .isEqualTo("https://api.github.com/user");
    }

}
