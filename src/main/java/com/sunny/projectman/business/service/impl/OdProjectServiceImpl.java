package com.sunny.projectman.business.service.impl;

import com.sunny.projectman.business.entity.OdProject;
import com.sunny.projectman.business.mapper.OdProjectMapper;
import com.sunny.projectman.business.service.IOdProjectService;
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
 * 项目 服务实现类
 *
 * @author lgwang
 * @since 2019-12-31
 */
@Service
@Slf4j
public class OdProjectServiceImpl extends ServiceImpl<OdProjectMapper, OdProject> implements IOdProjectService {
    @Override
    public IPage<OdProject> page(Page<OdProject> page, OdProject odProject) {
        QueryWrapper queryWrapper = new QueryWrapper();
        QueryGenerator.installMplus(queryWrapper, odProject, null);
        return baseMapper.selectPage(page, queryWrapper);
    }

    @Override
    public boolean save(OdProject entity) {
        return super.save(entity);
    }

    @Override
    public boolean updateById(OdProject entity) {
        OdProject odProject = super.getById(entity.getId());
        if (odProject == null) {
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
    public OdProject getById(Serializable id) {
        OdProject odProject = super.getById(id);
        if (odProject==null) {
            throw new RuntimeException("未找到对应实体");
        }
        return odProject;
    }

}
