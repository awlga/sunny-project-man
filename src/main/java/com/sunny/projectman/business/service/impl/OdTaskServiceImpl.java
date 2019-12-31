package com.sunny.projectman.business.service.impl;

import com.sunny.projectman.business.entity.OdTask;
import com.sunny.projectman.business.mapper.OdTaskMapper;
import com.sunny.projectman.business.service.IOdTaskService;
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
 * 任务 服务实现类
 *
 * @author lgwang
 * @since 2019-12-31
 */
@Service
@Slf4j
public class OdTaskServiceImpl extends ServiceImpl<OdTaskMapper, OdTask> implements IOdTaskService {
    @Override
    public IPage<OdTask> page(Page<OdTask> page, OdTask odTask) {
        QueryWrapper queryWrapper = new QueryWrapper();
        QueryGenerator.installMplus(queryWrapper, odTask, null);
        return baseMapper.selectPage(page, queryWrapper);
    }

    @Override
    public boolean save(OdTask entity) {
        return super.save(entity);
    }

    @Override
    public boolean updateById(OdTask entity) {
        OdTask odTask = super.getById(entity.getId());
        if (odTask == null) {
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
    public OdTask getById(Serializable id) {
        OdTask odTask = super.getById(id);
        if (odTask==null) {
            throw new RuntimeException("未找到对应实体");
        }
        return odTask;
    }

}
