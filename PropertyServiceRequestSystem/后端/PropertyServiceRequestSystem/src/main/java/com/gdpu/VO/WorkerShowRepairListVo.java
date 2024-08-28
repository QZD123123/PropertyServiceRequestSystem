package com.gdpu.VO;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class WorkerShowRepairListVo {

    private String id;
    private String type;                    //类型
    private String applicantName;          //报修人姓名
    private String mobile;                  //手机号
    private String address;                 //地址
    private String description;             //问题描述
    private Date repairDate;               //报修时间2
    private Date finishTime;               //完成时间

}
