package demo;
/**冒泡排序的实现
 *
 * 1,3,7,4,5,6,9,0
 *
 * //第一次  9是最大的排到了右边
 * 1,3,4,5,6,7,0  ,9
 *
 * //第二次
 * 1,3,4,5,6,0   ,7,,9
 *
 * //第三次
 * 1,3,4,5,0  ,6,7,9
 *
 * //第四次
 * 1,3,4,0  ,5,6,7,9
 *
 * //第五次
 * 1,3,0 ,4,5,6,7,9
 *
 * //第六次
 * 1,0 ,3,4,5,6,7,9
 *
 * //第7次
 * 0,1,3,4,5,6,7,9
 * @author zhaopeng
 * @create 2020-05-24 18:19
 */

public class BulledSort {

    public static void main(String[] args) {
         int arr[]={7,2,2,4,5,6,9,0};
         sort(arr);
         print(arr);
    }

    //冒泡排序的实现
    static void sort(int arr[]){
        for (int i = 0; i < arr.length-1 ; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            //print(arr);
        }
    }


    //打印的实现
    static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
