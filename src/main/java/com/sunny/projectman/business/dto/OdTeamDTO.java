package com.sunny.projectman.business.dto;

import com.sunny.projectman.business.entity.OdTeam;
import lombok.Data;
import lombok.Builder;
import lombok.experimental.Accessors;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * @author lgwang
 * @since 2020-01-17
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OdTeamDTO {
    private OdTeam odTeam = new OdTeam();
    private Integer pageNo = 1;
    private Integer pageSize = 10;
}
