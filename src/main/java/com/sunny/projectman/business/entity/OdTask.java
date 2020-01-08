package com.sunny.projectman.business.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import java.util.Date;
import lombok.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 任务
 * @author lgwang
 * @since 2019-12-31
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("OD_TASK")
@ApiModel(value="OdTask对象", description="任务")
public class OdTask extends Model<OdTask> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "ID", type = IdType.AUTO)
    private BigDecimal id;

    @ApiModelProperty(value = "项目id")
    @TableField("PROJECT_ID")
    private BigDecimal projectId;

    @ApiModelProperty(value = "任务类型")
    @TableField("TASK_TYPE")
    private String taskType;

    @ApiModelProperty(value = "任务编号")
    @TableField("TASK_CODE")
    private String taskCode;

    @ApiModelProperty(value = "任务标题")
    @TableField("TASK_TITLE")
    private String taskTitle;

    @ApiModelProperty(value = "需求id")
    @TableField("XUQIU_ID")
    private BigDecimal xuqiuId;

    @ApiModelProperty(value = "源单据号")
    @TableField("SOURCE_CODE")
    private String sourceCode;

    @ApiModelProperty(value = "计划开始时间")
    @TableField("PLAN_BEGIN_TIME")
    private Date planBeginTime;

    @ApiModelProperty(value = "计划结束时间")
    @TableField("PLAN_END_TIME")
    private Date planEndTime;

    @ApiModelProperty(value = "计划发布时间")
    @TableField("PLAN_ISSUE_DATE")
    private Date planIssueDate;

    @ApiModelProperty(value = "实际发布时间")
    @TableField("ISSUE_DATE")
    private Date issueDate;

    @ApiModelProperty(value = "上级任务id")
    @TableField("PARENT_TASK")
    private BigDecimal parentTask;

    @ApiModelProperty(value = "状态")
    @TableField("STATUS")
    private String status;

    @ApiModelProperty(value = "负责人")
    @TableField("MANAGER")
    private String manager;

    @ApiModelProperty(value = "标签")
    @TableField("TAGS")
    private String tags;

    @ApiModelProperty(value = "描述")
    @TableField("DESCRIBE")
    private String describe;

    @ApiModelProperty(value = "是否有效")
    @TableField("VALID")
    private String valid;

    @ApiModelProperty(value = "创建人")
    @TableField("CREATOR")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_TIME")
    private Date createTime;

    @ApiModelProperty(value = "资源id")
    @TableField("SOURCE_ID")
    private BigDecimal sourceId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
