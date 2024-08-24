package com.gdpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdpu.DTO.StudentLoginInfo;
import com.gdpu.pojo.Student;
import com.gdpu.service.StudentService;
import com.gdpu.mapper.StudentMapper;
import com.gdpu.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author ASUS
* @description 针对表【student】的数据库操作Service实现
* @createDate 2024-08-21 17:21:47
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Result studentLogin(StudentLoginInfo studentLoginInfo) {
        String studentName = studentLoginInfo.getStudentName();
        String studentId = studentLoginInfo.getStudentId();
        Student student = studentMapper.findStudent(studentName,studentId);

        //如果学校表中有这个学生&&还没有和wx表进行绑定，就将这个在学生表中注册
        if(){

        }
    }





}




