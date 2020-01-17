package com.sunny.projectman.business.service;

import com.sunny.projectman.business.entity.OdTeam;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
/**
 * <p>
 * 团队 服务类
 * </p>
 *
 * @author lgwang
 * @since 2020-01-17
 */
public interface IOdTeamService extends IService<OdTeam> {
    IPage<OdTeam> page(Page<OdTeam> page, OdTeam odTeam);

    @Override
    boolean save(OdTeam odTeam) ;

    @Override
    boolean updateById(OdTeam odTeam);

    boolean removeByIds(String idList);

    @Override
    OdTeam getById(Serializable id);

}
