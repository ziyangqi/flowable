package com.yupi.springbootinit.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.StringUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * copy 流程引擎系统的内容TodoTask的实体作为传参。
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "待办查询参数", description = "待办查询参数")
public class TodoTaskQueryBo  {

    @ApiModelProperty(value = "分类")
    protected String typeKey;
    @ApiModelProperty(value = "关键词")
    protected String keyWord;
    @ApiModelProperty(value = "模型key")
    protected String modelKey;
    @ApiModelProperty(value = "任务标题")
    protected String taskTitle;
    @ApiModelProperty(value = "发起人")
    protected String startUserNo;
    @ApiModelProperty(value = "结束时间")
    private String endTime = null;
    @ApiModelProperty(value = "开始时间")
    private String startTime = null;
    //模型的名称
    @ApiModelProperty(value = "任务key集合")
    private List taskKeyList;
    @ApiModelProperty(value = "流程实例ID集合")
    protected String processInstanceIds;
    @ApiModelProperty(value = "模型ID")
    private String modelId;
    @ApiModelProperty(value = "处理人")
    private String userId;
    @ApiModelProperty(value = "待办类型")
    private String type;
    @ApiModelProperty(value = "业务键")
    private String bizKey;
    @ApiModelProperty(value = "处理人ID")
    private List<String> ids;
    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        if (StringUtils.isBlank(endTime)) {
            this.endTime = null;
        } else {
            this.endTime = endTime;
        }

    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        if (StringUtils.isBlank(startTime)) {
            this.startTime = null;
        } else {
            this.startTime = startTime;
        }

    }

    public String getStartUserNo() {
        return startUserNo;
    }

    public void setStartUserNo(String startUserNo) {
        this.startUserNo = startUserNo;
    }

    public String getProcessInstanceIds() {
        return processInstanceIds;
    }

    public void setProcessInstanceIds(String processInstanceIds) {
        this.processInstanceIds = processInstanceIds;
    }

    public List getTaskKeyList() {
        return taskKeyList;
    }

    public void setTaskKeyList(List taskKeyList) {
        this.taskKeyList = taskKeyList;
    }
}
