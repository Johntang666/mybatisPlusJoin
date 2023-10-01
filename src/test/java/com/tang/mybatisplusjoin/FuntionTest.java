package com.tang.mybatisplusjoin;

import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.tang.mybatisplusjoin.DTO.UserDTO;
import com.tang.mybatisplusjoin.entity.AddressDO;
import com.tang.mybatisplusjoin.entity.UserDO;
import com.tang.mybatisplusjoin.mapper.UserMapper;
import com.tang.mybatisplusjoin.utools.FuncEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class FuntionTest {
    @Resource
    private UserMapper userMapper;
    @Test
    void funTest(){
//        userMapper.selectJoinList(UserDTO.class, new MPJLambdaWrapper<>()
//                // 自定义的函数枚举
//                .selectFunc(FuncEnum.DATE_FORMAT, UserDO::getDel)
//                // 也可以用lambda自定义
//                .selectFunc(() -> "IF(%s=1,'男','女')", UserDO::getSex)
//                // 支持多个通配符,参数顺序与arg参数顺序保持一致
//                .selectFunc("concat(%s, %s)", arg -> arg.accept(UserDO::getName, UserDO::getId), UserDO::getSex)
//                .leftJoin(AddressDO.class, on -> on
//                        .eq(AddressDO::getUserId, UserDO::getId)
//                        .eq(AddressDO::getId, UserDO::getId))
//                .eq(UserDO::getId, 2));

    }
}
