package com.sunny.projectman.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunny.projectman.business.entity.OdXuqiu;
import com.sunny.projectman.business.mapper.OdXuqiuMapper;
import com.sunny.projectman.business.service.IOdXuqiuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunny.projectman.common.QueryGenerator;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lgwang
 * @since 2019-12-24
 */
@Service
public class OdXuqiuServiceImpl extends ServiceImpl<OdXuqiuMapper, OdXuqiu> implements IOdXuqiuService {

    @Override
    public IPage<OdXuqiu> page(Page<OdXuqiu> page, OdXuqiu odXuqiu) {
        QueryWrapper queryWrapper = new QueryWrapper();
        QueryGenerator.installMplus(queryWrapper, odXuqiu, null);
        return baseMapper.selectPage(page, queryWrapper);
    }
}
