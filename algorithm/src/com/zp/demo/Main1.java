package com.zp.demo;
import java.util.HashMap;
import java.util.Map;
/**
 * @author zhaopeng
 * @create 2020-05-06 20:38
 */
public class Main1 {
    public static void main(String[] args) {
      int a[]={2,6,1,7};
        int[] ints = twoSum2(a, 9);
        for (int i = 0; i < ints.length; i++) {
            System.err.print(ints[i]+" ");
        }
    }

   /* public static int[] twoSum(int []datas,int target){
        int []res=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < datas.length; i++) {
            int num=datas[i];
            int temp=target-num;
            if(map.containsKey(temp)){
                res[0]=i;
                res[1]=map.get(temp);
                return res;
            }else{
                map.put(num,i);
            }
        }
        return res;
    }*/

   public static int[] twoSum(int[] datas,int target){
       int[] res=new int[2];
       Map<Integer,Integer> map=new HashMap<>();
       for (int i = 0; i < datas.length; i++) {
           int num=datas[i];
           int temp=target-num;
           if(map.containsKey(temp)){
               res[0]=i;
               res[1]=map.get(temp);
           }else{
               map.put(num,i);
           }
       }
       return res;
   }


    public static int[] twoSum2(int[] datas,int target){
        int[] res=new int[2];
        for (int i = 0; i < datas.length; i++) {
            int num=datas[i];
            int temp=target-num;
            for (int j = 1; j < datas.length; j++) {
                if(datas[j]==temp){
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        return res;
    }


    public static int[] threeSum(int[] datas,int target){
        int[] res=new int[3];
        for (int i = 0; i < datas.length; i++) {
            int num=datas[i];
            int temp=target-num;
            for (int j = 1; j < datas.length; j++) {
                if(datas[j]==temp){
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        return res;
    }
}
