package com.tang.mybatisplusjoin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.query.MPJQueryWrapper;
import com.github.yulichang.toolkit.MPJWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.tang.mybatisplusjoin.DTO.UserDTO;
import com.tang.mybatisplusjoin.entity.AddressDO;
import com.tang.mybatisplusjoin.entity.AreaDO;
import com.tang.mybatisplusjoin.entity.UserDO;
import com.tang.mybatisplusjoin.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * 连表测试类
 * <p>
 * 支持mybatis-plus 查询枚举字段
 * 支持mybatis-plus typeHandle功能
 * <p>
 * 移除了mybatis-plus 逻辑删除支持，逻辑删除需要在连表查询时自己添加对应的条件
 */
@SpringBootTest
class JoinTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 一对多
     * SELECT t.id,t.name,t.sex,t.head_img,t.address_id,t.del,t1.id AS joina_id,
     * t1.user_id,t1.area_id,t1.tel,t1.address,t1.del AS joina_del
     * FROM `user` t LEFT JOIN user_address t1 ON (t1.user_id = t.id)
     * WHERE t.del=0 AND t1.del=0 ORDER BY t.id DESC
     */
    @Test
    void testJoin() {
        MPJLambdaWrapper<UserDO> wrapper = new MPJLambdaWrapper<UserDO>()
                //查询User表的全部字段
                .selectAll(UserDO.class)
                //全部映射，不用考虑字段重复的问题，会自动对重复列添加别名
                .selectCollection(AddressDO.class, UserDTO::getAddressList)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .orderByDesc(UserDO::getId);

        List<UserDTO> list = userMapper.selectJoinList(UserDTO.class, wrapper);
        list.forEach(System.out::println);
    }


    /**
     * 简单的分页关联查询 lambda
     */
    @Test
    void test1() {
        IPage<UserDTO> iPage = userMapper.selectJoinPage(new Page<>(1, 10), UserDTO.class,
                MPJWrappers.<UserDO>lambdaJoin()
                        .selectAll(UserDO.class)
                        .select(AddressDO::getAddress)
                        .select(AreaDO::getProvince)
                        .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                        .leftJoin(AreaDO.class, AreaDO::getId, AddressDO::getAreaId));
        iPage.getRecords().forEach(System.out::println);
    }

    /**
     * 简单的关联查询 String
     */
    @Test
    void test2() {
        MPJQueryWrapper<UserDO> wrapper = MPJWrappers.<UserDO>queryJoin()
                .selectAll(UserDO.class)
                .selectAll(AddressDO.class, "addr")
                .selectAll(AreaDO.class, "a")
                .selectIgnore("addr.id", "a.id", "t.del", "addr.del")
                .leftJoin("user_address addr on t.id = addr.user_id")
                .leftJoin("area a on a.id = addr.area_id")
                .eq("t.id", 1);

        List<UserDO> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }


    /**
     * 简单的分页关联查询 lambda
     * ON语句多条件
     * SELECT t.id,t.name,t.sex,t.head_img,t.address_id,t.del,t1.address
     * FROM `user` t
     * LEFT JOIN user_address t1 ON (t.id = t1.user_id AND t.id = t1.user_id)
     * WHERE t.del=0 AND t1.del=0 AND (t.id = ? AND (t.head_img = ? OR t1.user_id = ?) AND t.id = ?) LIMIT ?
     */
    @Test
    void test3() {
        IPage<UserDTO> page = userMapper.selectJoinPage(new Page<>(1, 10), UserDTO.class,
                MPJWrappers.<UserDO>lambdaJoin()
                        .selectAll(UserDO.class)
                        .select(AddressDO::getAddress)
                        .leftJoin(AddressDO.class, on -> on
                                .eq(UserDO::getId, AddressDO::getUserId)
                                .eq(UserDO::getId, AddressDO::getUserId))
                        .eq(UserDO::getId, 1)
                        .and(i -> i.eq(UserDO::getHeadImg, "er")
                                .or()
                                .eq(AddressDO::getUserId, 1))
                        .eq(UserDO::getId, 1));
        page.getRecords().forEach(System.out::println);
    }

    /**
     * 简单的函数使用
     */
    @Test
    void test4() {
        UserDTO one = userMapper.selectJoinOne(UserDTO.class, MPJWrappers.<UserDO>lambdaJoin()
                .selectSum(UserDO::getId)
                .selectMax(UserDO::getId, UserDTO::getHeadImg)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .eq(UserDO::getId, 1));
        System.out.println(one);
    }


    /**
     * 忽略个别查询字段
     */
    @Test
    void test6() {
        IPage<UserDTO> page = userMapper.selectJoinPage(new Page<>(1, 10), UserDTO.class,
                MPJWrappers.<UserDO>lambdaJoin()
                        .selectAll(UserDO.class)
                        .selectFilter(AddressDO.class, p -> true)
                        .select(AddressDO::getAddress)
                        .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                        .eq(UserDO::getId, 1));
        page.getRecords().forEach(System.out::println);
    }


    /**
     * 关联查询返回map
     */
    @Test
    void test7() {
        List<Map<String, Object>> list = userMapper.selectJoinMaps(MPJWrappers.<UserDO>lambdaJoin()
                .selectAll(UserDO.class)
                .select(AddressDO::getAddress)
                .leftJoin(AddressDO.class, AddressDO::getUserId, UserDO::getId)
                .eq(UserDO::getId, 1));
        list.forEach(System.out::println);
    }

}
