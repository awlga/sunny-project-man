package com.sunny.projectman.business.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author lgwang
 * @since 2019-12-24
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("OD_XUQIU")
@ApiModel(value="OdXuqiu对象", description="")
public class OdXuqiu extends Model<OdXuqiu> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private BigDecimal id;

    @ApiModelProperty(value = "需求编号")
    @TableField("XQBH")
    private String xqbh;

    @ApiModelProperty(value = "标题")
    @TableField("BIAOTI")
    private String biaoti;

    @ApiModelProperty(value = "OA流程单号")
    @TableField("OADJ")
    private String oadj;

    @ApiModelProperty(value = "业务系统")
    @TableField("YWXT")
    private String ywxt;

    @ApiModelProperty(value = "申请公司")
    @TableField("GONGSI")
    private String gongsi;

    @ApiModelProperty(value = "申请人")
    @TableField("SQR")
    private String sqr;

    @ApiModelProperty(value = "申请日期")
    @TableField("SQRQ")
    private Date sqrq;

    @ApiModelProperty(value = "创建日期")
    @TableField("CJRQ")
    private Date cjrq;

    @ApiModelProperty(value = "任务")
    @TableField("RENWU")
    private String renwu;

    @ApiModelProperty(value = "是否有效")
    @TableField("SFYX")
    private String sfyx;

    @ApiModelProperty(value = "描述")
    @TableField("CDESC")
    private String cdesc;

    @ApiModelProperty(value = "资源id")
    @TableField("SOURCEID")
    private BigDecimal sourceid;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
