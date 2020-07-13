package com.zp.demo.xor;
/**
 * 计算以一个数组中，只有一种数，出现奇数次
 * @author zhaopeng
 * @create 2020-05-31 14:10
 */
public class Main1 {
    public static void main(String[] args) {
        int datas[]={1,22,22,22,1,2,2,5,5};
        int eor=0;
        for (int i = 0; i < datas.length; i++) {
             eor^=datas[i];
        }
        System.err.println(eor);
    }
}
