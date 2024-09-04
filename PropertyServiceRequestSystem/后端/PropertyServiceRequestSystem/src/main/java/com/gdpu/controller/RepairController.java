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
    public Result addNormalRepairByOpenid(@PathVariable String openid, @RequestBody AddRepairInfo addRepairInfo){
        Result result = repairService.addNormalRepairByOpenid(openid,addRepairInfo);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('student')")
    @PostMapping("addEmergencyRepair/{openid}")
    public Result addEmergencyRepairByOpenid(@PathVariable String openid, @RequestBody AddRepairInfo addRepairInfo){
        Result result = repairService.addEmergencyRepairByOpenid(openid,addRepairInfo);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('student')")
    @GetMapping("noFinish/{openid}")
    public Result studentShowNoFinishRepairListByOpenid(@PathVariable String openid){
        Result result = repairService.studentShowNoFinishRepairListByOpenid(openid);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('student')")
    @GetMapping("finish/{openid}")
    public Result studentShowFinishRepairListByOpenid(@PathVariable String openid){
        Result result = repairService.studentShowFinishRepairListByOpenid(openid);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('worker')")
    @GetMapping("worker/normal/{openid}")
    public Result workerShowNormalRepairListByOpenid(@PathVariable String openid){
        Result result = repairService.workerShowNormalRepairListByOpenid(openid);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('worker')")
    @GetMapping("worker/emergency/{openid}")
    public Result workerShowEmergencyRepairListByOpenid(@PathVariable String openid){
        Result result = repairService.workerShowEmergencyRepairListByOpenid(openid);
        return result;
    }


    @PreAuthorize("hasAnyAuthority('worker','student')")
    @GetMapping("{id}")
    public Result selectRepairById(@PathVariable Integer id){
        Result result = repairService.selectRepairById(id);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('student')")
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

    @PreAuthorize("hasAnyAuthority('worker')")
    @GetMapping("workerOrderCount/{openid}")
    public Result workerOrderCount(@PathVariable String openid){
        Result result = repairService.workerOrderCount(openid);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('student')")
    @GetMapping("studentOrderCount/{openid}")
    public Result studentOrderCount(@PathVariable String openid){
        Result result = repairService.studentOrderCount(openid);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('admin')")
    @GetMapping("noFinish")
    public Result selectAllNoFinishList(){
        Result result = repairService.selectAllNoFinishList();
        return result;
    }
}
