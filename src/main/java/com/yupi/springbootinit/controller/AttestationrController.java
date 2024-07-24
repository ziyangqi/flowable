package com.yupi.springbootinit.controller;

import com.yupi.springbootinit.common.BaseResponse;
import com.yupi.springbootinit.common.ErrorCode;
import com.yupi.springbootinit.common.FlowableProperties;
import com.yupi.springbootinit.common.ResultUtils;
import com.yupi.springbootinit.exception.ThrowUtils;
import com.yupi.springbootinit.model.dto.attestationr.AttestationrQueryRequest;
import com.yupi.springbootinit.model.entity.Attestationr;
import com.yupi.springbootinit.model.entity.LoginForm;
import com.yupi.springbootinit.model.vo.BiResponse;
import com.yupi.springbootinit.openFegin.MyService;
import com.yupi.springbootinit.openFegin.R;
import com.yupi.springbootinit.service.AttestationrService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 认证的controller
 */

@RestController
@RequestMapping("/prove")
@Slf4j
public class AttestationrController {


    @Resource
    MyService myService;

    // 获取applicantion.yml中的内容
    private final FlowableProperties flowableProperties;
    @Resource
    AttestationrService attestationrService;

    @Autowired
    public AttestationrController(FlowableProperties flowableProperties) {
        this.flowableProperties = flowableProperties;
    }

    /**
     * 根据userid进行查询后，来进行判断其内容是否正确，是存在于数据库的表格中
     */
    @PostMapping("/attestation/byId")
    public BaseResponse<Attestationr> getAttestationByUserId(AttestationrQueryRequest attestationrQueryRequest){
        String userId = attestationrQueryRequest.getUserId();
        ThrowUtils.throwIf(StringUtils.isEmpty(userId), ErrorCode.PARAMS_ERROR, "用户id为空");
        // 根据id获取对象
        Attestationr attestationr = attestationrService.getById(userId);
        // 获取密匙和id后续获取本地的数据库中的userId
        String secret = flowableProperties.getSecret();
        String appid = flowableProperties.getAppid();
        String  localSecret = attestationr.getSecret();
        String localAppid = attestationr.getAppid();
        // 调用service层的内容比如进行身份的验证根据返回的结果来进行获得
        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("yyh");
        loginForm.setPassword("123456");
        R r = myService.callRemoteService(loginForm);
        if (r.get("msg").equals("操作成功")) {
            return ResultUtils.successFlowable(attestationr);
        }

//        数据的判断比对
//        ThrowUtils.throwIf(StringUtils.isEmpty(localSecret), ErrorCode.PARAMS_ERROR, "本地密匙为空");
//        ThrowUtils.throwIf(StringUtils.isEmpty(localAppid), ErrorCode.PARAMS_ERROR, "本地应用id为空");
//        ThrowUtils.throwIf(!Objects.equals(secret, localSecret), ErrorCode.NO_AUTH_ERROR, "您的密匙错误，请重新输入");
//        ThrowUtils.throwIf(!Objects.equals(appid,  localAppid), ErrorCode.NO_AUTH_ERROR, "您的应用ID错误，请重新输入");
        // 返回结果

        return ResultUtils.success(attestationr);

    }


}
