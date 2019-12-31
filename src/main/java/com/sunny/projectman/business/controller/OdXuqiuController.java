package com.sunny.projectman.business.controller;
import com.sunny.projectman.business.dto.OdXuqiuDTO;
import com.sunny.projectman.business.entity.OdXuqiu;
import com.sunny.projectman.business.service.IOdXuqiuService;

import com.sunny.projectman.common.Result;
import com.sunny.projectman.common.asspect.annotation.AutoLog;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RestController;

/**
 * 需求 前端控制器
 *
 * @author lgwang
 * @since 2019-12-31
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

    /**
    * 添加
    *
    * @param odXuqiu
    * @return
    */
    @AutoLog(value = "需求-添加")
    @ApiOperation(value = "需求-添加", notes = "需求-添加")
    @PostMapping(value = "/add")
    public Result<OdXuqiu> add(@RequestBody OdXuqiu odXuqiu) {
        Result<OdXuqiu> result = new Result<OdXuqiu>();
        boolean save = odXuqiuService.save(odXuqiu);
        if (save) {
            result.success("添加成功！");
        } else {
            result.error500("操作失败");
        }
        return result;
    }

    /**
    * 编辑
    *
    * @param odXuqiu
    * @return
    */
    @AutoLog(value = "需求-编辑")
    @ApiOperation(value = "需求-编辑", notes = "需求-编辑")
    @PutMapping(value = "/edit")
    public Result<OdXuqiu> edit(@RequestBody OdXuqiu odXuqiu) {
        Result<OdXuqiu> result = new Result<OdXuqiu>();
        boolean update = odXuqiuService.updateById(odXuqiu);
        if (update) {
            result.success("添加成功！");
        } else {
            result.error500("操作失败");
        }
        return result;
    }

    /**
    * 通过id删除
    *
    * @param id
    * @return
    */
    @AutoLog(value = "需求-通过id删除")
    @ApiOperation(value = "需求-通过id删除", notes = "需求-通过id删除")
    @DeleteMapping(value = "/delete")
    public Result<?> delete(@RequestParam(name = "id", required = true) String id) {
    Result<OdXuqiu> result = new Result<OdXuqiu>();
        boolean remove = odXuqiuService.removeById(id);
        if (remove) {
            result.success("删除成功！");
        } else {
            result.error500("删除失败");
        }
        return result;
    }

    /**
    * 批量删除
    *
    * @param ids
    * @return
    */
    @AutoLog(value = "需求-批量删除")
    @ApiOperation(value = "需求-批量删除", notes = "需求-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    public Result<OdXuqiu> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        Result<OdXuqiu> result = new Result<OdXuqiu>();
        boolean remove = odXuqiuService.removeByIds(ids);
        if (remove) {
            result.success("删除成功！");
        } else {
            result.error500("删除失败");
        }
        return result;
    }
    /**
    * 通过id查询
    *
    * @param id
    * @return
    */
    @ApiOperation(value = "需求-通过id查询", notes = "需求-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<OdXuqiu> queryById(@RequestParam(name = "id", required = true) String id) {
        Result<OdXuqiu> result = new Result<OdXuqiu>();
        OdXuqiu odXuqiu = odXuqiuService.getById(id);
        result.setResult(odXuqiu);
        result.setSuccess(true);
        return result;
    }

}
