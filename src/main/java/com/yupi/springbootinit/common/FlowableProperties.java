package com.yupi.springbootinit.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@Component
@ConfigurationProperties(prefix = "flowable")
public class FlowableProperties {
    /**
     * 应用id
     */
    private String appid;
    /**
     * 应用密钥
     */
    private String secret;

}
