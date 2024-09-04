package com.gdpu.controller;

import com.gdpu.DTO.AddPersonInfo;
import com.gdpu.DTO.WorkerLoginInfo;
import com.gdpu.DTO.whoCanWorkDTO;
import com.gdpu.pojo.Worker;
import com.gdpu.service.WorkerService;
import com.gdpu.service.impl.WorkerServiceImpl;
import com.gdpu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @PreAuthorize("hasAnyAuthority('xxxx')")
    @PostMapping("login")
    public Result workerLogin(@RequestBody WorkerLoginInfo workerLoginInfo){
        Result result = workerService.workerLogin(workerLoginInfo);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('xxxx')")
    @PostMapping("admin/login")
    public Result adminLogin(@RequestBody WorkerLoginInfo workerLoginInfo){
        Result result = workerService.adminLogin(workerLoginInfo);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('admin')")
    @PostMapping("addAdmin")
    public Result addAdmin(@RequestBody AddPersonInfo addPersonInfo){
        Result result = workerService.addWorker(addPersonInfo);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('admin')")
    @PostMapping("addWorker")
    public Result addWorker(@RequestBody AddPersonInfo addPersonInfo){
        Result result = workerService.addWorker(addPersonInfo);
        return result;
    }


    @PreAuthorize("hasAnyAuthority('worker')")
    @DeleteMapping("{openid}")
    public Result deleteWxuserByOpenid(@PathVariable String openid){
        Result result = workerService.deleteWxuserByOpenid(openid);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('admin')")
    @GetMapping()
    public Result selectAllWorker(){
        Result result = workerService.selectAllWorker();
        return result;
    }

    @PreAuthorize("hasAnyAuthority('admin')")
    @PatchMapping("work/{workerId}")
    public Result canWork(@PathVariable String workerId){
        Result result = workerService.canWork(workerId);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('admin')")
    @PatchMapping("rest/{workerId}")
    public Result canNotWork(@PathVariable String workerId){
        Result result = workerService.canNotWork(workerId);
        return result;
    }

    @PreAuthorize("hasAnyAuthority('admin')")
    @PostMapping("unknow")
    public Result whoCanWork(@RequestBody whoCanWorkDTO[] workers){
        Result result = workerService.whoCanWork(workers);
        return result;
    }

}
