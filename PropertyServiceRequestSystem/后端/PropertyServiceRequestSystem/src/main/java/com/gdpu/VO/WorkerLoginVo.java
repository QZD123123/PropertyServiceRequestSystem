package com.gdpu.VO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkerLoginVo {
    private String id;
    private String openid;
    private String role;
    private String phone;
    private String name;
}
