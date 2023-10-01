package com.tang.mybatisplusjoin.compoent.tree.model;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.github.yulichang.base.MPJBaseService;

public class TreeConfig <T> {
    MPJBaseService<T> mpjBaseService;
    SFunction<T,?> keyFiled;
    SFunction<T,?> parentField;
    SFunction<T,?> orderField;

    public <E extends MPJBaseService<T>> TreeConfig(E mpjBaseService, SFunction<T, ?> keyFiled, SFunction<T, ?> parentField, SFunction<T, ?> orderField) {
        this.mpjBaseService = mpjBaseService;
        this.keyFiled = keyFiled;
        this.parentField = parentField;
        this.orderField = orderField;
    }

    public MPJBaseService<T> getMpjBaseService() {
        return mpjBaseService;
    }

    public void setMpjBaseService(MPJBaseService<T> mpjBaseService) {
        this.mpjBaseService = mpjBaseService;
    }

    public SFunction<T, ?> getKeyFiled() {
        return keyFiled;
    }

    public void setKeyFiled(SFunction<T, ?> keyFiled) {
        this.keyFiled = keyFiled;
    }

    public SFunction<T, ?> getParentField() {
        return parentField;
    }

    public void setParentField(SFunction<T, ?> parentField) {
        this.parentField = parentField;
    }

    public SFunction<T, ?> getOrderField() {
        return orderField;
    }

    public void setOrderField(SFunction<T, ?> orderField) {
        this.orderField = orderField;
    }
}
