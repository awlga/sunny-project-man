package com.sunny.projectman.business.controller;
import com.sunny.projectman.business.dto.OdProjectDTO;
import com.sunny.projectman.business.entity.OdProject;
import com.sunny.projectman.business.service.IOdProjectService;

import com.sunny.projectman.common.Result;
import com.sunny.projectman.common.asspect.annotation.AutoLog;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目 前端控制器
 *
 * @author lgwang
 * @since 2019-12-31
 */
@RestController
@Slf4j
@Api(tags = "项目")
@RequestMapping("/business/odProject")
public class OdProjectController {

    @Autowired
    private IOdProjectService odProjectService;

    /**
    * 分页列表查询
    * @param odProjectDTO
    * @return
    */
    @ApiOperation(value = "项目-分页列表查询", notes = "项目-分页列表查询")
    @PostMapping(value = "/list")
    public Result<IPage<OdProject>> queryPageList(@RequestBody OdProjectDTO odProjectDTO) {
        Page page = new Page(odProjectDTO.getPageNo(), odProjectDTO.getPageSize());
        IPage page1 = odProjectService.page(page, odProjectDTO.getOdProject());
        Result<IPage<OdProject>> result = new Result<IPage<OdProject>>();
        result.setSuccess(true);
        result.setResult(page1);
        return result;
    }

    /**
    * 添加
    *
    * @param odProject
    * @return
    */
    @AutoLog(value = "项目-添加")
    @ApiOperation(value = "项目-添加", notes = "项目-添加")
    @PostMapping(value = "/add")
    public Result<OdProject> add(@RequestBody OdProject odProject) {
        Result<OdProject> result = new Result<OdProject>();
        boolean save = odProjectService.save(odProject);
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
    * @param odProject
    * @return
    */
    @AutoLog(value = "项目-编辑")
    @ApiOperation(value = "项目-编辑", notes = "项目-编辑")
    @PutMapping(value = "/edit")
    public Result<OdProject> edit(@RequestBody OdProject odProject) {
        Result<OdProject> result = new Result<OdProject>();
        boolean update = odProjectService.updateById(odProject);
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
    @AutoLog(value = "项目-通过id删除")
    @ApiOperation(value = "项目-通过id删除", notes = "项目-通过id删除")
    @DeleteMapping(value = "/delete")
    public Result<?> delete(@RequestParam(name = "id", required = true) String id) {
    Result<OdProject> result = new Result<OdProject>();
        boolean remove = odProjectService.removeById(id);
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
    @AutoLog(value = "项目-批量删除")
    @ApiOperation(value = "项目-批量删除", notes = "项目-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    public Result<OdProject> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        Result<OdProject> result = new Result<OdProject>();
        boolean remove = odProjectService.removeByIds(ids);
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
    @ApiOperation(value = "项目-通过id查询", notes = "项目-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<OdProject> queryById(@RequestParam(name = "id", required = true) String id) {
        Result<OdProject> result = new Result<OdProject>();
        OdProject odProject = odProjectService.getById(id);
        result.setResult(odProject);
        result.setSuccess(true);
        return result;
    }

}
