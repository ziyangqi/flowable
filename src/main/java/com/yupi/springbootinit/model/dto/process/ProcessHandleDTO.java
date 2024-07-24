package com.yupi.springbootinit.model.dto.process;

import lombok.Data;

@Data
public class ProcessHandleDTO {
    private String taskId;
    private String opinion;
    private String option;
    private String actionName;
    private String chooseNodeUser;
    private String chooseNode;
    private String taskTitle;
    private String formData;
}
