package com.zp.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaopeng
 * @create 2020-06-22 11:51
 */
public class Main3 {
    public static void main(String[] args) {
        int[] datas={1,2,3,2,2,2,5,4,2};
        int i = find3(datas);
        System.err.println(i);
    }
    public static int find(int[] datas){
        int res=0;
        for (int i = 0; i < datas.length; i++) {
           res^=datas[i];
        }
        return res;
    }

    public static int find2(int[] datas){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < datas.length; i++) {
            if(map.containsKey(datas[i])){
                Integer integer = map.get(datas[i]);
                if(integer==datas.length/2){
                   return datas[i];
                }
                map.put(datas[i],++integer);
            }else{
                map.put(datas[i],1);
            }
        }
        return 0;
    }


    public static int find3(int[] datas){
        //1,3,3,4
        //
        Arrays.sort(datas);
        int data=datas[datas.length/2];
        return data;
    }
}
