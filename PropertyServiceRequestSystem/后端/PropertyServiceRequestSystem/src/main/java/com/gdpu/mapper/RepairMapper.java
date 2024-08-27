package com.gdpu.mapper;

import com.gdpu.DTO.AddRepairInfo;
import com.gdpu.VO.ShowRepairListVo;
import com.gdpu.pojo.Repair;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
* @author ASUS
* @description 针对表【repair】的数据库操作Mapper
* @createDate 2024-08-27 18:32:44
* @Entity com.gdpu.pojo.Repair
*/
public interface RepairMapper extends BaseMapper<Repair> {


    int addNormalRepairByOpenid(@Param("openid") Integer openid,@Param("addRepairInfo") AddRepairInfo addRepairInfo);

    int addEmergencyRepairByOpenid(@Param("openid") Integer openid,@Param("addRepairInfo") AddRepairInfo addRepairInfo);

    List<ShowRepairListVo> showRepairListByOpenid(@Param("openid") Integer openid);

}




