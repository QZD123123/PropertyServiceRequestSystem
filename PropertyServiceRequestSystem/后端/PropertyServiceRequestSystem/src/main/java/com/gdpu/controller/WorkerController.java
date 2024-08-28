package com.gdpu.controller;

import com.gdpu.DTO.WorkerLoginInfo;
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
}
