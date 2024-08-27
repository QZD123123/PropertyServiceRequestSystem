package com.gdpu.controller;

import com.gdpu.DTO.AddRepairInfo;
import com.gdpu.DTO.StudentLoginInfo;
import com.gdpu.service.StudentService;
import com.gdpu.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("login")
    public Result studentLogin(@RequestBody StudentLoginInfo studentLoginInfo){
        Result result = studentService.studentLogin(studentLoginInfo);
        return result;
    }




}
