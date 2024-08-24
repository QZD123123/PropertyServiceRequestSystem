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

    @Select("SELECT * FROM wxuser")
    List<Wxuser> getAllWxusers();

    @Select("SELECT * FROM wxuser WHERE wxUser_id = #{id}")
    Wxuser getWxuserById(Long id);

    @Insert("INSERT INTO wxuser (wxUser_openid, wxUser_sessionkey, stu_id, worker_id) VALUES (#{wxUserOpenid}, #{wxUserSessionkey}, #{stuId}, #{workerId})")
    @Options(useGeneratedKeys = true, keyProperty = "wxUserId")
    void insertWxuser(Wxuser wxuser);

    @Update("UPDATE wxuser SET wxUser_openid = #{wxUserOpenid}, wxUser_sessionkey = #{wxUserSessionkey}, stu_id = #{stuId}, worker_id = #{workerId} WHERE wxUser_id = #{wxUserId}")
    void updateWxuser(Wxuser wxuser);

    @Delete("DELETE FROM wxuser WHERE wxUser_id = #{id}")
    void deleteWxuser(Long id);

    Wxuser findByPhone(@Param("phone") String phone);

    //根据openid查询用户
    @Select("select * from wxuser where wxUser_openid=#{openid}")
    Wxuser getByOpenid(@Param("openid") String openid);

    int insertNewWxuser(@Param("wxuser") Wxuser wxuser);
}




