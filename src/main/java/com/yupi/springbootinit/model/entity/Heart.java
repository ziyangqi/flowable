package com.yupi.springbootinit.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName heart
 */
@TableName(value ="heart")
@Data
public class Heart implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 心跳速率
     */
    private Long heartRate;

    /**
     * 呼吸速率
     */
    private Long breathRate;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建者
     */
    private String createUser;


    private Long isDelete;

    private Long isHigh;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Heart other = (Heart) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getHeartRate() == null ? other.getHeartRate() == null : this.getHeartRate().equals(other.getHeartRate()))
            && (this.getBreathRate() == null ? other.getBreathRate() == null : this.getBreathRate().equals(other.getBreathRate()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
                &&(this.getIsHigh() == null ? other.getIsHigh() == null : this.getIsHigh().equals(other.getIsHigh()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getHeartRate() == null) ? 0 : getHeartRate().hashCode());
        result = prime * result + ((getBreathRate() == null) ? 0 : getBreathRate().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getIsHigh() == null) ? 0 : getIsHigh().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", heartRate=").append(heartRate);
        sb.append(", breathRate=").append(breathRate);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUser=").append(createUser);
        sb.append(", isHigh=").append(isHigh);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}