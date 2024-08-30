package com.gdpu.service;

import com.gdpu.DTO.AddRepairInfo;
import com.gdpu.pojo.Repair;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gdpu.utils.Result;

/**
* @author ASUS
* @description 针对表【repair】的数据库操作Service
* @createDate 2024-08-27 18:32:44
*/
public interface RepairService extends IService<Repair> {


    Result addNormalRepairByOpenid(Integer openid, AddRepairInfo addRepairInfo);

    Result studentShowRepairListByOpenid(Integer openid);

    Result addEmergencyRepairByOpenid(Integer openid, AddRepairInfo addRepairInfo);


    Result workerShowNormalRepairListByOpenid(Integer openid);

    Result selectRepairById(Integer id);

    Result finishRepairById(Integer id);

    Result deleteRepairById(Integer id);

    Result workerShowEmergencyRepairListByOpenid(Integer openid);
}
