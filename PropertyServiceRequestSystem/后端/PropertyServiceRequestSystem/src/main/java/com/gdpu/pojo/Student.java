package com.gdpu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName student
 */
@TableName(value ="student")
@Data
public class Student implements Serializable {
    private Integer studentId;

    private String studentNumber;

    private String studentName;

    private String isUsed;

    private static final long serialVersionUID = 1L;
}