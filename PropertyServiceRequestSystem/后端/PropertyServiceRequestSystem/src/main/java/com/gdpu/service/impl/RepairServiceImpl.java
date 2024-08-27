package com.gdpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdpu.DTO.AddRepairInfo;
import com.gdpu.VO.ShowRepairListVo;
import com.gdpu.pojo.Repair;
import com.gdpu.service.RepairService;
import com.gdpu.mapper.RepairMapper;
import com.gdpu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @Override
    public Result addNormalRepairByOpenid(Integer openid, AddRepairInfo addRepairInfo) {

        int row = repairMapper.addNormalRepairByOpenid(openid,addRepairInfo);

        Map data = new HashMap();

        if (row >= 1){
            data.put("tip","添加普通订单成功");
        }else {
            data.put("tip","添加普通订单失败");
        }

        return Result.ok(data);
    }


    @Override
    public Result showRepairListByOpenid(Integer openid) {

        //获取属于你的报修列表
        List<ShowRepairListVo> list = repairMapper.showRepairListByOpenid(openid);
        return Result.ok(list);

    }

    @Override
    public Result addEmergencyRepairByOpenid(Integer openid, AddRepairInfo addRepairInfo) {
        int row = repairMapper.addEmergencyRepairByOpenid(openid,addRepairInfo);

        Map data = new HashMap();

        if (row >= 1){
            data.put("tip","添加紧急订单成功");
        }else {
            data.put("tip","添加紧急订单失败");
        }

        return Result.ok(data);
    }


}




