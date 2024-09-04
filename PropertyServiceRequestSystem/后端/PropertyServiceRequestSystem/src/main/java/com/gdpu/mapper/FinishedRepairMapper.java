package com.gdpu.mapper;

import com.gdpu.pojo.FinishedRepair;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdpu.pojo.Repair;
import org.apache.ibatis.annotations.Param;

/**
* @author ASUS
* @description 针对表【finished_repair】的数据库操作Mapper
* @createDate 2024-09-04 16:28:04
* @Entity com.gdpu.pojo.FinishedRepair
*/
public interface FinishedRepairMapper extends BaseMapper<FinishedRepair> {

    void insertCompletedRepair(Repair completedRepair);

    int studentTotalFinish(@Param("openid") String openid);

    int workerTotalFinish(@Param("openid") String openid);
}




