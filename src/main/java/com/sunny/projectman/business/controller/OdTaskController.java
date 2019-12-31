package com.sunny.projectman.business.controller;
import com.sunny.projectman.business.dto.OdTaskDTO;
import com.sunny.projectman.business.entity.OdTask;
import com.sunny.projectman.business.service.IOdTaskService;

import com.sunny.projectman.common.Result;
import com.sunny.projectman.common.asspect.annotation.AutoLog;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RestController;

/**
 * 任务 前端控制器
 *
 * @author lgwang
 * @since 2019-12-31
 */
@RestController
@RequestMapping("/business/odTask")
public class OdTaskController {

    @Autowired
    private IOdTaskService odTaskService;

    /**
    * 分页列表查询
    * @param odTaskDTO
    * @return
    */
    @ApiOperation(value = "任务-分页列表查询", notes = "任务-分页列表查询")
    @PostMapping(value = "/list")
    public Result<IPage<OdTask>> queryPageList(@RequestBody OdTaskDTO odTaskDTO) {
        Page page = new Page(odTaskDTO.getPageNo(), odTaskDTO.getPageSize());
        IPage page1 = odTaskService.page(page, odTaskDTO.getOdTask());
        Result<IPage<OdTask>> result = new Result<IPage<OdTask>>();
        result.setSuccess(true);
        result.setResult(page1);
        return result;
    }

    /**
    * 添加
    *
    * @param odTask
    * @return
    */
    @AutoLog(value = "任务-添加")
    @ApiOperation(value = "任务-添加", notes = "任务-添加")
    @PostMapping(value = "/add")
    public Result<OdTask> add(@RequestBody OdTask odTask) {
        Result<OdTask> result = new Result<OdTask>();
        boolean save = odTaskService.save(odTask);
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
    * @param odTask
    * @return
    */
    @AutoLog(value = "任务-编辑")
    @ApiOperation(value = "任务-编辑", notes = "任务-编辑")
    @PutMapping(value = "/edit")
    public Result<OdTask> edit(@RequestBody OdTask odTask) {
        Result<OdTask> result = new Result<OdTask>();
        boolean update = odTaskService.updateById(odTask);
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
    @AutoLog(value = "任务-通过id删除")
    @ApiOperation(value = "任务-通过id删除", notes = "任务-通过id删除")
    @DeleteMapping(value = "/delete")
    public Result<?> delete(@RequestParam(name = "id", required = true) String id) {
    Result<OdTask> result = new Result<OdTask>();
        boolean remove = odTaskService.removeById(id);
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
    @AutoLog(value = "任务-批量删除")
    @ApiOperation(value = "任务-批量删除", notes = "任务-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    public Result<OdTask> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        Result<OdTask> result = new Result<OdTask>();
        boolean remove = odTaskService.removeByIds(ids);
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
    @ApiOperation(value = "任务-通过id查询", notes = "任务-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<OdTask> queryById(@RequestParam(name = "id", required = true) String id) {
        Result<OdTask> result = new Result<OdTask>();
        OdTask odTask = odTaskService.getById(id);
        result.setResult(odTask);
        result.setSuccess(true);
        return result;
    }

}
