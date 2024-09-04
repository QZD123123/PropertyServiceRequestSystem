package com.gdpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdpu.DTO.AddPersonInfo;
import com.gdpu.DTO.WorkerLoginInfo;
import com.gdpu.DTO.whoCanWorkDTO;
import com.gdpu.VO.StudentLoginVO;
import com.gdpu.VO.WorkerLoginVo;
import com.gdpu.VO.workerListVo;
import com.gdpu.mapper.RepairMapper;
import com.gdpu.mapper.WxuserMapper;
import com.gdpu.pojo.Repair;
import com.gdpu.pojo.Student;
import com.gdpu.pojo.Worker;
import com.gdpu.pojo.Wxuser;
import com.gdpu.service.WorkerService;
import com.gdpu.mapper.WorkerMapper;
import com.gdpu.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gdpu.utils.ResultCodeEnum.*;

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

    @Autowired
    private RepairMapper repairMapper;

    @Override
    public Result workerLogin(WorkerLoginInfo workerLoginInfo) {

        Map data = new HashMap();
        String workerName = workerLoginInfo.getWorkerName();
        String workerPhone = workerLoginInfo.getWorkerPhone();
        String openid = workerLoginInfo.getOpenid();

        Worker worker = workerMapper.findWorker(workerName,workerPhone);

        if(worker == null){
            data.put("tip","该维修工人名字或手机号不在库中");
            log.info("该维修工人名字或手机号不在库中");
            return Result.build(data,404,"请求失败");
        }

        if("1".equals(worker.getIsUsed())){
            data.put("tip","账号被占用");
            return Result.build(data,Request_failed);
        }


        Wxuser wxuser = wxuserMapper.findByOpenid(openid);
        Integer wxuserId = wxuser.getWxuserId();
        if(wxuser == null){
            data.put("tip","为何还没进行微信登录就能到这一步了");
            log.info("为何还没进行微信登录就能到这一步了");
            return Result.build(data,Server_error);
        }
        //该维修工人还没登记在wx表中
        if((wxuser.getName() == null || wxuser.getPhone() == null) && "0".equals(worker.getIsUsed())){
            wxuser = Wxuser.builder()
                    .wxuserOpenid(openid)
                    .role("worker")
                    .phone(workerPhone)
                    .name(workerName)
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

    @Override
    public Result adminLogin(WorkerLoginInfo workerLoginInfo) {
        Map data = new HashMap();
        String workerName = workerLoginInfo.getWorkerName();
        String workerPhone = workerLoginInfo.getWorkerPhone();
        String openid = workerLoginInfo.getOpenid();

        Worker worker = workerMapper.findWorker(workerName,workerPhone);

        if(worker == null){
            data.put("tip","该管理员名字或手机号不在库中");
            log.info("该管理员名字或手机号不在库中");
            return Result.build(data,404,"请求失败");
        }

        if("1".equals(worker.getIsUsed())){
            data.put("tip","账号被占用");
            return Result.build(data,Request_failed);
        }


        Wxuser wxuser = wxuserMapper.findByOpenid(openid);
        Integer wxuserId = wxuser.getWxuserId();
        if(wxuser == null){
            data.put("tip","为何还没进行微信登录就能到这一步了");
            log.info("为何还没进行微信登录就能到这一步了");
            return Result.build(data,Server_error);
        }
        //该维修工人还没登记在wx表中
        if((wxuser.getName() == null || wxuser.getPhone() == null) && "0".equals(worker.getIsUsed())){
            wxuser = Wxuser.builder()
                    .wxuserOpenid(openid)
                    .role("admin")
                    .phone(workerPhone)
                    .name(workerName)
                    .build();
            int row = wxuserMapper.UpdateWxuser(wxuser);
            int isUsed = workerMapper.updateByNameNumber(workerPhone,workerName);
            if (row == 1 && isUsed == 1){
                log.info("成功为第一次登录的管理员更新wx表 {}",wxuser.getName());
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

    @Override
    public Result addWorker(AddPersonInfo addPersonInfo) {

        int row = workerMapper.addWorker(addPersonInfo);

        Map data = new HashMap();
        if (row == 1){
            data.put("tip","添加工人或者管理员成功");
            return Result.ok(data);
        }else {
            data.put("tip","添加工人或者管理员失败");
            return Result.build(data,Server_error);
        }

    }


    @Override
    @Transactional
    public Result deleteWxuserByOpenid(String openid) {
        Wxuser wxuser = wxuserMapper.findByOpenid(openid);

        int noUsed = workerMapper.noUsed(wxuser.getPhone(), wxuser.getName());

        int row = wxuserMapper.deleteByOpenid(openid);

        Map data = new HashMap();
        if (noUsed == 1 && row == 1){
            data.put("tip","注销维修工人账号成功");
            return Result.ok(data);
        }else {
            data.put("tip","注销维修工人账号失败");
            return Result.build(data,Server_error);
        }
    }

    @Override
    public Result selectAllWorker() {

        List<workerListVo> list = workerMapper.selectAllWorker();

        return Result.ok(list);

    }

    @Override
    public Result canWork(String workerId) {

        int row = workerMapper.canWork(workerId);

        Map data = new HashMap();
        if (row == 1){
            data.put("tip","修改状态成功");
            return Result.ok(data);
        }else {
            data.put("tip","修改状态失败");
            return Result.build(data,Server_error);
        }

    }

    @Override
    public Result canNotWork(String workerId) {
        int row = workerMapper.canNotWork(workerId);

        Map data = new HashMap();
        if (row == 1){
            data.put("tip","修改状态成功");
            return Result.ok(data);
        }else {
            data.put("tip","修改状态失败");
            return Result.build(data,Server_error);
        }

    }

    @Override
    @Transactional
    public Result whoCanWork(whoCanWorkDTO[] workers) {
        for (whoCanWorkDTO w : workers) {
            // 访问 whoCanWorkDTO 对象的属性
            String id = w.getId();
            String canWork = w.getCanWork();

            // 调用更新方法
            workerMapper.updateWorkerCanWork(id, canWork);
        }

        // 获取所有可用的工人
        List<Worker> availableWorkers = workerMapper.findAvailableWorkers();

        // 获取所有未完成的普通的订单
        List<Repair> normal = repairMapper.findNormalPendingRepairs();

        // 获取所有未完成的紧急的订单
        List<Repair> emergency = repairMapper.findEmergencyPendingRepairs();

        Map data = new HashMap();

        int workerCount = availableWorkers.size();
        if (workerCount == 0) {
            data.put("tip","没有可用的工人");
            return Result.build(data,no_Resource);
        }

        // 使用轮询算法分配工人
        int workerIndex = 0;
        for (Repair repair : emergency) {
            Worker worker = availableWorkers.get(workerIndex);
            Wxuser wxuser = wxuserMapper.findByPhone(worker.getWorkerPhone());

            if (wxuser == null) {
                // 记录更多信息
                System.err.println("No wxuser found for phone: " + worker.getWorkerPhone() + " (Worker ID: " + worker.getWorkerId() + ")");
                continue; // 跳过这个工人
            }

            String workerOpenId = wxuser.getWxuserOpenid();
            repair.setWorkerId(workerOpenId);

            // 更新到数据库
            repairMapper.updateRepair(repair);

            // 更新工人索引
            workerIndex = (workerIndex + 1) % workerCount;
        }

        // 使用轮询算法分配工人
        workerIndex = 0;
        for (Repair repair : normal) {
            Worker worker = availableWorkers.get(workerIndex);
            Wxuser wxuser = wxuserMapper.findByPhone(worker.getWorkerPhone());

            if (wxuser == null) {
                // 记录更多信息
                System.err.println("No wxuser found for phone: " + worker.getWorkerPhone() + " (Worker ID: " + worker.getWorkerId() + ")");
                continue; // 跳过这个工人
            }

            String workerOpenId = wxuser.getWxuserOpenid();
            repair.setWorkerId(workerOpenId);

            // 更新到数据库
            repairMapper.updateRepair(repair);

            // 更新工人索引
            workerIndex = (workerIndex + 1) % workerCount;
        }

        data.put("tip","派单列表已更新");

        return Result.ok(data);
    }



}




