package com.sunny.projectman.business.service;

import com.sunny.projectman.business.entity.OdTeamMembers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
/**
 * <p>
 * 团队成员 服务类
 * </p>
 *
 * @author lgwang
 * @since 2020-01-17
 */
public interface IOdTeamMembersService extends IService<OdTeamMembers> {
    IPage<OdTeamMembers> page(Page<OdTeamMembers> page, OdTeamMembers odTeamMembers);

    @Override
    boolean save(OdTeamMembers odTeamMembers) ;

    @Override
    boolean updateById(OdTeamMembers odTeamMembers);

    boolean removeByIds(String idList);

    @Override
    OdTeamMembers getById(Serializable id);

}
