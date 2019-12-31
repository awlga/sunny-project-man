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
 * 项目
 * @author lgwang
 * @since 2019-12-31
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("OD_PROJECT")
@ApiModel(value="OdProject对象", description="项目")
public class OdProject extends Model<OdProject> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "ID", type = IdType.AUTO)
    private BigDecimal id;

    @ApiModelProperty(value = "项目名称")
    @TableField("PROJECTNAME")
    private String projectname;

    @ApiModelProperty(value = "项目负责人")
    @TableField("HEADER")
    private String header;

    @ApiModelProperty(value = "联系人")
    @TableField("CONTACTOR")
    private String contactor;

    @ApiModelProperty(value = "计划开始时间")
    @TableField("PLAN_BEGIN_TIME")
    private Date planBeginTime;

    @ApiModelProperty(value = "计划结束时间")
    @TableField("PLAN_END_TIME")
    private Date planEndTime;

    @ApiModelProperty(value = "项目描述")
    @TableField("DESCRIBE")
    private String describe;

    @ApiModelProperty(value = "计划发布时间")
    @TableField("PLAN_ISSUE_DATE")
    private Date planIssueDate;

    @ApiModelProperty(value = "实际发布时间")
    @TableField("ISSUE_DATE")
    private Date issueDate;

    @ApiModelProperty(value = "父项目id")
    @TableField("PAR_PROJECT_ID")
    private BigDecimal parProjectId;

    @ApiModelProperty(value = "客户")
    @TableField("CUSTOMER")
    private String customer;

    @ApiModelProperty(value = "创建人")
    @TableField("CREATOR")
    private String creator;

    @ApiModelProperty(value = "修改人")
    @TableField("UPDATER")
    private String updater;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_TIME")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("UPDATE_TIME")
    private Date updateTime;

    @ApiModelProperty(value = "项目编号")
    @TableField("PROJECTCODE")
    private String projectcode;

    @ApiModelProperty(value = "项目状态")
    @TableField("STATUS")
    private String status;

    @ApiModelProperty(value = "需求id")
    @TableField("XUQIU_ID")
    private BigDecimal xuqiuId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
