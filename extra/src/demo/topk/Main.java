package demo.topk;

import sun.text.resources.cldr.ti.FormatData_ti;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 问题描述：
 * 从arr[1, n]这n个数中，找出最大的k个数，这就是经典的TopK问题。
 * 栗子：
 * 从arr[1, 12]={5,3,7,1,8,2,9,4,7,2,6,6} 这n=12个数中，找出第5个最大值。
 * @author zhaopeng
 * @create 2020-06-18 15:39
 */
public class Main {

   static int datas[]={5,3,7,1,8,9,9,0,24,79,79};
   //第一次

    public static void print(int[] datas){
        for (int i = 0; i <datas.length ; i++) {
            System.err.print(datas[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] quchong = quchong(datas);
        String a="aa";
        print(quchong);
    }

    //方法一  先排序，再直接取
    public static int getTopK(int[] datas,int k){
        sort(datas,0,datas.length-1);
        return datas[k-1];
    }

    //快速排序 O(NlogN)
    public static void sort(int[] datas,int L,int R){
        int left=L;
        int right=R;
        if(left>=right){
             return ;
        }
        //基准值。。。。在左边
        int base=datas[left];
        while(left!=right){
            while(left<right&&datas[right]>base){
                right--;
            }
            while(left<right&&datas[left]<=base){
                left++;
            }
            if(left!=right){
                int temp=datas[left];
                datas[left]=datas[right];
                datas[right]=temp;
            }
        }
        datas[L]=datas[left];
        datas[left]=base;
        sort(datas,L,left-1);
        sort(datas,left+1,R);
    }



    //对数组进行去重
    public static int[] quchong(int[] datas){
        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i < datas.length; i++) {
            set.add(datas[i]);
        }
        int[] res=new int[set.size()];
        int i=0;
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            res[i++]=iterator.next();
        }
        return res;
    }

    //冒泡排序的实现
    public static int[] getTopK2(int[] datas,int k){
        int[] res=new int[k];
        for (int i = 0; i < k; i++) {
            for (int j = i; j < datas.length-1-i; j++) {
                if(datas[j]>datas[j+1]){
                   swap(datas,j,j+1);
                }
                if(datas[j]==datas[j+1]){
                    continue;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            res[i]=datas[datas.length-i-1];
        }
        return res;
    }



    public static void swap(int[] arr, int index1, int index2) {
        arr[index1] = arr[index2] ^ arr[index1];
        arr[index2] = arr[index2] ^ arr[index1];
        arr[index1] = arr[index2] ^ arr[index1];
    }
}