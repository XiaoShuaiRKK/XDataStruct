package com.xxs.struct;

public interface HotStruct<K,V> {
    void insert(K k,V v);
    void rearrangement();
    V select(K k);

    interface HotNode<K,V>{
        long getHot();
        void addHot();
        void addHot(long num);
        void reduceHot();
        void reduceHot(long num);
        void setHot(long num);
        void resetHot();
        void setKey(K k);
        void setValue(V v);
        K getKey();
        V getValue();
    }
}
