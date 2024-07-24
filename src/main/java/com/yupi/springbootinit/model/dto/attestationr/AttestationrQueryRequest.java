package com.yupi.springbootinit.model.dto.attestationr;

import lombok.Data;

import java.io.Serializable;

/**
 * QueryRequest 根据id appid secret 进行查询
 */
@Data
public class AttestationrQueryRequest implements Serializable {



    /**
     *  用户id
     */
    private String userId;


    private static final long serialVersionUID = 1L;
}
