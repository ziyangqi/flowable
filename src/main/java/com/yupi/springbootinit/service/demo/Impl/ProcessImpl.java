package com.yupi.springbootinit.service.demo.Impl;

import com.yupi.springbootinit.client.DemoClient;
import com.yupi.springbootinit.common.BaseResponse;
import com.yupi.springbootinit.model.dto.process.ProcessListQuery;
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
    public List getProcessList(ProcessListQuery processListQuery) {
        HashMap<String, Object> result = demoClient.getProcessList(processListQuery);
        if((int)result.get("code") == 200) {
            System.out.println(result.get("code"));
            return null;
        }
        List<Object> list = (List<Object>) result.get("data");
        return list;
    }
}
