package com.sunny.projectman.business.dto;


import com.sunny.projectman.business.entity.OdXuqiu;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author lgwang
 * @since 2019-12-24
 */
@Data
@Accessors(chain = true)
public class OdXuqiuDTO {
    private OdXuqiu odXuqiu;
    private Integer pageNo;
    private Integer pageSize;
}