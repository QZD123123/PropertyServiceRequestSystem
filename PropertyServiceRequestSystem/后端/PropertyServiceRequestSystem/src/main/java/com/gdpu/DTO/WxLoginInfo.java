package com.gdpu.DTO;

import com.gdpu.VO.UserInfo;
import lombok.Data;

@Data
public class WxLoginInfo {

    private String code; // 微信登录凭证
    private UserInfo userInfo; // 用户信息
    private String name; // 学生或者维修工人姓名
    private String phone; // 学生学号或者维修工人电话
}
