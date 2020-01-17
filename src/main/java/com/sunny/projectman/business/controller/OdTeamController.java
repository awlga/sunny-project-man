package com.sunny.projectman.business.controller;
import com.sunny.projectman.business.dto.OdTeamDTO;
import com.sunny.projectman.business.entity.OdTeam;
import com.sunny.projectman.business.service.IOdTeamService;

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
 * 团队 前端控制器
 *
 * @author lgwang
 * @since 2020-01-17
 */
@RestController
@Slf4j
@Api(tags = "团队")
@RequestMapping("/business/odTeam")
public class OdTeamController {

    @Autowired
    private IOdTeamService odTeamService;

    /**
    * 分页列表查询
    * @param odTeamDTO
    * @return
    */
    @ApiOperation(value = "团队-分页列表查询", notes = "团队-分页列表查询")
    @PostMapping(value = "/list")
    public Result<IPage<OdTeam>> queryPageList(@RequestBody OdTeamDTO odTeamDTO) {
        Page page = new Page(odTeamDTO.getPageNo(), odTeamDTO.getPageSize());
        IPage page1 = odTeamService.page(page, odTeamDTO.getOdTeam());
        Result<IPage<OdTeam>> result = new Result<IPage<OdTeam>>();
        result.setSuccess(true);
        result.setResult(page1);
        return result;
    }

    /**
    * 添加
    *
    * @param odTeam
    * @return
    */
    @AutoLog(value = "团队-添加")
    @ApiOperation(value = "团队-添加", notes = "团队-添加")
    @PostMapping(value = "/add")
    public Result<OdTeam> add(@RequestBody OdTeam odTeam) {
        Result<OdTeam> result = new Result<OdTeam>();
        boolean save = odTeamService.save(odTeam);
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
    * @param odTeam
    * @return
    */
    @AutoLog(value = "团队-编辑")
    @ApiOperation(value = "团队-编辑", notes = "团队-编辑")
    @PutMapping(value = "/edit")
    public Result<OdTeam> edit(@RequestBody OdTeam odTeam) {
        Result<OdTeam> result = new Result<OdTeam>();
        boolean update = odTeamService.updateById(odTeam);
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
    @AutoLog(value = "团队-通过id删除")
    @ApiOperation(value = "团队-通过id删除", notes = "团队-通过id删除")
    @DeleteMapping(value = "/delete")
    public Result<?> delete(@RequestParam(name = "id", required = true) String id) {
    Result<OdTeam> result = new Result<OdTeam>();
        boolean remove = odTeamService.removeById(id);
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
    @AutoLog(value = "团队-批量删除")
    @ApiOperation(value = "团队-批量删除", notes = "团队-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    public Result<OdTeam> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        Result<OdTeam> result = new Result<OdTeam>();
        boolean remove = odTeamService.removeByIds(ids);
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
    @ApiOperation(value = "团队-通过id查询", notes = "团队-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<OdTeam> queryById(@RequestParam(name = "id", required = true) String id) {
        Result<OdTeam> result = new Result<OdTeam>();
        OdTeam odTeam = odTeamService.getById(id);
        result.setResult(odTeam);
        result.setSuccess(true);
        return result;
    }

}
