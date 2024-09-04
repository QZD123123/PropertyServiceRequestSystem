package com.gdpu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName finished_repair
 */
@TableName(value ="finished_repair")
@Data
public class FinishedRepair implements Serializable {
    private Integer id;

    private String workerId;

    private String studentId;

    private Object type;

    private Date repairDate;

    private String address;

    private String description;

    private String applicantName;

    private String mobile;

    private Date finishTime;

    private static final long serialVersionUID = 1L;
}