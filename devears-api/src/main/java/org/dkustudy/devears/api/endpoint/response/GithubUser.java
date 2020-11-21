package org.dkustudy.devears.api.endpoint.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GithubUser {
    private final String login; //: "JunilHwang",
    private final String avatarUrl; //: "https://avatars3.githubusercontent.com/u/18749057?v=4",
    private final String name; //: "JunilHwang",
    private final String company; //: "DKU-STUDY",
    private final String blog; //: "https://junilhwang.github.io/TIL/",
    private final String email; //: "junil.h@kakao.com",
    private final String bio; //: "FullStack Developer /\r\n@zuminternet /\r\n@DKU-STUDY /\r\n@next-step reviwer",
    private final long followers; //: 135,
    private final long following; //: 183,
}
