package com.company;
/**
 * @author zhaopeng
 * @create 2020-04-18 22:25
 */
public class Main2 {
    public static void  main(String[] args) {
           Main2 main2=new Main2();
           int arrays[]={6,5,4,2,7,8,9};
           main2.fastSort(arrays, 0, arrays.length - 1);

         for (int anInt : arrays) {
            System.err.print(anInt+" ");
        }
    }
    public boolean isContains(int left,int right,int data,int arrays[]){
        int mid=(left+right)/2;
        if(left>right){
            return false;
        }
        if(arrays[mid]==data){
            return true;
        }
        if(arrays[mid]<data){
            return isContains(mid+1,right,data,arrays);
        }
        if(arrays[mid]>data){
            return isContains(left,mid-1,data,arrays);
        }
        return false;
    }

    //实现冒泡排序
    public int[] sort(int []arrays){
        for (int i = 0; i < arrays.length-1; i++) {
            for (int j = i; j <arrays.length-1-i ; j++) {
               if(arrays[j]>arrays[j+1]){
                   int temp=arrays[j];
                   arrays[j]=arrays[j+1];
                   arrays[j+1]=temp;
               }
            }    
        }

        for (int array : arrays) {
            System.err.print(array+" ");
        }
          return arrays;
    }


    //求和
    public int digui(int index){
        if(index==1){
            return 1;
        }else{
            return index+digui(index-1);
        }
    }


    //求阶乘
    public int jiecheng(int index){
          if(index==1){
              return 1;
          }else{
              return index*jiecheng(index-1);
          }
     }

     //快速排序
     public void fastSort(int arrays[],int left,int right){
        if(right<left){
           return;
        }
        int left0=left;
        int right0=right;
          //计算基准数
         int baseNumber=arrays[left0];
         while(left!=right){
             //1.从右边开始找比基准数大的
             while(arrays[right]>=baseNumber&&right>left){
                  right--;
             }
             //2.从左边开始找比基准数小的
             while(arrays[left]<=baseNumber&&right>left){
                 left++;
             }
             //3.交换两个值的位置
             int temp=arrays[left];
             arrays[left]=arrays[right];
             arrays[right]=temp;
         }
         //基准数归位
         int temp=arrays[left];
         arrays[left]=arrays[left0];
         arrays[left0]=temp;
         fastSort(arrays,left0,left-1);
         fastSort(arrays,left+1,right0);
     }

}
