package com.sunny.projectman.business.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sunny.projectman.business.dto.OdXuqiuDTO;
import com.sunny.projectman.business.entity.OdXuqiu;
import com.sunny.projectman.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * OdXuqiuController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>12月 25, 2019</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OdXuqiuControllerTest {

    @Autowired
    private OdXuqiuController odXuqiuController;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: queryPageList(@RequestBody OdXuqiuDTO odXuqiuDTO)
     */
    @Test
    public void testQueryPageList() throws Exception {
        Result<IPage<OdXuqiu>> iPageResult = odXuqiuController.queryPageList(OdXuqiuDTO.builder()
                .odXuqiu(OdXuqiu.builder().build())
                .pageNo(1)
                .pageSize(2)
                .build());
    }

    /**
     * Method: add(@RequestBody OdXuqiu odXuqiu)
     */
    @Test
    public void testAdd() throws Exception {

        odXuqiuController.add(OdXuqiu.builder()
                .biaoti("33")
                .gongsi("1200")
                .oadj("4444")
                .build());
    }

    /**
     * Method: edit(@RequestBody OdXuqiu odXuqiu)
     */
    @Test
    public void testEdit() throws Exception {

        odXuqiuController.edit(OdXuqiu.builder()
                .id(new BigDecimal(49))
                .renwu("2222")
                .build());
    }

    /**
     * Method: delete(@RequestParam(name = "id", required = true) String id)
     */
    @Test
    public void testDelete() throws Exception {

        Result<?> delete = odXuqiuController.delete("46");
        System.out.println(delete);
    }

    /**
     * Method: deleteBatch(@RequestParam(name = "ids", required = true) String ids)
     */
    @Test
    public void testDeleteBatch() throws Exception {

        odXuqiuController.deleteBatch("44,45");
    }

    /**
     * Method: queryById(@RequestParam(name = "id", required = true) String id)
     */
    @Test
    public void testQueryById() throws Exception {

        Result<OdXuqiu> result = odXuqiuController.queryById("49");
        System.out.println(result);
    }


}
