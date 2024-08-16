package com.yupi.springbootinit.openFegin;

import com.yupi.springbootinit.model.entity.LoginForm;
import com.yupi.springbootinit.model.entity.TodoTaskQueryBo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "remoteService", url = "http://127.0.0.1:10086/fastflow-admin/")
public interface RemoteServiceClient {

    @PostMapping("/sys/getJwt")
    R getJwt(@RequestBody LoginForm loginForm, @RequestHeader("token") String token);


    /**
     * 获取废弃接口
     * @param taskId 工程id
     * @param option 意见
     * @param token  标记
     * @return
     */
    @GetMapping("/a1bpmn/api/history/task/v1/invalid/{taskId}")
    R getInvalid(@PathVariable String taskId, @RequestParam("option") String option ,@RequestHeader("token") String token);


    /**
     * 获取流程代办内容
     *
     * @param todoTaskQueryBo       工作的实体
     * @param token                 请求头
     * @param
     * @return
     */
    @RequestMapping ("/a1bpmn/api/runtime/task/v2/list")
    R getTodoTaskList(@RequestBody TodoTaskQueryBo todoTaskQueryBo, @RequestHeader("token") String token, @RequestParam String limit, @RequestParam String page);
}
