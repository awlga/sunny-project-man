package com.sunny.projectman.business.dto;

import com.sunny.projectman.business.entity.OdTask;
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
public class OdTaskDTO {
    private OdTask odTask;
    private Integer pageNo;
    private Integer pageSize;
}
