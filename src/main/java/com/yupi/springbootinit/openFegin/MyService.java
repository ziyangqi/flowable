package com.yupi.springbootinit.openFegin;

import com.yupi.springbootinit.model.entity.LoginForm;
import com.yupi.springbootinit.model.entity.TodoTaskQueryBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    private RemoteServiceClient remoteServiceClient;

    // token
    private static final String token =  "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ7XCJhY2NvdW50XCI6XCJ5eWhcIixcImlkXCI6XCIxMTExMTExMTExMTExMVwiLFwidGVuYW50SWRcIjpcInpoeXdcIixcInVzZXJOb1wiOlwiemh5dzExNDUxNFwifSIsImV4cCI6MTcyMjMzMDM5N30.DUsxD8spAlVbcRx2FCtjRvlIJnrdXZxF0KNtblR62_t90xipCosaWj50IlDDw4nEL3n81NWvptB_3dQHMlYMoA";
    public R callRemoteService(LoginForm loginForm) {
        return remoteServiceClient.getJwt(loginForm, token);
    }


    /**
     * 废弃接口
     * @param taskId
     * @return
     */
    public R callRemoteServiceInvalid(String taskId,String option) {
        return remoteServiceClient.getInvalid(taskId,option,token);
    }

    /**
     * 流程代办
     * @param todoTaskQueryBo 工作实体
     * @return
     */
    public R callRemoteServiceList2(TodoTaskQueryBo todoTaskQueryBo,String limit, String page) {
        return remoteServiceClient.getTodoTaskList(todoTaskQueryBo,token,limit,page);
    }

}
