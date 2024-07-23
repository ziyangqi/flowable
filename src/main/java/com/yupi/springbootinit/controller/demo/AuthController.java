package com.yupi.springbootinit.controller.demo;

import co.elastic.clients.elasticsearch.xpack.usage.Base;
import com.yupi.springbootinit.common.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;

@Api(tags = "认证流程相关接口")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @ApiOperation("发起认证")
    @PostMapping()
    public BaseResponse apply(){
            return null;
    }
}
