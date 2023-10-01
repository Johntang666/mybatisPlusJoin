package com.tang.mybatisplusjoin.DAO.impl;

import com.github.yulichang.base.MPJBaseServiceImpl;
import com.tang.mybatisplusjoin.mapper.GoodMapper;
import com.tang.mybatisplusjoin.pojo.Good;
import org.springframework.stereotype.Service;
import com.tang.mybatisplusjoin.DAO.GoodDao;
/**
 * @author tangzhipeng
 * @project mybatisPlusJoin
 * @description:
 * @date 2023/9/30 18:45
 */
@Service
public class GoodDaoImpl extends MPJBaseServiceImpl<GoodMapper, Good> implements GoodDao {
}
