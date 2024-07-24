package com.yupi.springbootinit.openFegin;

import com.yupi.springbootinit.model.entity.LoginForm;
import com.yupi.springbootinit.openFegin.RemoteServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;

@Service
public class MyService {

    @Autowired
    private RemoteServiceClient remoteServiceClient;

    public R callRemoteService(LoginForm loginForm) {
        String token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ7XCJhY2NvdW50XCI6XCJ5eWhcIixcImlkXCI6XCIxMTExMTExMTExMTExMVwiLFwidGVuYW50SWRcIjpcInpoeXdcIixcInVzZXJOb1wiOlwiemh5dzExNDUxNFwifSIsImV4cCI6MTcyMjMzMDM5N30.DUsxD8spAlVbcRx2FCtjRvlIJnrdXZxF0KNtblR62_t90xipCosaWj50IlDDw4nEL3n81NWvptB_3dQHMlYMoA";
        return remoteServiceClient.getJwt(loginForm, token);
    }
}
