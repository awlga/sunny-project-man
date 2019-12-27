package com.sunny.projectman.business.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sunny.projectman.business.MyException.GlobalException;
import com.sunny.projectman.business.dto.OdFileDTO;
import com.sunny.projectman.business.entity.OdFile;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务接口
 */
public interface IOdFileService extends IService<OdFile> {
    IPage<OdFile> pageList(OdFileDTO odFileDTO); // 分页
    int add(OdFile odFile);// 添加
    int update(OdFile odFile);// 更新
    OdFile get(OdFile odFile);// 获取单个文件
    int delete(OdFile odFile);
    int upload(MultipartFile file) throws GlobalException;
}
