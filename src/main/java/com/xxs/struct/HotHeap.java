package com.xxs.struct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HotHeap<K,V> extends AbstractHotStruct<K,V> {
    private List<HotNodeStruct<K,V>> heap;

    protected HotHeap(long[] hot,K[] keys,V[] value){
        heap = new ArrayList<>();
        int len = hot.length;
        for(int i=0; i<len;i++){
            HotNodeStruct<K,V> node = new HotNodeStruct<>(hot[i],null,null,null,keys[i],value[i]);
            heap.add(node);
        }
        for(int i = (len >> 1) - 1;i >= 0;i--)
            filterdown(i,len - 1);
    }

    protected void filterdown(int start,int end){
        int c = start;
        int l = (c << 1) + 1;
        HotNodeStruct<K,V> tmp = heap.get(c);
        while (l <= end){
            if(l < end && (heap.get(l).compareTo(heap.get(l+1)) > 0))
                l++;
            int cmp = tmp.compareTo(heap.get(l));
            if(cmp <= 0)
                break;
            else {
                heap.set(c,heap.get(l));
                c = l;
                l = (l << 1) + 1;
            }
        }
        heap.set(c,tmp);
    }

    protected void filterup(int start){
        int c = start;
        int p = (c - 1) >> 1;
        HotNodeStruct<K,V> tmp = heap.get(c);
        while (c > 0){
            int cmp = heap.get(p).compareTo(tmp);
            if(cmp <= 0)
                break;
            else {
                heap.set(c,heap.get(p));
                c = p;
                p = (p - 1) >> 1;
            }
        }
        heap.set(c,tmp);
    }

    protected void insert(HotNodeStruct<K,V> node){
        heap.add(node);
        filterup(heap.size());
    }

    private void swapNode(int i,int j){
        HotNodeStruct<K,V> tmp = heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,tmp);
    }

    protected HotNodeStruct<K,V> dumpFromMinimum(){
        int size = heap.size();
        if(size == 0)
            return null;
        HotNodeStruct<K,V> node = heap.get(0).clone();
        heap.set(0,heap.get(size - 1));
        heap.remove(size - 1);
        if(heap.size() > 1)
            filterdown(0,heap.size() - 1);
        return node;
    }

    protected void destroy(){
        heap.clear();
        heap = null;
    }

    @Override
    public void insert(K k, V v) {

    }

    @Override
    public void rearrangement() {

    }

    @Override
    public V select(K k) {
        return null;
    }
}
