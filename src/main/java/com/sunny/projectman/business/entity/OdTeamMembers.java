package com.sunny.projectman.business.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * 团队成员
 * @author lgwang
 * @since 2020-01-17
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("OD_TEAM_MEMBERS")
@ApiModel(value="OdTeamMembers对象", description="团队成员")
public class OdTeamMembers extends Model<OdTeamMembers> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "ID", type = IdType.AUTO)
    private BigDecimal id;

    @ApiModelProperty(value = "团队id")
    @TableField("TEAMID")
    private BigDecimal teamid;

    @ApiModelProperty(value = "成员名称")
    @TableField("MEMBERNAME")
    private String membername;

    @ApiModelProperty(value = "成员角色")
    @TableField("ROLE")
    private String role;

    @ApiModelProperty(value = "成员编号")
    @TableField("MEMBERCODE")
    private String membercode;

    @ApiModelProperty(value = "用户id")
    @TableField("USERID")
    private BigDecimal userid;

    @ApiModelProperty(value = "邮箱")
    @TableField("EMAIL")
    private String email;

    @ApiModelProperty(value = "联系方式")
    @TableField("CONTACT")
    private String contact;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
