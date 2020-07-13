package com.demo.testmap;

/**
 * @author zhaopeng
 * @create 2020-06-11 21:05
 */

public interface MyMap<K,V> {
    V put(K k,V v);
    V get(K k);
    int size();
    interface  Entry<K,V>{
        K getKey();
        V getValue();
    }
}
