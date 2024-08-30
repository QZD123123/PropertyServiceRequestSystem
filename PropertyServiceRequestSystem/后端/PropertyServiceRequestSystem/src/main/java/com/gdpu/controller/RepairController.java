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
    @GetMapping("student/{openid}")
    public Result studentShowRepairListByOpenid(@PathVariable Integer openid){
        Result result = repairService.studentShowRepairListByOpenid(openid);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('worker')")
    @GetMapping("worker/normal/{openid}")
    public Result workerShowNormalRepairListByOpenid(@PathVariable Integer openid){
        Result result = repairService.workerShowNormalRepairListByOpenid(openid);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('worker')")
    @GetMapping("worker/emergency/{openid}")
    public Result workerShowEmergencyRepairListByOpenid(@PathVariable Integer openid){
        Result result = repairService.workerShowEmergencyRepairListByOpenid(openid);
        return result;
    }


    @PreAuthorize("hasAnyAuthority('worker','student')")
    @GetMapping("{id}")
    public Result selectRepairById(@PathVariable Integer id){
        Result result = repairService.selectRepairById(id);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('worker')")
    @PatchMapping("{id}")
    public Result finishRepairById(@PathVariable Integer id){
        Result result = repairService.finishRepairById(id);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('student')")
    @DeleteMapping("{id}")
    public Result deleteRepairById(@PathVariable Integer id){
        Result result = repairService.deleteRepairById(id);
        return result;
    }

}
