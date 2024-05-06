package com.xxs.struct;

import java.lang.*;

public abstract class AbstractHotStruct<K,V> implements HotStruct<K,V> {
    abstract static class HotNodeStruct<K,V> implements HotNode<K,V>{
        private long hot;
        private K key;
        private V value;

        @Override
        public void reduceHot() {
            hot--;
        }

        @Override
        public void reduceHot(long num) {
            hot -= num;
        }

        @Override
        public void setHot(long num) {
            hot = num;
        }

        @Override
        public void resetHot() {
            hot = 0;
        }

        @Override
        public long getHot() {
            return hot;
        }

        @Override
        public void addHot() {
            hot++;
        }

        @Override
        public void addHot(long num) {
            hot += num;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setKey(K k) {
            this.key = k;
        }

        @Override
        public void setValue(V v) {
            this.value = v;
        }
    }
}
