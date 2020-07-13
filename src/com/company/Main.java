package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int abs = Math.abs(10);//返回参数的绝对值
        System.err.println(abs);//10
        double ceil = Math.ceil(1.1);//向上取整
        System.err.println(ceil);//2.0
        double ceil2 = Math.ceil(-1.1);//向上取整
        System.err.println(ceil2);//-1.0
        double floor = Math.floor(1.2);//向下取整
        System.err.println(floor);//1.0
        double floor1 = Math.floor(-1.5);//向下取整
        System.err.println(floor1);//-2.0
        long round = Math.round(1.2);//四舍五入
        System.err.println(round);//1
        long round1 = Math.round(1.5);//四舍五入
        System.err.println(round1);//2
        long round2 = Math.round(-1.2);//四舍五入
        System.err.println(round2);//-1
        long round3 = Math.round(-1.6);//四舍五入
        System.err.println(round3);//-2
        int max = Math.max(1, 2);//返回两个值中的最大值
        System.err.println(max);//2
        double pow = Math.pow(2, 3);//返回2的3次幂
        System.err.println(pow);//8.0
        for (int i=0;i<10;i++) {
            double random = Math.random()+1;//[0.0,1.0)
            System.err.println(random);
        }


        Set set=new HashSet();
    }
}
