package com.sunny.projectman.business.dto;

import com.sunny.projectman.business.entity.OdXuqiu;
import lombok.Data;
import lombok.Builder;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * @author lgwang
 * @since 2019-12-31
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OdXuqiuDTO {
    private OdXuqiu odXuqiu =new OdXuqiu();
    private Integer pageNo = 1;
    private Integer pageSize = 10;
}
