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


    Result addNormalRepairByOpenid(String openid, AddRepairInfo addRepairInfo);

    Result addEmergencyRepairByOpenid(String openid, AddRepairInfo addRepairInfo);


    Result workerShowNormalRepairListByOpenid(String openid);

    Result selectRepairById(Integer id);

    Result finishRepairById(Integer id);

    Result deleteRepairById(Integer id);

    Result workerShowEmergencyRepairListByOpenid(String openid);


    Result workerOrderCount(String openid);

    Result studentOrderCount(String openid);

    Result studentShowNoFinishRepairListByOpenid(String openid);

    Result studentShowFinishRepairListByOpenid(String openid);

    Result selectAllNoFinishList();
}
