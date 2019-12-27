package com.sunny.projectman.business.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sunny.projectman.business.dto.OdFileDTO;
import com.sunny.projectman.business.entity.OdFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OdFileServiceTest {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IOdFileService odFileService;


    /**
     * 分页测试
     */
    @Test
    public void pageList() {

        OdFileDTO odFileDTO = new OdFileDTO();
        odFileDTO.setPageNo(1);
        odFileDTO.setPageSize(2);
        IPage<OdFile> page =  odFileService.pageList(odFileDTO);
        List<OdFile> records = page.getRecords();
        for (OdFile od :
                records) {
            logger.info("odfile==============>" + od);
        }
    }

    /**
     *增加文件测试
     */

    @Test
    public void addTest() {
        OdFile odfile = new OdFile();
        odfile.setType("avi");
        odfile.setSize("11111");
        odfile.setCreater("Tom");
        int result = odFileService.add(odfile);
        logger.info("添加受影响行数:" + result);
    }

    /**
     * 更新测试
     */
    @Test
    public void updateTest() {
        OdFile odfile = new OdFile();
        odfile.setId(new BigDecimal("13"));
        odfile.setType("rar");
        odfile.setSize("20M");
        odfile.setCreater("Lucy");
        int result = odFileService.update(odfile);
        logger.info("更新受影响行数:" + result);
    }

    /**
     * 单个查询测试
     */
    @Test
    public void get() {
        OdFile odfile = new OdFile();
        odfile.setId(new BigDecimal("12"));
        OdFile odFile = odFileService.get(odfile);
        logger.info("odfile===>"+ odFile);
    }

    @Test
    public void delete() {
        OdFile odfile = new OdFile();
        odfile.setId(new BigDecimal("13"));
        int result = odFileService.delete(odfile);
        logger.info("删除受影响行数:" + result);
    }

}