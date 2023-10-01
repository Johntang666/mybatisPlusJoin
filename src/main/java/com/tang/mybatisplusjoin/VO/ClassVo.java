package com.tang.mybatisplusjoin.VO;

import com.tang.mybatisplusjoin.pojo.ClassFood;
import lombok.Data;

import java.util.List;

/**
 * @author tangzhipeng
 * @project mybatisPlusJoin
 * @description:
 * @date 2023/9/30 18:15
 */
@Data
public class ClassVo {

    private long classid;
    private long parentclassid;
    private String classname;
    private List<ClassVo> children;
}
