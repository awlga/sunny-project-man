package com.sunny.projectman.business.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunny.projectman.business.entity.OdXuqiu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lgwang
 * @since 2019-12-24
 */
public interface IOdXuqiuService extends IService<OdXuqiu> {
    IPage<OdXuqiu> page(Page<OdXuqiu> page, OdXuqiu odXuqiu);

}
