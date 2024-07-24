package com.yupi.springbootinit.controller.demo;

import co.elastic.clients.elasticsearch.xpack.usage.Base;
import com.yupi.springbootinit.common.BaseResponse;
import com.yupi.springbootinit.common.PageResult;
import com.yupi.springbootinit.model.dto.process.ProcessHandleDTO;
import com.yupi.springbootinit.model.dto.process.ProcessListQuery;
import com.yupi.springbootinit.model.dto.process.ProcessStartDTO;
import com.yupi.springbootinit.service.demo.ProcessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
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
    public BaseResponse list(@ModelAttribute @Valid ProcessListQuery processListQuery) {
        PageResult processList = processService.getProcessList(processListQuery);
        BaseResponse response = new BaseResponse(0,processList,"");
        return response;
    }
    @ApiOperation("发起流程")
    @PostMapping("/start")
    public BaseResponse start(@RequestBody ProcessStartDTO processStartDTO){
        String msg = processService.startProcess(processStartDTO);
        return new BaseResponse(0,msg,"");
    }
    @ApiOperation("审批流程")
    @PostMapping("/complete")
    public BaseResponse complete(@RequestBody ProcessHandleDTO processHandleDTO){
        String msg = processService.complete(processHandleDTO);
        return new BaseResponse(0,msg,"");
    }
    @ApiOperation("获取流程进度")
    @PostMapping("/speed")
    public BaseResponse getSpeed(@RequestParam String taskId){
        HashMap<String,Object> data = processService.getSpeed(taskId);
        return new BaseResponse(0,data,"");
    }
}
