package com.tang.mybatisplusjoin.compoent.tree.operate;

import com.tang.mybatisplusjoin.compoent.tree.model.RecurionTree;

import java.util.List;

public interface ITreeOperate<T> {
    public <T>List<RecurionTree> getTree();
    public boolean updateTree();
    public boolean deleteTree();
}
