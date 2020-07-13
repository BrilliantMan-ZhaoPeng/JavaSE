package demo;

import java.time.temporal.ValueRange;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 5,2,6,1,3
 * 1 2 3 5 6
 * 快速排序的实现
 * @author zhaopeng
 * @create 2020-05-27 11:27
 */

public class QuickSort {
    public static void main(String[] args) {
        int datas[]={3,5,1,2};/*0 2 6 1 3 7 4 9 5 8*/
        quickSort(datas,0,datas.length-1);
        print(datas);
    }

    //方式1  基准在左边的情况
    static void sort(int[] arr,int left,int right){
        if(left>=right){//判断结束的条件
             return ;
        }
        int i=left;
        int j=right;
        //先找一个基准数
        int temp=arr[left];
        while(i!=j){
              while(arr[j]>=temp&&i<j){
                  j--;
              }
              while(arr[i]<=temp&&i<j){
                  i++;
              }
              //开始交换值
              int a=arr[i];
              arr[i]=arr[j];
              arr[j]=a;
        }

        //基准数的还原
        arr[left]=arr[i];
        arr[i]=temp;
        //排序左边
        sort(arr,left,i-1);
        //排序右边
        sort(arr,i+1,right);
    }


    //基准在右边的情况
    static void sort1(int[] arr,int left,int right){
        if(left>=right){
            return ;
        }
        int i=left;
        int j=right;
        //基准值右边
        int temp=arr[right];

        while(i<j){
            while(arr[i]<=temp&&i<j){
                i++;
            }
            while(arr[j]>=temp&&i<j){
                j--;
            }
            if(i<j){
                int a=arr[i];
                arr[i]=arr[j];
                arr[j]=a;
            }
        }
        arr[right]=arr[i];
        arr[i]=temp;
        sort(arr,i+1,right);
        sort(arr,left,i-1);
    }


    //实现
    static void  quickSort(int arr[],int left,int right){
         int i=left;
         int j=right;
         if(i>=j){
              return ;
         }
         int base=arr[i];
         while(i!=j){
             while(arr[j]>=base&&i<j){
                   j--;
             }
             while(arr[i]<=base&&i<j){
                   i++;
             }
             int temp=arr[i];
             arr[i]=arr[j];
             arr[j]=temp;
         }
        arr[left]=arr[i];
        arr[i]=base;
        //排序左边
        quickSort(arr,left,i-1);
        //排序右边
        quickSort(arr,i+1,right);
    }


    static void print(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.err.print(arr[i]+" ");
        }
        System.err.println("\n");
    }
}
