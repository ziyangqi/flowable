package com.yupi.springbootinit.client;

import com.yupi.springbootinit.common.BaseResponse;
import com.yupi.springbootinit.model.dto.process.ProcessListQuery;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import javax.websocket.ClientEndpoint;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@FeignClient(name = "engine",url = "localhost:10086/fastflow-admin")
public interface DemoClient {
    @PostMapping(value = "/a1bpmn/api/models/listJson",headers = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ7XCJhY2NvdW50XCI6XCJ5eWhcIixcImlkXCI6XCIxMTExMTExMTExMTExMVwiLFwidGVuYW50SWRcIjpcInpoeXdcIixcInVzZXJOb1wiOlwiemh5dzExNDUxNFwifSIsImV4cCI6MTcyMjQwODA4NH0.V1x3JpQA__SOrj8Ev5dnd1fHPo_EyyNqkPjTrhMaPtXAmUqrZTfQ3UGME90djoYVufpJgSb8L2c4xNHygjfBKQ")
    HashMap<String, Object> getProcessList(ProcessListQuery processListQuery);
}
