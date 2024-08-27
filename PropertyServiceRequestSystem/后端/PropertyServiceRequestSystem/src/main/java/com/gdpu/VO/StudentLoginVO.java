package com.gdpu.VO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentLoginVO {

    private String tip;
    private String id;
    private String openid;
    private String studentId;
    private String role;
    private String phone;
    private String name;


}
