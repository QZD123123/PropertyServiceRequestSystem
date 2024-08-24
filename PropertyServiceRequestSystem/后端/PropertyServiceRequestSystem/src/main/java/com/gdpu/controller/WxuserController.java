package com.gdpu.controller;

import com.gdpu.DTO.WxLoginInfo;
import com.gdpu.service.WxuserService;
import com.gdpu.utils.JwtHelper;
import com.gdpu.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/wxuser")
public class WxuserController {

    @Autowired
    private WxuserService wxuserService;

    @Autowired
    private JwtHelper jwtHelper;

    @PostMapping("/login")
    public Result wxUserLogin(@RequestBody WxLoginInfo wxLoginInfo){
        log.info("微信用户登录code：{}" , wxLoginInfo.getCode());

        //微信登录
//        Wxuser wxuser = wxuserService.wxLogin(wxLoginInfo);
//        System.out.println("wxuser = " + wxuser);
//
//        //为微信用户生产jwt令牌
//        String token = jwtHelper.createToken(Long.valueOf(wxuser.getWxuserId()));
//
//        UserInfo userInfo = UserInfo.builder()
//                .id(Long.valueOf(wxuser.getWxuserId()))
//                .openid(wxuser.getWxuserOpenid())
//                .token(token)
//                .build();
//        return Result.ok(userInfo);


        Result result = wxuserService.wxLogin(wxLoginInfo);
        return result;
    }

}
