package com.yupi.springbootinit.controller.demo;

import com.yupi.springbootinit.common.BaseResponse;
import com.yupi.springbootinit.model.dto.process.ProcessListQuery;
import com.yupi.springbootinit.service.demo.ProcessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "流程相关接口")
@RestController
@RequestMapping("/process")
public class ProcessController {
    @Autowired
    private ProcessService processService;

    @ApiOperation("获取流程列表")
    @GetMapping("/list")
    public BaseResponse list(@RequestBody ProcessListQuery processListQuery) {
        List processList = processService.getProcessList(processListQuery);
        return null;
    }
}
