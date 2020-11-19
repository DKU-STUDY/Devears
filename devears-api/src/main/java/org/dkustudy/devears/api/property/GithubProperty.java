package org.dkustudy.devears.api.property;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "github")
@Getter
@Setter
@NoArgsConstructor
public class GithubProperty {
    private String scope;
    private String clientId;
}
