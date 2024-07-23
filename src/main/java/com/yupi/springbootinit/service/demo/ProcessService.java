package com.yupi.springbootinit.service.demo;

import com.yupi.springbootinit.model.dto.process.ProcessListQuery;

import java.util.List;

public interface ProcessService {
    List getProcessList(ProcessListQuery processListQuery);
}
