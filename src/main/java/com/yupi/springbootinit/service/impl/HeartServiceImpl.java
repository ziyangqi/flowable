package com.yupi.springbootinit.service.impl;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.springbootinit.common.ErrorCode;
import com.yupi.springbootinit.exception.BusinessException;
import com.yupi.springbootinit.mapper.HeartMapper;
import com.yupi.springbootinit.model.dto.heart.HeartQueryRequest;
import com.yupi.springbootinit.model.entity.Heart;
import com.yupi.springbootinit.model.entity.User;
import com.yupi.springbootinit.service.HeartService;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

/**
* @author 114514191980
* @description 针对表【heart】的数据库操作Service实现
* @createDate 2024-07-09 14:56:05
*/
@Service
public class HeartServiceImpl extends ServiceImpl<HeartMapper, Heart>
    implements HeartService {



    public QueryWrapper<Heart> getQueryWrapper(HeartQueryRequest heartQueryRequest) {
        if (heartQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        // 五个数据字段
        Integer heartRate = heartQueryRequest.getHeartRate();
        String createUser = heartQueryRequest.getCreateUser();
        Date createDate = heartQueryRequest.getCreateDate();
        Date startTime = heartQueryRequest.getStartTime();
        Date endTime = heartQueryRequest.getEndTime();
        Integer breathRate = heartQueryRequest.getBreathRate();
        Integer isHigh = heartQueryRequest.getIsHigh();
        QueryWrapper<Heart> queryWrapper = new QueryWrapper<>();
        //queryWrapper.eq(id!=null, "id", id);
        queryWrapper.eq(heartRate!=null, "heartRate", heartRate);
        queryWrapper.eq(StringUtils.isNotBlank(createUser), "createUser", createUser);
        queryWrapper.eq(breathRate != null, "breathRate", breathRate);
        queryWrapper.eq(isHigh!=null,"isHigh",isHigh);
        queryWrapper.between(startTime!=null || endTime!=null, "createDate",startTime,endTime);

        return queryWrapper;
    }

}




