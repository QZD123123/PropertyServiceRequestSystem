package com.gdpu.mapper;

import com.gdpu.DTO.AddPersonInfo;
import com.gdpu.pojo.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;

import java.util.List;

/**
* @author ASUS
* @description 针对表【student】的数据库操作Mapper
* @createDate 2024-08-21 17:21:47
* @Entity com.gdpu.pojo.Student
*/
public interface StudentMapper extends BaseMapper<Student> {

    Student findStudent(@Param("studentName") String studentName, @Param("studentId") String studentId);

    int updateByNameNumber(@Param("studentId") String studentId,@Param("studentName") String studentName);

    int noUsed(@Param("phone") String phone,@Param("name") String name);

    int addStudent(AddPersonInfo addPersonInfo);
}




