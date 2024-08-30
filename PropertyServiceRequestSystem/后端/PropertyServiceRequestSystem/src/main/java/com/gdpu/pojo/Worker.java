package com.gdpu.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @TableName worker
 */
@TableName(value ="worker")
@Data
public class Worker implements Serializable {
    private Integer workerId;

    private String workerPhone;

    private String workerName;

    private String isUsed;

    private Date normalLastAssigned;

    private Date emergencyLastAssigned;

    private static final long serialVersionUID = 1L;
}