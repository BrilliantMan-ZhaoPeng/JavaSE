package demo;
/**
 * 记数排序的实现
 * @author zhaopeng
 * @create 2020-05-29 10:27
 */
public class CountSort {
    public static void main(String[] args) {
        int[] arr={10,10,15,13,12,17,18,11,19,16,14,19};
        int[] sort1 = sort(arr);
        print(sort1);
    }

    //不稳定的
    static int[] sort(int[] arr){
        int[] result=new int[arr.length];
        int[] count=new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            count[arr[i]%10]++;
        }
        for (int i = 0,j=0; i < count.length ; i++) {
            while(count[i]-->0){
                result[j++]=10+i;
            }
        }
        return result;
    }

    //稳定的
    static int[] sort1(int[] arr){
        int[] result=new int[arr.length];
        int[] count=new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            count[arr[i]]++;
        }

        //对计算数组 进行前后的累加
        for (int i = 1; i < count.length ; i++) {
            count[i]=count[i]+count[i-1];
        }

        for (int i = arr.length-1; i>=0 ; i--) {
            result[--count[arr[i]]]=arr[i];
        }
        return result;
    }


    static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.err.print(arr[i]+" ");
        }
    }
}
