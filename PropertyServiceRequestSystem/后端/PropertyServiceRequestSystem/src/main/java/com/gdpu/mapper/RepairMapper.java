package com.gdpu.mapper;

import com.gdpu.DTO.AddRepairInfo;
import com.gdpu.VO.ShowRepairListVo;
import com.gdpu.VO.WorkerShowRepairListVo;
import com.gdpu.pojo.Repair;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author ASUS
* @description 针对表【repair】的数据库操作Mapper
* @createDate 2024-08-27 18:32:44
* @Entity com.gdpu.pojo.Repair
*/
public interface RepairMapper extends BaseMapper<Repair> {


    int addNormalRepairByOpenid(@Param("openid") String openid,@Param("addRepairInfo") AddRepairInfo addRepairInfo,@Param("workerOpenId") String workerOpenId);

    int addEmergencyRepairByOpenid(@Param("openid") String openid,@Param("addRepairInfo") AddRepairInfo addRepairInfo,@Param("workerOpenId") String workerOpenId);

    List<ShowRepairListVo> studentShowNoFinishRepairListByOpenid(@Param("openid") String openid);

    List<WorkerShowRepairListVo> workerShowNormalRepairListByOpenid(@Param("openid") String openid);

    List<WorkerShowRepairListVo> workerShowEmergencyRepairListByOpenid(@Param("openid") String openid);

    ShowRepairListVo selectRepairById(@Param("id") Integer id);

    int finishRepairById(@Param("id") Integer id);

    int deleteRepairById(@Param("id") Integer id);

    int workerNoFinish(@Param("openid") String openid);

    int studentNoFinish(@Param("openid") String openid);

    List<ShowRepairListVo> studentShowFinishRepairListByOpenid(@Param("openid") String openid);

    List<ShowRepairListVo> selectAllNoFinishList();

    Repair findRepairById(@Param("id") Integer id);

    List<Repair> findNormalPendingRepairs();

    List<Repair> findEmergencyPendingRepairs();

    void updateRepair(Repair repair);


}




