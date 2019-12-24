package com.sunny.projectman.business.controller;


import com.sunny.projectman.business.service.IOdXuqiuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lgwang
 * @since 2019-12-24
 */
@Controller
@RequestMapping("/business/odXuqiu")
public class OdXuqiuController {

    @Autowired
    private IOdXuqiuService odXuqiuService;


}
