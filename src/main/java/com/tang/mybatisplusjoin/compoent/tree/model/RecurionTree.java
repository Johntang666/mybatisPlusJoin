package com.tang.mybatisplusjoin.compoent.tree.model;

import lombok.Data;

import java.util.List;

@Data
public class RecurionTree<T>{
    T tree;
    List<T> childrenList;
}
