package com.sunny.projectman.business.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("OD_FILE")
@ApiModel(value="文件实体类", description="")
public class OdFile extends Model<OdXuqiu> {
    private static final long serialVersionUID = 1L;

    @TableId(value = "ID",type = IdType.AUTO)
    @ApiModelProperty(value = "主键ID")
    private BigDecimal id;

    @TableField("ODTYPE")
    @ApiModelProperty(value = "文件类型")
    private String type;

    @TableField("ODSIZE")
    @ApiModelProperty("文件大小")
    private String size;

    @TableField("ODUPDATETIME")
    @ApiModelProperty("文件的更新时时间")
    private Date updateTime;

    @TableField("ODCREATER")
    @ApiModelProperty("文件创建者")
    private String creater;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

