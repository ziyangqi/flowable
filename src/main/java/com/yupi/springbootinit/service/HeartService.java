package com.yupi.springbootinit.service;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.springbootinit.model.dto.heart.HeartQueryRequest;
import com.yupi.springbootinit.model.entity.Heart;

/**
* @author 114514191980
* @description 针对表【heart】的数据库操作Service
* @createDate 2024-07-09 14:56:05
*/
public interface HeartService extends IService<Heart> {

    Wrapper<Heart> getQueryWrapper(HeartQueryRequest heartQueryRequest);



}
