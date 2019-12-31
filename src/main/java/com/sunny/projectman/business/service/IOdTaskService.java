package com.sunny.projectman.business.service;

import com.sunny.projectman.business.entity.OdTask;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
/**
 * <p>
 * 任务 服务类
 * </p>
 *
 * @author lgwang
 * @since 2019-12-31
 */
public interface IOdTaskService extends IService<OdTask> {
    IPage<OdTask> page(Page<OdTask> page, OdTask odTask);

    @Override
    boolean save(OdTask odTask) ;

    @Override
    boolean updateById(OdTask odTask);

    boolean removeByIds(String idList);

    @Override
    OdTask getById(Serializable id);

}
