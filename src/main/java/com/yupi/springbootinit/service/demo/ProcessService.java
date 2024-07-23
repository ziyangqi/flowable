package com.yupi.springbootinit.service.demo;

import com.yupi.springbootinit.common.PageResult;
import com.yupi.springbootinit.model.dto.process.ProcessListQuery;
import com.yupi.springbootinit.model.dto.process.ProcessStartDTO;

import java.util.List;

public interface ProcessService {
    PageResult getProcessList(ProcessListQuery processListQuery);

    String startProcess(ProcessStartDTO processStartDTO);
}
