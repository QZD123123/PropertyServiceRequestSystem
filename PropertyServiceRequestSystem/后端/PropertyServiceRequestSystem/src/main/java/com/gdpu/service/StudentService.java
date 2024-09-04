package com.gdpu.service;

import com.gdpu.DTO.AddPersonInfo;
import com.gdpu.DTO.AddRepairInfo;
import com.gdpu.DTO.StudentLoginInfo;
import com.gdpu.pojo.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gdpu.utils.Result;

/**
* @author ASUS
* @description 针对表【student】的数据库操作Service
* @createDate 2024-08-21 17:21:47
*/
public interface StudentService extends IService<Student> {

    Result studentLogin(StudentLoginInfo studentLoginInfo);


    Result deleteWxuserByOpenid(String openid);

    Result addStudent(AddPersonInfo addPersonInfo);
}
