package com.yupi.springbootinit.client;

import com.yupi.springbootinit.common.BaseResponse;
import com.yupi.springbootinit.model.dto.process.ProcessListQuery;
import com.yupi.springbootinit.model.dto.process.ProcessStartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.ClientEndpoint;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@FeignClient(name = "engine",url = "http://192.168.30.120:10086/fastflow-admin")
public interface DemoClient {
    @PostMapping(value = "/a1bpmn/api/models/listJson")
    HashMap<String, Object> getProcessList(ProcessListQuery processListQuery);
    @PostMapping(value = "/a1bpmn/api/runtime/instance/v2/start",headers = "Authorization=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ7XCJhY2NvdW50XCI6XCJ6aHl3MDAwMDI1MjBcIixcImZ1bGxuYW1lXCI6XCLokaPmn7PpnZJcIixcImlkXCI6XCJhMGUxZTNhNC03OWEyLTQxMDktOTgzNS0xMWM3OGZkY2M1YzdcIixcInRlbmFudElkXCI6XCJ6aHl3XCIsXCJ1c2VyTm9cIjpcInpoeXcwMDAwMjUyMFwifSIsImV4cCI6MTcyMjA2Mjc4OX0.a8aPocSRAkD0nUpiHeN8g8Th5niedKXaY58WCD0Gt34h9fjmo4Bj99zTGN0DXZd3SPqDK-2y0Kph4yTyyrPZvA")
    HashMap<String, Object> startProcess(ProcessStartDTO processStartDTO);
}
