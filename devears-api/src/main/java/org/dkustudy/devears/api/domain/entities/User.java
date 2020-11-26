package org.dkustudy.devears.api.domain.entities;

import lombok.*;
import org.dkustudy.devears.api.adapter.github.response.GithubUserResponse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Map;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends AbstractEntity {

    @Column(unique = true, nullable = false)
    private String githubId;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String profileUrl;

    @Column
    private String name;

    @Column
    private String company;

    @Column
    private String blog;

    @Column
    private String description;

    @Column
    private long followers;

    @Column
    private long following;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public String getRoleKey() {
        return this.role.getKey();
    }

    public void updateBy(Map<String, Object> params) {
        githubId = (String) params.get("login");
        profileUrl = (String) params.get("avatar_url");
        name = (String) params.get("name");
        company = (String) params.get("company");
        blog = (String) params.get("blog");
        email = (String) params.get("email");
        description = (String) params.get("bio");
        followers = (Integer) params.get("followers");
        following = (Integer) params.get("following");
        role = Role.USER;
    }

    @Getter
    @AllArgsConstructor
    public enum Role {
        GUSET("ROLE_GUEST", "손님"),
        USER("ROLE_USER", "일반 사용자");

        private final String key;
        private final String title;
    }
}
