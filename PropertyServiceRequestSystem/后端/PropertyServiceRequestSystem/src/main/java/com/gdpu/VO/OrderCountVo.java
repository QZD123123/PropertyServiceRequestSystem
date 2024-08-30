package com.gdpu.VO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderCountVo {

    private Integer noFinish;
    private Integer Finish;
}
