package com.tang.mybatisplusjoin.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.github.yulichang.interfaces.MPJBaseJoin;
import com.github.yulichang.wrapper.DeleteJoinWrapper;
import com.tang.mybatisplusjoin.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends MPJBaseMapper<UserDO> {
//    int deleteJoin(MPJBaseJoin<T> wrapper);
    int deleteJoin(DeleteJoinWrapper<UserDO> wrapper);

    /**
     * 根据whereEntity条件，更新记录
     * @param entity  实体对象 (set 条件值,可以为 null)
     * @param wrapper 实体对象封装操作类（可以为 null,里面的 entity 用于生成 where 语句）
     */
    int updateJoin(UserDO userDO, MPJBaseJoin<UserDO> wrapper);
}
