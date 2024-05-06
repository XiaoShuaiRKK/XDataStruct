package com.xxs.struct;

import java.util.ArrayList;
import java.util.List;

public class HotList<V> implements HotStruct<Long,V>{
    List<V> dataList;

    public HotList(){
        dataList = new ArrayList<>();
    }

    @Override
    public void insert(Long aLong, V v) {

    }

    @Override
    public void rearrangement() {

    }

    @Override
    public V select(Long aLong) {
        return null;
    }
}
