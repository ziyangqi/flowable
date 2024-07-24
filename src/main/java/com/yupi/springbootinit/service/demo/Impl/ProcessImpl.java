package com.yupi.springbootinit.service.demo.Impl;

import com.yupi.springbootinit.client.DemoClient;
import com.yupi.springbootinit.common.BaseResponse;
import com.yupi.springbootinit.common.PageResult;
import com.yupi.springbootinit.model.dto.process.ProcessHandleDTO;
import com.yupi.springbootinit.model.dto.process.ProcessListQuery;
import com.yupi.springbootinit.model.dto.process.ProcessStartDTO;
import com.yupi.springbootinit.model.vo.process.ProcessSpeedVO;
import com.yupi.springbootinit.service.demo.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProcessImpl implements ProcessService {
    @Autowired
    DemoClient demoClient;

    @Override
    public PageResult getProcessList(ProcessListQuery processListQuery) {
        HashMap<String, Object> result = demoClient.getProcessList(processListQuery);
        if((int)result.get("code") != 0) {
            throw new RuntimeException("系统错误");
        }
        List<Object> list = (List<Object>) result.get("data");
        Integer count = (Integer) result.get("count");
        PageResult pageResult = PageResult.create(count,list);
        return pageResult;
    }

    @Override
    public String startProcess(ProcessStartDTO processStartDTO) {
        HashMap<String, Object> result = demoClient.startProcess(processStartDTO);
        if((int)result.get("code") != 0) {
            throw new RuntimeException("信息错误");
        }
        return result.get("taskTitle").toString();
    }

    @Override
    public String complete(ProcessHandleDTO processHandleDTO) {
        HashMap<String,Object> result = demoClient.completeProcess(processHandleDTO);
        if((int)result.get("code") != 0) {
            throw new RuntimeException("信息错误");
        }
        return result.get("msg").toString();
    }

    @Override
    public HashMap<String, Object> getSpeed(String taskId) {
        HashMap<String,Object> result = demoClient.getTaskSpeed(taskId);
        if((int)result.get("code") != 0) {
            throw new RuntimeException("信息错误");
        }
        return result;
    }
}
