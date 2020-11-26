package org.dkustudy.devears.api.domain.entities;

import lombok.*;
import org.dkustudy.devears.api.adapter.github.response.GithubUserResponse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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

    public void updateBy(GithubUserResponse response) {
        githubId = response.getLogin();
        profileUrl = response.getAvatar_url();
        name = response.getName();
        company = response.getCompany();
        blog = response.getBlog();
        email = response.getEmail();
        description = response.getBio();
        followers = response.getFollowers();
        following = response.getFollowing();
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
