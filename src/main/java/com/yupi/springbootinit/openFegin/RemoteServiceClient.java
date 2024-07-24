package com.yupi.springbootinit.openFegin;

import com.yupi.springbootinit.model.entity.LoginForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "remoteService", url = "http://127.0.0.1:10086/fastflow-admin/")
public interface RemoteServiceClient {

    @PostMapping("/sys/getJwt")
    R getJwt(@RequestBody LoginForm loginForm, @RequestHeader("token") String token);


}
