package com.sunny.projectman.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunny.projectman.business.MyException.GlobalException;
import com.sunny.projectman.business.dto.OdFileDTO;
import com.sunny.projectman.business.entity.OdFile;
import com.sunny.projectman.business.mapper.OdFileMapper;
import com.sunny.projectman.business.service.IOdFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 文件服务实现类
 */
@Service
public class OdFileServiceImpl extends ServiceImpl<OdFileMapper,OdFile> implements IOdFileService {
   /* @Resource
    private OdFileMapper odFileMapper;*/

    /**
     * 实现分页方法
     * @param odFileDTO 传入分页条件对象
     * @return 返回IPage对象
     */
    @Override
    public IPage<OdFile> pageList(OdFileDTO odFileDTO) {
        // 注册条件构造器
        QueryWrapper queryWrapper = new QueryWrapper();
        // QueryGenerator.installMplus(queryWrapper, odFileDTO.getOdFile(), null);
        // 设置分页数据
        Page<OdFile> page = new Page<OdFile>(odFileDTO.getPageNo(),odFileDTO.getPageSize());
        return baseMapper.selectPage(page,queryWrapper);
    }

    /**
     * 文件添加
     * @param odFile 文件对象
     * @return 返回受影响行数
     */
    @Override
    public int add(OdFile odFile) {
        if(odFile != null){
            odFile.setUpdateTime(new Date());
            return baseMapper.insert(odFile);
        }
        return 0;
    }

    /**
     * 更新文件
     * @param odFile 文件对象
     * @return
     */
    @Override
    public int update(OdFile odFile) {
        OdFile odFile1 = baseMapper.selectById(odFile.getId());
        if(odFile != null){
            return baseMapper.updateById(odFile1);
        }
        return 0;

    }

    /**
     * 查询单个文件
     * @param odFile 文件对象
     * @return 文件对象
     */
    @Override
    public OdFile get(OdFile odFile) {
        return baseMapper.selectById(odFile.getId());
    }

    /**
     * 删除操作
     * @param odFile 文件对象
     * @return 受影响行数
     */
    @Override
    public int delete(OdFile odFile) {
        return baseMapper.deleteById(odFile.getId());
    }

    /**
     * 文件上传实现方法
     * @param file 上传的文件
     * @return 受影响行数
     * @throws GlobalException 自定义全局异常
     */
    @Override
    public int upload(MultipartFile file) throws GlobalException {
        if (file == null || file.isEmpty()) {
            throw new GlobalException("未选择需上传的日志文件");
        }

        String filePath = new File("logs_app").getAbsolutePath();
        File fileUpload = new File(filePath);
        if (!fileUpload.exists()) {
            fileUpload.mkdirs();
        }

        fileUpload = new File(filePath, file.getOriginalFilename());
        if (fileUpload.exists()) {
            throw new GlobalException("上传的日志文件已存在");
        }

        try {
            file.transferTo(fileUpload);

            return 1;
        } catch (IOException e) {
            throw new GlobalException("上传日志文件到服务器失败：" + e.toString());
        }
    }
}