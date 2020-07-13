package com.demo.testmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaopeng
 * @create 2020-06-11 20:51
 */
public class Main {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("zhangsan","张三");
        map.put(null,"null");
        map.put(null,"null2");
        map.put("list","李四");
        System.err.println(map.get("asds"));
    }
}
