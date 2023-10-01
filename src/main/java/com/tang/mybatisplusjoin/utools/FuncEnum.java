package com.tang.mybatisplusjoin.utools;


import com.github.yulichang.wrapper.enums.BaseFuncEnum;

public enum FuncEnum implements BaseFuncEnum {
    IF_SEX("IF(%s=1,'男','女')"),                         //if 性别转换
    CASE_SEX("CASE %s WHEN 1 THEN '男' ELSE '女' END"),   //case 性别转换
    LCASE("LCASE(%s)");
//    DATE_FORMAT("%Y-%m-%d");
    private final String sql;

    FuncEnum(String sql) {
        this.sql = sql;
    }

    @Override
    public String getSql() {
        return this.sql;
    }
}