package com.gdpu.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdpu.VO.UserInfo;
import com.gdpu.DTO.WxLoginInfo;
import com.gdpu.pojo.Wxuser;
import com.gdpu.service.WxuserService;
import com.gdpu.mapper.WxuserMapper;
import com.gdpu.utils.HttpClientUtil;
import com.gdpu.utils.JwtHelper;
import com.gdpu.utils.Result;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
* @author ASUS
* @description 针对表【wxuser】的数据库操作Service实现
* @createDate 2024-08-21 17:22:30
*/
@Service
@Data
@ConfigurationProperties(prefix = "xcx.wechat")
public class WxuserServiceImpl extends ServiceImpl<WxuserMapper, Wxuser>
    implements WxuserService{

    private String appid;
    private String secret;

    //微信服务接口地址
    public static final String WX_LOGIN = "https://api.weixin.qq.com/sns/jscode2session";

    @Autowired
    private WxuserMapper wxuserMapper;

    @Autowired
    private JwtHelper jwtHelper;

    @Override
    public Result wxLogin(WxLoginInfo wxLoginInfo) {
        //调用微信接口服务，获得当前微信用户的openid
        Map<String,String> map = new HashMap<>();
        map.put("appid",appid);
        map.put("secret",secret);
        map.put("js_code",wxLoginInfo.getCode());
        map.put("grant_type","authorization_code");
        String json = HttpClientUtil.doGet(WX_LOGIN,map);

        JSONObject jsonObject = JSON.parseObject(json);
        String openid = jsonObject.getString("openid");
        String sessionKey = jsonObject.getString("session_key");
        System.out.println("jsonObject = " + jsonObject);

        Map data = new HashMap();
        //判断openid是否为空，如果为空表示登录失败，抛出业务异常
        if (openid == null){
            data.put("tip","微信登录失败");
            return Result.ok(data);
        }

        //判断当前用户是否为新用户
        Wxuser wxuser = wxuserMapper.findByOpenid(openid);

        //如果是新用户，自动完成注册
        if(wxuser == null){
            wxuser = Wxuser.builder()
                    .wxuserOpenid(openid)
                    .createTime(LocalDateTime.now())
                    .wxuserSessionkey(sessionKey)
                    .build();
            int row = wxuserMapper.insertNewWxuser(wxuser);
            System.out.println("row = " + row);
        }

//        String token = jwtHelper.createToken(Long.valueOf(wxuser.getWxuserId()));

        UserInfo userInfo = UserInfo.builder()
                .id(Long.valueOf(wxuser.getWxuserId()))
                .openid(wxuser.getWxuserOpenid())
//                .token(token)
                .build();

        data.put("tip","微信登录成功");
        data.put("userInfo",userInfo);
        //返回这个用户对象
        return Result.ok(data);
    }


}

