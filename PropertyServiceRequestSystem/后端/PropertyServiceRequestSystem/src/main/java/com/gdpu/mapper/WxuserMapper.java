package com.gdpu.mapper;

import com.gdpu.pojo.Wxuser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author ASUS
* @description 针对表【wxuser】的数据库操作Mapper
* @createDate 2024-08-21 17:22:30
* @Entity com.gdpu.pojo.Wxuser
*/
public interface WxuserMapper extends BaseMapper<Wxuser> {

    int insertNewWxuser(@Param("wxuser") Wxuser wxuser);

    Wxuser findByOpenid(@Param("openid") String openid);

    Wxuser findByPhone(String phone);

    int UpdateWxuser(@Param("wxuser") Wxuser wxuser);

    int deleteByOpenid(@Param("openid") Integer openid);
}




