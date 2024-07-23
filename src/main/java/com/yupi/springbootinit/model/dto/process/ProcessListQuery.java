package com.yupi.springbootinit.model.dto.process;

import lombok.Data;

@Data
public class ProcessListQuery {
    private String modelKey;
    private String type;
    private String page;
    private String limit;
}
