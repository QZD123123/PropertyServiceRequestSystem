package com.gdpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdpu.DTO.AddRepairInfo;
import com.gdpu.DTO.StudentLoginInfo;
import com.gdpu.VO.StudentLoginVO;
import com.gdpu.mapper.RepairMapper;
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

import static com.gdpu.utils.ResultCodeEnum.Request_failed;
import static com.gdpu.utils.ResultCodeEnum.Server_error;

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
    private StudentMapper studentMapper;

    @Autowired
    private WxuserMapper wxuserMapper;

    @Autowired
    private RepairMapper repairMapper;

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
            return Result.build(data,404,"请求失败");
        }

        if(student.getIsUsed() == 1){
            data.put("tip","账号被占用");
            return Result.build(data,Request_failed);
        }

        Wxuser wxuser = wxuserMapper.findByOpenid(openid);
        Integer wxuserId = wxuser.getWxuserId();
        if(wxuser == null){

            data.put("tip","为何还没进行微信登录就能到这一步了");
            log.info("为何还没进行微信登录就能到这一步了");
            return Result.build(data,Server_error);
        }
        //该学生还没登记在wx表中
        if((wxuser.getName() == null || wxuser.getPhone() == null) && student.getIsUsed() == 0){
            wxuser = Wxuser.builder()
                    .wxuserOpenid(openid)
                    .role("student")
                    .phone(studentId)
                    .name(studentName)
                    .deleted(0)
                    .build();
            int row = wxuserMapper.UpdateWxuser(wxuser);
            int isUsed = studentMapper.updateByNameNumber(studentId,studentName);
            if (row == 1 && isUsed == 1){
                log.info("成功为第一次登录的学生更新wx表");
            }
        }

        StudentLoginVO studentLoginVO = StudentLoginVO.builder()
                .tip("登陆成功")
                .id(String.valueOf(wxuserId))
                .openid(openid)
                .role(wxuser.getRole())
                .phone(wxuser.getPhone())
                .name(wxuser.getName())
                .build();

        return Result.ok(studentLoginVO);
    }






}




