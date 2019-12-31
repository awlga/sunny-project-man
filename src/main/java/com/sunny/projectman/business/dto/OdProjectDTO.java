package com.sunny.projectman.business.dto;

import com.sunny.projectman.business.entity.OdProject;
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
public class OdProjectDTO {
    private OdProject odProject;
    private Integer pageNo;
    private Integer pageSize;
}
