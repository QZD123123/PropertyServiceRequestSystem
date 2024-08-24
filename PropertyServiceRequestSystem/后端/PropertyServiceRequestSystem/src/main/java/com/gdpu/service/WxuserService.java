package com.gdpu.service;

import com.gdpu.DTO.WxLoginInfo;
import com.gdpu.pojo.Wxuser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gdpu.utils.Result;

/**
* @author ASUS
* @description 针对表【wxuser】的数据库操作Service
* @createDate 2024-08-21 17:22:30
*/
public interface WxuserService extends IService<Wxuser> {

    Result wxLogin(WxLoginInfo wxLoginInfo);
}
