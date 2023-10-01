package com.tang.mybatisplusjoin.service;

import com.tang.mybatisplusjoin.DAO.ClassFoodDao;
import com.tang.mybatisplusjoin.DAO.GoodDao;
import com.tang.mybatisplusjoin.VO.ClassVo;
import com.tang.mybatisplusjoin.VO.GoodVo;
import com.tang.mybatisplusjoin.pojo.ClassFood;
import com.tang.mybatisplusjoin.pojo.Good;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tangzhipeng
 * @project mybatisPlusJoin
 * @description:
 * @date 2023/9/30 18:25
 */
@Service
public class TreeService {
    @Resource
    private ClassFoodDao classFoodDao;
    @Resource
    private GoodDao goodDao;
    // 查询所有商品分类
    public List<ClassVo> getAllClass() {
        // 获取所有分类
        List<ClassFood> classes = classFoodDao.list();

        // 构建树形结构
        List<ClassVo> classVos = new ArrayList<>();
        for (ClassFood class1 : classes) {
            ClassVo classVo = new ClassVo();
            classVo.setClassid(class1.getClassid());
            classVo.setClassname(class1.getClassname());

            // 递归构建子分类
            List<ClassVo> children = getChildren(classes, (int) class1.getClassid());
            classVo.setChildren(children);

            classVos.add(classVo);
        }

        return classVos;
    }
    // 递归构建子分类
    public List<ClassVo> getChildren(List<ClassFood> classes, int parentClassid) {
        List<ClassVo> children = new ArrayList<>();
        for (ClassFood class1 : classes) {
            if (class1.getParentclassid() == parentClassid) {
                ClassVo classVo = new ClassVo();
                classVo.setClassid(class1.getClassid());
                classVo.setClassname(class1.getClassname());

                // 递归构建子分类
                List<ClassVo> children2 = getChildren(classes, (int) class1.getClassid());
                classVo.setChildren(children2);

                children.add(classVo);
            }
        }

        return children;
    }

    // 查询所有商品
    public List<GoodVo> getAllGood() {
        // 获取所有商品
        List<Good> goods = goodDao.list();

        // 构建商品列表
        List<GoodVo> goodVos = new ArrayList<>();
        for (Good good : goods) {
            GoodVo goodVo = new GoodVo();
            goodVo.setGoodid(good.getGoodid());
            goodVo.setClassid(good.getClassid());
            goodVo.setGoodname(good.getGoodname());
            goodVos.add(goodVo);
        }

        return goodVos;
    }
}
