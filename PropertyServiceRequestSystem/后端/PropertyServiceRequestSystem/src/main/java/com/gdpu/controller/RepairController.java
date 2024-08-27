package com.gdpu.controller;

import com.gdpu.DTO.AddRepairInfo;
import com.gdpu.service.RepairService;
import com.gdpu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairService repairService;

    @PreAuthorize("hasAnyAuthority('student')")
    @PostMapping("addNormalRepair/{openid}")
    public Result addNormalRepairByOpenid(@PathVariable Integer openid, @RequestBody AddRepairInfo addRepairInfo){
        Result result = repairService.addNormalRepairByOpenid(openid,addRepairInfo);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('student')")
    @PostMapping("addEmergencyRepair/{openid}")
    public Result addEmergencyRepairByOpenid(@PathVariable Integer openid, @RequestBody AddRepairInfo addRepairInfo){
        Result result = repairService.addEmergencyRepairByOpenid(openid,addRepairInfo);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('student')")
    @GetMapping("showRepair/{openid}")
    public Result showRepairListByOpenid(@PathVariable Integer openid){
        Result result = repairService.showRepairListByOpenid(openid);
        return result;
    }

}
