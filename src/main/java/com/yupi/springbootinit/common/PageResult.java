package com.yupi.springbootinit.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class PageResult {
    private Integer count;
    private List list;
    public static PageResult create(Integer count,List list) {
        PageResult pageResult = new PageResult(count,list);
        return pageResult;
    }
}
