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

        System.out.println(iPageResult);

    }


} 
