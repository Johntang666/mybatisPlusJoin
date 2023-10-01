package com.tang.mybatisplusjoin;

import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.DeleteJoinWrapper;
import com.github.yulichang.wrapper.UpdateJoinWrapper;
import com.tang.mybatisplusjoin.entity.AddressDO;
import com.tang.mybatisplusjoin.entity.AreaDO;
import com.tang.mybatisplusjoin.entity.UserDO;
import com.tang.mybatisplusjoin.mapper.UserMapper;
import com.tang.mybatisplusjoin.pojo.Address;
import com.tang.mybatisplusjoin.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class JoinDelete {
    @Resource
    private UserMapper userMapper;

    @Test
    void update(){
        DeleteJoinWrapper<UserDO> wrapper= JoinWrappers.delete(UserDO.class)
                .leftJoin(AddressDO.class,AddressDO::getUserId,UserDO::getId)
                .leftJoin(AreaDO.class,AreaDO::getId, AddressDO::getAreaId)
                .eq(UserDO::getId,1);
        int i=userMapper.deleteJoin(wrapper);

    }
    /**
     * 手动set条件
     * 更新User表name和address字段
     * 测试有错误
     */
    @Test
    void update1(){
        UpdateJoinWrapper<UserDO> update=JoinWrappers.update(UserDO.class)
                .set(UserDO::getName,"aaaaa")
                .set(AddressDO::getAddress,"bbbb")
                .leftJoin(AddressDO.class,AddressDO::getUserId, UserDO::getId)
                .eq(UserDO::getId,1);
        int i=userMapper.updateJoin(null,update);
    }


}
