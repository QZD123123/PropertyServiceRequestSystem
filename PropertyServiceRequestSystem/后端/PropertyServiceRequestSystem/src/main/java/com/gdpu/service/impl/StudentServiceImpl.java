package com.gdpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdpu.DTO.StudentLoginInfo;
import com.gdpu.VO.StudentLoginVO;
import com.gdpu.mapper.WxuserMapper;
import com.gdpu.pojo.Student;
import com.gdpu.pojo.Wxuser;
import com.gdpu.service.StudentService;
import com.gdpu.mapper.StudentMapper;
import com.gdpu.utils.JwtHelper;
import com.gdpu.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author ASUS
* @description 针对表【student】的数据库操作Service实现
* @createDate 2024-08-21 17:21:47
*/
@Service
@Slf4j
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private WxuserMapper wxuserMapper;

    @Override
    public Result studentLogin(StudentLoginInfo studentLoginInfo) {
        Map data = new HashMap();
        String studentName = studentLoginInfo.getStudentName();
        String studentId = studentLoginInfo.getStudentId();
        String openid = studentLoginInfo.getOpenid();
        Student student = studentMapper.findStudent(studentName,studentId);

        if(student == null){
            data.put("tip","该学生名字或学号不在库中");
            log.info("该学生名字或学号不在库中");
        }

        Wxuser wxuser = wxuserMapper.findByOpenid(openid);
        Integer wxuserId = wxuser.getWxuserId();
        if(wxuser == null){
            data.put("tip","为何还没进行微信登录就能到这一步了");
            log.info("为何还没进行微信登录就能到这一步了");
        }
        //该学生还没登记在wx表中
        if(wxuser.getName() == null || wxuser.getPhone() == null){
            wxuser = Wxuser.builder()
                    .wxuserOpenid(openid)
                    .stuId(student.getStudentId())
                    .role("student")
                    .phone(studentId)
                    .name(studentName)
                    .deleted(0)
                    .build();
            int row = wxuserMapper.UpdateWxuser(wxuser);
            if (row ==1){
                log.info("成功为第一次登录的学生更新wx表");
            }
        }
        data.put("tip","登录成功");

        StudentLoginVO studentLoginVO = StudentLoginVO.builder()
                .id(String.valueOf(wxuserId))
                .openid(openid)
                .studentId(String.valueOf(wxuser.getStuId()))
                .role(wxuser.getRole())
                .phone(wxuser.getPhone())
                .name(wxuser.getName())
                .build();

        data.put("studentLoginVO",studentLoginVO);

        return Result.ok(data);
    }



}




