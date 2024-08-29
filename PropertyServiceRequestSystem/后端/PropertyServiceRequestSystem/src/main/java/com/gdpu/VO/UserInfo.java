package com.gdpu.VO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfo {

    private String openid;
    private String token;
    private String role;

}
