package com.tang.mybatisplusjoin.controller;

import alp.starcode.common.result.Result;
import com.tang.mybatisplusjoin.VO.ClassVo;
import com.tang.mybatisplusjoin.VO.GoodVo;
import com.tang.mybatisplusjoin.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tangzhipeng
 * @project mybatisPlusJoin
 * @description:
 * @date 2023/9/30 18:00
 */
@RestController
@RequestMapping("/tree")
public class TreeController {

    @Autowired
    private TreeService treeService;

    @RequestMapping("get.do")
    public Result<List<ClassVo>> getCourse() {
        return Result.success(treeService.getAllClass());
    }

    @RequestMapping("getAllGoods.do")
    public Result<List<GoodVo>> getAllGoods(){
        return Result.success(treeService.getAllGood());
    }
}
