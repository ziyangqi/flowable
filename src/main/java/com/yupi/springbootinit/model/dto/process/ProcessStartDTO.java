package com.yupi.springbootinit.model.dto.process;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ProcessStartDTO {
    private String defId;
    private String defKey;
    private String formData;
    private String groupId;
    private String modelId;
    @JsonIgnore
    private String nodeInfos;
}
