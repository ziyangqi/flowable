package com.yupi.springbootinit.model.dto.heart;

import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yupi.springbootinit.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.math3.analysis.function.Constant;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.TimerTask;

/**
 * 查询的条件
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class HeartQueryRequest extends PageRequest implements Serializable {


    private Long id;

    /**
     * 心跳速率
     */
    private Integer heartRate;

    /**
     * 呼吸速率
     */
    private Integer breathRate;

    /**
     * 创建时间
     */
    private Timestamp createDate;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 逻辑删除
     */
    private Integer isDelete;

    /**
     * 查询开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp startTime;

    /**
     * 查询结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp endTime;

    /**
     * 是否异常
     */
    private Integer isHigh;
}
