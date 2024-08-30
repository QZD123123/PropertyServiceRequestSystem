package com.gdpu.mapper;

import com.gdpu.VO.NormalVo;
import com.gdpu.pojo.Worker;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author ASUS
* @description 针对表【worker】的数据库操作Mapper
* @createDate 2024-08-21 17:22:25
* @Entity com.gdpu.pojo.Worker
*/
public interface WorkerMapper extends BaseMapper<Worker> {


    Worker findWorker(@Param("workerName") String workerName,@Param("workerPhone") String workerPhone);

    int updateByNameNumber(@Param("workerPhone") String workerPhone, @Param("workerName") String workerName);

    int noUsed(@Param("phone") String phone, @Param("name") String name);

    NormalVo selectNormalLastWorkerId();

    int updateNormalLastTime(@Param("workerId") int workerId);

    NormalVo selectEmergencyLastWorkerId();

    int updateEmergencyLastTime(@Param("workerId") int workerId);
}





