package org.dkustudy.devears.api.domain.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends AbstractEntity {

    @Column(unique = true)
    private String githubId;

    @Column(unique = true)
    private String accessToken;

    @Column
    private String profileUrl;

    @Column
    private String name;

    @Column
    private String company;

    @Column
    private String blog;

    @Column
    private String email;

    @Column
    private String description;

    @Column
    private long followers;

    @Column
    private long following;


}
