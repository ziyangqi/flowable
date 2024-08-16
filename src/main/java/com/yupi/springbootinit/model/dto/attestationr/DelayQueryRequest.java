package com.yupi.springbootinit.model.dto.attestationr;

import lombok.Data;

import java.io.Serializable;
import java.security.Timestamp;

/**
 * 流程代办的查询接口的dto格式
 */
@Data
public class DelayQueryRequest implements Serializable  {


    /**
     * 限制每页几条数据
     */
    private String  limit;

    /**
     * 第几页的数据
     */
    private String  page;

    /**
     * 查询开始时间
     */
    private Timestamp startTime;

    /**
     * 查询结束时间
     */
    private Timestamp endTime;

    private static final long serialVersionUID = 1L;

}

