package com.gdpu.VO;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ShowRepairListVo {
    private String id;
    private String type;                    //类型
    private String applicantName;          //报修人姓名
    private String mobile;                  //手机号
    private String address;                 //地址
    private String description;             //问题描述
    private Date repairDate;               //报修时间
    private String workerName;
    private Date finishTime;               //完成时间
    private String repairCancelReason;    //取消原因
    private Date repairCancelDate;        //取消时间




}
