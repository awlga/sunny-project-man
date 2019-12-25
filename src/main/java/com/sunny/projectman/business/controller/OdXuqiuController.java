package com.sunny.projectman.business.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sunny.projectman.business.dto.OdXuqiuDTO;
import com.sunny.projectman.business.entity.OdXuqiu;
import com.sunny.projectman.business.service.IOdXuqiuService;
import com.sunny.projectman.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lgwang
 * @since 2019-12-24
 */
@RestController
@RequestMapping("/business/odXuqiu")
public class OdXuqiuController {

    @Autowired
    private IOdXuqiuService odXuqiuService;

    /**
     * 分页列表查询
     * @param odXuqiuDTO
     * @return
     */
    @ApiOperation(value = "需求-分页列表查询", notes = "需求-分页列表查询")
    @PostMapping(value = "/list")
    public Result<IPage<OdXuqiu>> queryPageList(@RequestBody OdXuqiuDTO odXuqiuDTO) {
        Page page = new Page(odXuqiuDTO.getPageNo(), odXuqiuDTO.getPageSize());
        IPage page1 = odXuqiuService.page(page, odXuqiuDTO.getOdXuqiu());
        Result<IPage<OdXuqiu>> result = new Result<IPage<OdXuqiu>>();
        result.setSuccess(true);
        result.setResult(page1);
        return result;
    }
}
