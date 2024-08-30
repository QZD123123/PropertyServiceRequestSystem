package com.gdpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdpu.DTO.AddRepairInfo;
import com.gdpu.VO.NormalVo;
import com.gdpu.VO.OrderCountVo;
import com.gdpu.VO.ShowRepairListVo;
import com.gdpu.VO.WorkerShowRepairListVo;
import com.gdpu.mapper.WorkerMapper;
import com.gdpu.pojo.Repair;
import com.gdpu.service.RepairService;
import com.gdpu.mapper.RepairMapper;
import com.gdpu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gdpu.utils.ResultCodeEnum.Server_error;

/**
* @author ASUS
* @description 针对表【repair】的数据库操作Service实现
* @createDate 2024-08-27 18:32:44
*/
@Service
public class RepairServiceImpl extends ServiceImpl<RepairMapper, Repair>
    implements RepairService{

    @Autowired
    private RepairMapper repairMapper;

    @Autowired
    private WorkerMapper workerMapper;


    @Override
    @Transactional
    public Result addNormalRepairByOpenid(Integer openid, AddRepairInfo addRepairInfo) {

        NormalVo normalLastWorkerId = workerMapper.selectNormalLastWorkerId();
        System.out.println("normalLastWorkerId = " + normalLastWorkerId);
        int workerOpenId = normalLastWorkerId.getWxUserOpenid();

        int workerId = normalLastWorkerId.getWorkerId();

        int row = repairMapper.addNormalRepairByOpenid(openid,addRepairInfo,workerOpenId);

        int updateNormalLastTime = workerMapper.updateNormalLastTime(workerId);

        System.out.println("row = " + row);
        System.out.println("updateNormalLastTime = " + updateNormalLastTime);

        Map data = new HashMap();

        if (row == 1 && updateNormalLastTime == 1){
            data.put("tip","添加普通订单成功");
            return Result.ok(data);
        }else {
            data.put("tip","添加普通订单失败");
            return Result.build(data,Server_error);
        }
    }


    @Override
    @Transactional
    public Result addEmergencyRepairByOpenid(Integer openid, AddRepairInfo addRepairInfo) {

        NormalVo emergencyLastWorkerId = workerMapper.selectEmergencyLastWorkerId();

        int workerOpenId = emergencyLastWorkerId.getWxUserOpenid();

        int workerId = emergencyLastWorkerId.getWorkerId();

        int row = repairMapper.addEmergencyRepairByOpenid(openid,addRepairInfo,workerOpenId);

        int updateEmergencyLastTime = workerMapper.updateEmergencyLastTime(workerId);

        Map data = new HashMap();

        if (row == 1 && updateEmergencyLastTime == 1){
            data.put("tip","添加紧急订单成功");
            return Result.ok(data);
        }else {
            data.put("tip","添加紧急订单失败");
            return Result.build(data,Server_error);
        }


    }

    @Override
    public Result studentShowRepairListByOpenid(Integer openid) {

        //获取属于你的报修列表
        List<ShowRepairListVo> list = repairMapper.studentShowRepairListByOpenid(openid);
        return Result.ok(list);

    }


    @Override
    public Result workerShowNormalRepairListByOpenid(Integer openid) {
        //获取属于你的普通报修列表
        List<WorkerShowRepairListVo> list = repairMapper.workerShowNormalRepairListByOpenid(openid);
        return Result.ok(list);
    }

    @Override
    public Result workerShowEmergencyRepairListByOpenid(Integer openid) {
        //获取属于你的紧急报修列表
        List<WorkerShowRepairListVo> list = repairMapper.workerShowEmergencyRepairListByOpenid(openid);
        return Result.ok(list);
    }

    @Override
    public Result workerOrderCount(Integer openid) {

        int noFinish = repairMapper.workerNoFinish(openid);
        int Finish = repairMapper.workerTotalFinish(openid);
        OrderCountVo orderCountVo = OrderCountVo.builder()
                .noFinish(noFinish)
                .Finish(Finish)
                .build();
        return Result.ok(orderCountVo);
    }

    @Override
    public Result studentOrderCount(Integer openid) {

        int noFinish = repairMapper.studentNoFinish(openid);
        int Finish = repairMapper.studentTotalFinish(openid);
        OrderCountVo orderCountVo = OrderCountVo.builder()
                .noFinish(noFinish)
                .Finish(Finish)
                .build();
        return Result.ok(orderCountVo);
    }

    @Override
    public Result selectRepairById(Integer id) {
        ShowRepairListVo showRepairListVo = repairMapper.selectRepairById(id);
        return Result.ok(showRepairListVo);
    }

    @Override
    public Result finishRepairById(Integer id) {
        int row = repairMapper.finishRepairById(id);
        Map data = new HashMap();
        if (row == 1){
            data.put("tip","完成订单");
            return Result.ok(data);
        }else{
            data.put("tip","完成订单出现问题");
            return Result.build(data,Server_error);
        }
    }

    @Override
    public Result deleteRepairById(Integer id) {
        int row = repairMapper.deleteRepairById(id);
        Map data = new HashMap();
        if (row == 1){
            data.put("tip","删除订单成功");
            return Result.ok(data);
        }else{
            data.put("tip","删除订单出现问题");
            return Result.build(data,Server_error);
        }

    }



}




