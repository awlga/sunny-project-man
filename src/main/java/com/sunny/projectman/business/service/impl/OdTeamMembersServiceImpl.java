package com.sunny.projectman.business.service.impl;

import com.sunny.projectman.business.entity.OdTeamMembers;
import com.sunny.projectman.business.mapper.OdTeamMembersMapper;
import com.sunny.projectman.business.service.IOdTeamMembersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunny.projectman.common.QueryGenerator;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.io.Serializable;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * 团队成员 服务实现类
 *
 * @author lgwang
 * @since 2020-01-17
 */
@Service
@Slf4j
public class OdTeamMembersServiceImpl extends ServiceImpl<OdTeamMembersMapper, OdTeamMembers> implements IOdTeamMembersService {
    @Override
    public IPage<OdTeamMembers> page(Page<OdTeamMembers> page, OdTeamMembers odTeamMembers) {
        QueryWrapper queryWrapper = new QueryWrapper();
        QueryGenerator.installMplus(queryWrapper, odTeamMembers, null);
        return baseMapper.selectPage(page, queryWrapper);
    }

    @Override
    public boolean save(OdTeamMembers entity) {
        return super.save(entity);
    }

    @Override
    public boolean updateById(OdTeamMembers entity) {
        OdTeamMembers odTeamMembers = super.getById(entity.getId());
        if (odTeamMembers == null) {
            throw new RuntimeException("未找到对应实体");
        }
        return super.updateById(entity);
    }

    @Override
    public boolean removeByIds(String idList) {
        if (StrUtil.isBlank(idList)) {
            throw new RuntimeException("参数不识别！");
        }
        return super.removeByIds(Arrays.asList(idList.split(",")));
    }

    @Override
    public OdTeamMembers getById(Serializable id) {
        OdTeamMembers odTeamMembers = super.getById(id);
        if (odTeamMembers==null) {
            throw new RuntimeException("未找到对应实体");
        }
        return odTeamMembers;
    }

}
