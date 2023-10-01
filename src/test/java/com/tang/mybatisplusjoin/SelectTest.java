package com.tang.mybatisplusjoin;

import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.tang.mybatisplusjoin.DTO.UserDTO;
import com.tang.mybatisplusjoin.mapper.UserMapper;
import com.tang.mybatisplusjoin.pojo.Address;
import com.tang.mybatisplusjoin.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class SelectTest {
    @Resource
    private UserMapper userMapper;
    @Test
    public void testSelect(){
//        MPJLambdaWrapper<User> wrapper=new MPJLambdaWrapper<User>()
//                .selectAll(User.class)
//                .select(Address::getCity,Address::getAddress)
//                .leftJoin(Address.class,Address::getUserId,User::getId);
//        List<UserDTO> userDTOList=userMapper.selectJoinList(UserDTO.class,wrapper);
//        userDTOList.forEach(System.out::println);
    }
}
