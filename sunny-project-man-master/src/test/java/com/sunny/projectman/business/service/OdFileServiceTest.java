package com.sunny.projectman.business.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sunny.projectman.business.dto.OdFileDTO;
import com.sunny.projectman.business.entity.OdFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OdFileServiceTest {
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
            System.out.println("odfile==============>" + od);
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
        System.out.println(result);
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
        System.out.println(result);
    }

    /**
     * 单个查询测试
     */
    @Test
    public void get() {
        OdFile odfile = new OdFile();
        odfile.setId(new BigDecimal("12"));
        OdFile odFile = odFileService.get(odfile);
        System.out.println(odFile);
    }

    @Test
    public void delete() {
        OdFile odfile = new OdFile();
        odfile.setId(new BigDecimal("13"));
        int delete = odFileService.delete(odfile);
        System.out.println(delete);
    }

}