package com.sunny.projectman.business.dto;

import com.sunny.projectman.business.entity.OdFile;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 分页传输数据
 */
@Data
@Accessors(chain = true)
public class OdFileDTO {
    private OdFile odFile;// 文件对象
    private Integer pageNo = 1; // 当前页
    private Integer pageSize = 10;// 显示条数
}
