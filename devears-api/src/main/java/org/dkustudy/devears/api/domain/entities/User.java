package org.dkustudy.devears.api.domain.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User extends AbstractEntity {

    @Column(unique = true)
    private String githubId; //: "JunilHwang",

    @Column
    private String profileUrl; //: "https://avatars3.githubusercontent.com/u/18749057?v=4",

    @Column
    private String name; //: "JunilHwang",

    @Column
    private String company; //: "DKU-STUDY",

    @Column
    private String blog; //: "https://junilhwang.github.io/TIL/",

    @Column
    private String email; //: "junil.h@kakao.com",

    @Column
    private String description; //: "FullStack Developer /\r\n@zuminternet /\r\n@DKU-STUDY /\r\n@next-step reviwer",

    @Column
    private long followers; //: 135,

    @Column
    private long following; //: 183,


}
