package com.sunny.projectman.business.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sunny.projectman.business.MyException.GlobalException;
import com.sunny.projectman.business.dto.OdFileDTO;
import com.sunny.projectman.business.entity.OdFile;
import com.sunny.projectman.business.service.IOdFileService;
import com.sunny.projectman.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件控制器
 */
@Controller
@RequestMapping("/business/odFiles")

public class OdFileController {

    @Autowired
    private IOdFileService odFileService;

    /**
     * 分页
     * @param odFileDTO 传输对象
     * @return 返回封装好的Result对象
     */
    @PostMapping("/list")
    @ResponseBody
    public Result<IPage<OdFile>> pageList(@RequestBody OdFileDTO odFileDTO){
        IPage<OdFile> iPage = odFileService.pageList(odFileDTO);
        Result<IPage<OdFile>> result  = new Result<>();
        result.setResult(iPage);
        return result;
    }

    /**
     * 添加文件操作
     * @param odFile 文件对象
     * @return 返封装好的Result对象
     */
    @PostMapping("/add")
    @ResponseBody
    public Result add(@RequestBody OdFileDTO odFile) {
        int success = odFileService.add(odFile.getOdFile());
        if (success == 1) {
            return Result.ok("添加成功");
        }
        return Result.error("添加失败");
    }

    /**
     * 更新文件操作
     * @param odFile 操作对象
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody OdFileDTO odFile) {
        int success = odFileService.update(odFile.getOdFile());
        if (success == 1) {
            return Result.ok("更新成功");
        }
        return Result.error("更新失败");
    }

    /**
     * 删除
     * @param odFile 传输对象
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public Result delete(@RequestBody OdFileDTO odFile) {
        int success = odFileService.delete(odFile.getOdFile());
        if (success == 1) {
            return Result.ok("删除成功");
        }
        return Result.error("删除失败");
    }

    /**
     * 文件上传
     * @param file 上传的文件
     * @return 返回封装的Result对象
     */
    @PostMapping("/upload")
    @ResponseBody
    public Result upload(MultipartFile file) {

        int upload = 0;
        try {
            upload = odFileService.upload(file);
        } catch (GlobalException e) {
            e.printStackTrace();
        }
        if(upload==1){
            return Result.ok("上传成功");
        }
        return Result.error("上传失败");
    }

/*    @PostMapping("/get")
    @ResponseBody
    public Result<OdFile> get(@RequestBody OdFileDTO odFile) {
        OdFile odfile = odFileService.get(odFile.getOdFile());
        Result<OdFile> result  = new Result<>();
        result.setResult(odfile);
        return result;
    }*/
}