package com.tang.mybatisplusjoin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangzhipeng
 * @project mybatisPlusJoin
 * @description:
 * @date 2023/9/30 17:50
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/acc.do")
    public String testWeb(){
        System.out.println(12);
        return "Hello Word";
    }
}
