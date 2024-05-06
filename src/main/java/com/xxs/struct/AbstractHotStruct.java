package com.xxs.struct;

import java.lang.*;

public abstract class AbstractHotStruct<K,V> implements HotStruct<K,V> {

    protected static class HotNodeStruct<K,V> implements HotNode<K,V>,Comparable<HotNodeStruct<K,V>>,Cloneable{
        protected long hot;
        protected HotNode<K,V> left;
        protected HotNode<K,V> right;
        protected HotNode<K,V> parent;
        protected K key;
        protected V value;

        protected HotNodeStruct(long hot, HotNode<K, V> left, HotNode<K, V> right, HotNode<K, V> parent, K key, V value) {
            this.hot = hot;
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.key = key;
            this.value = value;
        }

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

        @Override
        public HotNodeStruct<K, V> clone() {
            HotNodeStruct<K,V> node = null;
            try {
                node = (HotNodeStruct<K, V>) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
            return node;
        }

        @Override
        public int compareTo(HotNodeStruct<K, V> o) {
            return (int) (this.hot - o.hot);
        }
    }
}
