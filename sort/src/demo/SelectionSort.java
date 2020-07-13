package demo;

import java.util.Arrays;
import java.util.logging.Level;

/**4,1,3,2,7,6,9
 *
 * 方式1
 * 第一次：
 * 1,    4,3,2,7,6,9
 *
 * 第二次
 * 1,2,  4,3,7,6,9
 *
 * 第三次
 * 1,2,3,   4,7,6,9
 *
 * 第四次
 * 1,2,3,4,    7,6,9
 *
 * 第五次
 * 1,2,3,4,6,    7,9
 *
 * 第六次
 * 1,2,3,4,6,7,9
 *
 *
 *
 *
 * 选择排序的实现
 * @author zhaopeng
 * @create 2020-05-22 22:15
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] temp=new int[100];
        for (int i = 0; i < temp.length; i++) {
            temp[i]=(int)(Math.random()*+100);
        }
        sort2(temp);
        print(temp);
    }

        //方式1
        public static int[] sort1(int[] datas){
            /*for (int i = 0; i < datas.length-1; i++) {
                for (int j = i+1; j < datas.length; j++) {
                    if (datas[i]>datas[j]) {
                        int temp=datas[i];
                        datas[i]=datas[j];
                        datas[j]=temp;
                    }
                }
            }*/

            for (int i = 0; i < datas.length-1; i++) {
                for (int j = i+1; j <datas.length ; j++) {
                     if(datas[i]>datas[j]){
                         int temp=datas[i];
                         datas[j]=datas[i];
                         datas[i]=temp;
                     }
                }
            }
            return datas;
        }


      //方式2
      public static void sort2(int[] datas){
        /* for (int i = 0; i < datas.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < datas.length; j++) {
                minPos=datas[minPos] > datas[j] ? j:minPos;
            }
            int temp = datas[minPos];
            datas[minPos] = datas[i];
            datas[i] = temp;
         }*/





          for (int i = 0; i < datas.length-1; i++) {
              int minPos=i;
              //找出i+1后面的所有比i值小的下标
              int tempData=datas[i];
              for (int j = i+1 ; j < datas.length; j++) {
                  minPos=datas[j]<datas[minPos]?j:minPos;
              }
              //将最小的值弄到i
              datas[i]=datas[minPos];
              datas[minPos]=tempData;
          }
    }
    
    public static void print(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.err.print(arr[i]+" ");
        }
    }

}
