package com.sunny.projectman.business.service;

import com.sunny.projectman.business.entity.OdProject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
/**
 * <p>
 * 项目 服务类
 * </p>
 *
 * @author lgwang
 * @since 2019-12-31
 */
public interface IOdProjectService extends IService<OdProject> {
    IPage<OdProject> page(Page<OdProject> page, OdProject odProject);

    @Override
    boolean save(OdProject odProject) ;

    @Override
    boolean updateById(OdProject odProject);

    boolean removeByIds(String idList);

    @Override
    OdProject getById(Serializable id);

}
