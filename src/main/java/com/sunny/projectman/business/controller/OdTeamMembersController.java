package com.sunny.projectman.business.controller;
import com.sunny.projectman.business.dto.OdTeamMembersDTO;
import com.sunny.projectman.business.entity.OdTeamMembers;
import com.sunny.projectman.business.service.IOdTeamMembersService;

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
 * 团队成员 前端控制器
 *
 * @author lgwang
 * @since 2020-01-17
 */
@RestController
@Slf4j
@Api(tags = "团队成员")
@RequestMapping("/business/odTeamMembers")
public class OdTeamMembersController {

    @Autowired
    private IOdTeamMembersService odTeamMembersService;

    /**
    * 分页列表查询
    * @param odTeamMembersDTO
    * @return
    */
    @ApiOperation(value = "团队成员-分页列表查询", notes = "团队成员-分页列表查询")
    @PostMapping(value = "/list")
    public Result<IPage<OdTeamMembers>> queryPageList(@RequestBody OdTeamMembersDTO odTeamMembersDTO) {
        Page page = new Page(odTeamMembersDTO.getPageNo(), odTeamMembersDTO.getPageSize());
        IPage page1 = odTeamMembersService.page(page, odTeamMembersDTO.getOdTeamMembers());
        Result<IPage<OdTeamMembers>> result = new Result<IPage<OdTeamMembers>>();
        result.setSuccess(true);
        result.setResult(page1);
        return result;
    }

    /**
    * 添加
    *
    * @param odTeamMembers
    * @return
    */
    @AutoLog(value = "团队成员-添加")
    @ApiOperation(value = "团队成员-添加", notes = "团队成员-添加")
    @PostMapping(value = "/add")
    public Result<OdTeamMembers> add(@RequestBody OdTeamMembers odTeamMembers) {
        Result<OdTeamMembers> result = new Result<OdTeamMembers>();
        boolean save = odTeamMembersService.save(odTeamMembers);
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
    * @param odTeamMembers
    * @return
    */
    @AutoLog(value = "团队成员-编辑")
    @ApiOperation(value = "团队成员-编辑", notes = "团队成员-编辑")
    @PutMapping(value = "/edit")
    public Result<OdTeamMembers> edit(@RequestBody OdTeamMembers odTeamMembers) {
        Result<OdTeamMembers> result = new Result<OdTeamMembers>();
        boolean update = odTeamMembersService.updateById(odTeamMembers);
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
    @AutoLog(value = "团队成员-通过id删除")
    @ApiOperation(value = "团队成员-通过id删除", notes = "团队成员-通过id删除")
    @DeleteMapping(value = "/delete")
    public Result<?> delete(@RequestParam(name = "id", required = true) String id) {
    Result<OdTeamMembers> result = new Result<OdTeamMembers>();
        boolean remove = odTeamMembersService.removeById(id);
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
    @AutoLog(value = "团队成员-批量删除")
    @ApiOperation(value = "团队成员-批量删除", notes = "团队成员-批量删除")
    @DeleteMapping(value = "/deleteBatch")
    public Result<OdTeamMembers> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        Result<OdTeamMembers> result = new Result<OdTeamMembers>();
        boolean remove = odTeamMembersService.removeByIds(ids);
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
    @ApiOperation(value = "团队成员-通过id查询", notes = "团队成员-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<OdTeamMembers> queryById(@RequestParam(name = "id", required = true) String id) {
        Result<OdTeamMembers> result = new Result<OdTeamMembers>();
        OdTeamMembers odTeamMembers = odTeamMembersService.getById(id);
        result.setResult(odTeamMembers);
        result.setSuccess(true);
        return result;
    }

}
