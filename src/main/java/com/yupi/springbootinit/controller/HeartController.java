package com.yupi.springbootinit.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.springbootinit.annotation.AuthCheck;
import com.yupi.springbootinit.common.BaseResponse;
import com.yupi.springbootinit.common.DeleteRequest;
import com.yupi.springbootinit.common.ErrorCode;
import com.yupi.springbootinit.common.ResultUtils;
import com.yupi.springbootinit.constant.UserConstant;
import com.yupi.springbootinit.exception.BusinessException;
import com.yupi.springbootinit.exception.ThrowUtils;
import com.yupi.springbootinit.model.dto.heart.HeartQueryRequest;
import com.yupi.springbootinit.model.dto.heart.HeartUpdateRequest;
import com.yupi.springbootinit.model.dto.user.UserUpdateMyRequest;
import com.yupi.springbootinit.model.entity.Chart;
import com.yupi.springbootinit.model.entity.Heart;
import com.yupi.springbootinit.model.entity.User;
import com.yupi.springbootinit.service.HeartService;
import com.yupi.springbootinit.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 心跳方面内容的控制层主要是写查询的内
 */
@RestController
@RequestMapping("/heart")
public class HeartController {



    private static final String USERROLEADMIN = "admin";

    @Resource
    UserService userService;
    @Resource
    HeartService heartService;

    /**
     * 分页获取心跳的数据
     *
     * @param heartQueryRequest 前端传送过来的heartQueryRequest内容
     * @param request
     * @return
     */
    @PostMapping("/list/page")
    public BaseResponse<Page<Heart>> listHeartByPage(@RequestBody HeartQueryRequest heartQueryRequest,
                                                     HttpServletRequest request) {
        long current = heartQueryRequest.getCurrent();
        long size = heartQueryRequest.getPageSize();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        Page<Heart> heartPage = heartService.page(new Page<>(current, size),
                heartService.getQueryWrapper(heartQueryRequest));
        return ResultUtils.success(heartPage);
    }


    /**
     * 根据Id进行删除
     * @param id   返回的id
     * @param request
     * @return
     */
    @PostMapping("/deleteById")
    public BaseResponse<Boolean> deleteHeart(@RequestBody long id, HttpServletRequest request) {
        if (id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Heart heart = heartService.getById(id);
        if (id != heart.getId()){
            // 表示请求的数据不存在
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 只可以管理员进行删除，前端已经做过效验后端继续效验防止Sql注入
        if (!userService.isAdmin(request)) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        // 使用heartService进行删除
        boolean b = heartService.removeById(id);
        return ResultUtils.success(b);
    }


    /**
     *
     * @param heartUpdateRequest
     * @param request
     * @return
     */
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    @PostMapping("/updateById")
    public BaseResponse<Boolean> updateMyUser(@RequestBody HeartUpdateRequest heartUpdateRequest,
                                              HttpServletRequest request) {
        if (heartUpdateRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 1 判断登陆的是否是管理员
        User loginUser = userService.getLoginUser(request);
        if (!Objects.equals(loginUser.getUserRole(), USERROLEADMIN)){
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        // 2 创建一个新的对象
        Heart heart = new Heart();
        BeanUtils.copyProperties(heartUpdateRequest, heart);
        // 3 必须SetId
        heart.setId(heartUpdateRequest.getId());
        boolean result = heartService.updateById(heart);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        return ResultUtils.success(true);
    }

}
