package com.zp.demo;
/**
 * 假如有50瓶饮料，每喝三瓶能奖励一瓶，请问他能和多少瓶
 * @author zhaopeng
 * @create 2020-06-23 9:35
 */

public class Main5 {
    public static  void main(String[] args) {
        System.err.println(solution2(8));
    }
    public static int solution(int N){
        int count=N;//开始饮料的总数
        int temp=0;//记录喝的总数
        while(count>=3){
            count-=3;
            count+=1;
            temp+=3;
        }
        while(count!=0){
            count--;
            temp++;
        }
        return temp;
    }

    public static int solution2(int N){
       if(N<3){
           return N;
       }

       //这是前面剩下的个数
       int m=N-N%3;

       //这是后面的总个数
        int n=N/3+N%3;

       return m+solution2(n);
    }
}
