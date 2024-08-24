package com.gdpu.VO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfo {
//    private String openId; // 用户唯一标识
//    private String nickname; // 用户昵称
//    private String avatarUrl; // 用户头像

    private Long id;
    private String openid;
    private String token;

}
