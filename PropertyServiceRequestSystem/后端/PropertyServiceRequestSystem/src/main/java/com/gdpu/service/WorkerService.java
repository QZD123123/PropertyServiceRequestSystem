package com.gdpu.service;

import com.gdpu.DTO.AddPersonInfo;
import com.gdpu.DTO.WorkerLoginInfo;
import com.gdpu.DTO.whoCanWorkDTO;
import com.gdpu.pojo.Worker;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gdpu.utils.Result;

/**
* @author ASUS
* @description 针对表【worker】的数据库操作Service
* @createDate 2024-08-21 17:22:25
*/
public interface WorkerService extends IService<Worker> {

    Result workerLogin(WorkerLoginInfo workerLoginInfo);

    Result deleteWxuserByOpenid(String openid);

    Result selectAllWorker();

    Result canWork(String workerId);

    Result canNotWork(String workerId);

    Result whoCanWork(whoCanWorkDTO[] workers);

    Result adminLogin(WorkerLoginInfo workerLoginInfo);

    Result addWorker(AddPersonInfo addPersonInfo);
}
