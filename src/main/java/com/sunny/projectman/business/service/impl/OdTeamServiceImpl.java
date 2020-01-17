package com.sunny.projectman.business.service.impl;

import com.sunny.projectman.business.entity.OdTeam;
import com.sunny.projectman.business.mapper.OdTeamMapper;
import com.sunny.projectman.business.service.IOdTeamService;
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
 * 团队 服务实现类
 *
 * @author lgwang
 * @since 2020-01-17
 */
@Service
@Slf4j
public class OdTeamServiceImpl extends ServiceImpl<OdTeamMapper, OdTeam> implements IOdTeamService {
    @Override
    public IPage<OdTeam> page(Page<OdTeam> page, OdTeam odTeam) {
        QueryWrapper queryWrapper = new QueryWrapper();
        QueryGenerator.installMplus(queryWrapper, odTeam, null);
        return baseMapper.selectPage(page, queryWrapper);
    }

    @Override
    public boolean save(OdTeam entity) {
        return super.save(entity);
    }

    @Override
    public boolean updateById(OdTeam entity) {
        OdTeam odTeam = super.getById(entity.getId());
        if (odTeam == null) {
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
    public OdTeam getById(Serializable id) {
        OdTeam odTeam = super.getById(id);
        if (odTeam==null) {
            throw new RuntimeException("未找到对应实体");
        }
        return odTeam;
    }

}
