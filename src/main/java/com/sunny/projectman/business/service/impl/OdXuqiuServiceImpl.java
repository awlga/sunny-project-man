package com.sunny.projectman.business.service.impl;

import com.sunny.projectman.business.entity.OdXuqiu;
import com.sunny.projectman.business.mapper.OdXuqiuMapper;
import com.sunny.projectman.business.service.IOdXuqiuService;
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
 * 需求 服务实现类
 *
 * @author lgwang
 * @since 2019-12-31
 */
@Service
@Slf4j
public class OdXuqiuServiceImpl extends ServiceImpl<OdXuqiuMapper, OdXuqiu> implements IOdXuqiuService {
    @Override
    public IPage<OdXuqiu> page(Page<OdXuqiu> page, OdXuqiu odXuqiu) {
        QueryWrapper queryWrapper = new QueryWrapper();
        QueryGenerator.installMplus(queryWrapper, odXuqiu, null);
        return baseMapper.selectPage(page, queryWrapper);
    }

    @Override
    public boolean save(OdXuqiu entity) {
        return super.save(entity);
    }

    @Override
    public boolean updateById(OdXuqiu entity) {
        OdXuqiu odXuqiu = super.getById(entity.getId());
        if (odXuqiu == null) {
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
    public OdXuqiu getById(Serializable id) {
        OdXuqiu odXuqiu = super.getById(id);
        if (odXuqiu==null) {
            throw new RuntimeException("未找到对应实体");
        }
        return odXuqiu;
    }

}
