package org.dkustudy.devears.api.endpoint.user.data.response;

import lombok.Builder;
import lombok.Getter;
import org.dkustudy.devears.api.domain.entities.User;

@Getter
@Builder
public class UserResponse {
    private final long idx;
    private final String id;
    private final String email;
    private final String profileUrl;
    private final String name;
    private final String company;
    private final String blog;
    private final String description;
    private final long followers;
    private final long following;

    public static UserResponse of(User user) {
        return UserResponse.builder()
            .idx(user.getIdx())
            .id(user.getGithubId())
            .email(user.getEmail())
            .profileUrl(user.getProfileUrl())
            .name(user.getName())
            .company(user.getCompany())
            .blog(user.getBlog())
            .description(user.getDescription())
            .followers(user.getFollowers())
            .following(user.getFollowing())
            .build();
    }
}
