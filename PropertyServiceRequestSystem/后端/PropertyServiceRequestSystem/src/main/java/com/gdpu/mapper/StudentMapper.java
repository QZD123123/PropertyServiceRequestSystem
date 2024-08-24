package com.gdpu.mapper;

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

    @Select("SELECT * FROM student")
    List<Student> getAllStudents();

    @Select("SELECT * FROM student WHERE student_id = #{id}")
    Student getStudentById(Long id);

    @Insert("INSERT INTO student (student_phone, student_name) VALUES (#{studentPhone}, #{studentName})")
    @Options(useGeneratedKeys = true, keyProperty = "studentId")
    void insertStudent(Student student);

    @Update("UPDATE student SET student_phone = #{studentPhone}, student_name = #{studentName} WHERE student_id = #{studentId}")
    void updateStudent(Student student);

    @Delete("DELETE FROM student WHERE student_id = #{id}")
    void deleteStudent(Long id);
}




