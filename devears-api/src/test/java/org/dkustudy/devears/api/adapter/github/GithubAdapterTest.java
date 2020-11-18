package org.dkustudy.devears.api.adapter.github;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class GithubAdapterTest {

    @InjectMocks
    private GithubAdapter githubAdapter;

    @Test
    public void 인증_테스트() {
        assertThat(githubAdapter.getAuth()).isEqualTo("test");
    }

}
