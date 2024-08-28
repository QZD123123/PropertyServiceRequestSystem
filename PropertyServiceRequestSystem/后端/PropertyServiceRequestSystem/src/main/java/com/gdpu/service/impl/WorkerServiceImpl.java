package com.gdpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdpu.DTO.WorkerLoginInfo;
import com.gdpu.VO.StudentLoginVO;
import com.gdpu.VO.WorkerLoginVo;
import com.gdpu.mapper.WxuserMapper;
import com.gdpu.pojo.Student;
import com.gdpu.pojo.Worker;
import com.gdpu.pojo.Wxuser;
import com.gdpu.service.WorkerService;
import com.gdpu.mapper.WorkerMapper;
import com.gdpu.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gdpu.utils.ResultCodeEnum.Request_failed;
import static com.gdpu.utils.ResultCodeEnum.Server_error;

/**
* @author ASUS
* @description 针对表【worker】的数据库操作Service实现
* @createDate 2024-08-21 17:22:25
*/
@Service
@Slf4j
public class WorkerServiceImpl extends ServiceImpl<WorkerMapper, Worker>
    implements WorkerService{

    @Autowired
    private WorkerMapper workerMapper;

    @Autowired
    private WxuserMapper wxuserMapper;

    @Override
    public Result workerLogin(WorkerLoginInfo workerLoginInfo) {

        Map data = new HashMap();
        String workerName = workerLoginInfo.getWorkerName();
        String workerPhone = workerLoginInfo.getWorkerPhone();
        String openid = workerLoginInfo.getOpenid();
        System.out.println("workerName = " + workerName);
        System.out.println("workerPhone = " + workerPhone);
        System.out.println("openid = " + openid);

        Worker worker = workerMapper.findWorker(workerName,workerPhone);
        System.out.println("worker = " + worker);

        if(worker == null){
            data.put("tip","该维修工人名字或手机号不在库中");
            log.info("该维修工人名字或手机号不在库中");
            return Result.build(data,404,"请求失败");
        }

        if(worker.getIsUsed() == 1){
            data.put("tip","账号被占用");
            return Result.build(data,Request_failed);
        }


        Wxuser wxuser = wxuserMapper.findByOpenid(openid);
        Integer wxuserId = wxuser.getWxuserId();
        System.out.println("wxuser = " + wxuser);
        if(wxuser == null){
            data.put("tip","为何还没进行微信登录就能到这一步了");
            log.info("为何还没进行微信登录就能到这一步了");
            return Result.build(data,Server_error);
        }
        //该维修工人还没登记在wx表中
        if((wxuser.getName() == null || wxuser.getPhone() == null) && worker.getIsUsed() == 0){
            wxuser = Wxuser.builder()
                    .wxuserOpenid(openid)
                    .role("worker")
                    .phone(workerPhone)
                    .name(workerName)
                    .deleted(0)
                    .build();
            int row = wxuserMapper.UpdateWxuser(wxuser);
            int isUsed = workerMapper.updateByNameNumber(workerPhone,workerName);
            if (row == 1 && isUsed == 1){
                log.info("成功为第一次登录的维修工人更新wx表 {}",wxuser.getName());
            }
        }
        data.put("tip","登录成功");

        WorkerLoginVo workerLoginVo = WorkerLoginVo.builder()
                .id(String.valueOf(wxuserId))
                .openid(openid)
                .role(wxuser.getRole())
                .phone(wxuser.getPhone())
                .name(wxuser.getName())
                .build();

        data.put("workerLoginVO",workerLoginVo);

        return Result.ok(data);



    }
}




