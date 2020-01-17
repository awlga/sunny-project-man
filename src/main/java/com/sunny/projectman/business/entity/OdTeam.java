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
 * 团队
 * @author lgwang
 * @since 2020-01-17
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("OD_TEAM")
@ApiModel(value="OdTeam对象", description="团队")
public class OdTeam extends Model<OdTeam> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "ID", type = IdType.AUTO)
    private BigDecimal id;

    @ApiModelProperty(value = "团队名称")
    @TableField("TEAMNAME")
    private String teamname;

    @ApiModelProperty(value = "团队描述")
    @TableField("TEAMDESC")
    private String teamdesc;

    @ApiModelProperty(value = "团队长")
    @TableField("LEADER")
    private String leader;

    @ApiModelProperty(value = "创建人")
    @TableField("CREATOR")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATETIME")
    private Date createtime;

    @ApiModelProperty(value = "更改人")
    @TableField("UPDATOR")
    private String updator;

    @ApiModelProperty(value = "更改时间")
    @TableField("UPDATETIME")
    private Date updatetime;

    @ApiModelProperty(value = "上级团队id")
    @TableField("PARENTTEAM")
    private BigDecimal parentteam;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
