package demo;
/**
 * 插入排序的实现  2 5 6 1
 * @author zhaopeng
 * @create 2020-05-24 18:30
 */
public class InsSort {
    public static void main(String[] args) {
          int datas[]={5,2,6,1,3,7,4,9,0,8};
          sort1(datas);
          print(datas);
    }








    //方式1
    static void sort(int[] arr){
        /*for (int i = 1; i < arr.length; i++) {
            for (int j = i; j>0 && arr[j]<arr[j-1] ; j--) {
                     int temp=arr[j];
                     arr[j]=arr[j-1];
                     arr[j-1]=temp;
            }
        }*/

        if(arr.length <= 1){
            return ;
        }

        for (int i = 1; i < arr.length; i++) {
            for(int j=i;j>0;j--){
                  if(arr[j]<arr[j-1]){
                      int temp=arr[j];
                      arr[j]=arr[j-1];
                      arr[j-1]=temp;
                  }
            }
        }


    }

    //方式2  优化一点，不用创建临时变量
    static void sort1(int[] arr){
        if(arr.length<=1){
           return ;
        }
        for (int i = 1; i < arr.length ; i++) {
             int temp=arr[i];
             int j=i;
             while(j>0&&arr[j-1]>temp){
                   //往后移动值
                 arr[j]=arr[j-1];
                 j--;
             }
             arr[j]=temp;
        }
    }


    static void print(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.err.print(arr[i]+" ");
        }
    }
}
