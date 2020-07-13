package demo;
/**
 * 希尔排序的实现
 * @author zhaopeng
 * @create 2020-05-25 10:46
 */

public class ShellSort {

    public static void main(String[] args) {
        int datas[]={5,2,6,1,3,7,4,9,0,8};
        sort(datas);
        print(datas);
    }

    //方式1
    static void sort(int[] arr){
       /* for(int gap=arr.length>>2;gap>0;gap/=2){
            for (int i = gap ; i < arr.length ; i++ ) {
                for (int j = i ; j > gap-1 ; j-=gap) {
                    //System.err.println("j:"+j);
                    if(arr[j]<arr[j-gap]){
                        int temp=arr[j];
                        arr[j]=arr[j-gap];
                        arr[j-gap]=temp;
                    }
                }
            }
        }*/

        /*for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
*/

// 1 3 5 8 9
        for (int gap = arr.length/2;gap > 0 ; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                int temp=arr[i];
                int index=i;
                while(index>gap-1&&arr[index-gap]>temp){
                    arr[index]=arr[index-gap];
                    index-=gap;
                }
                arr[index]=temp;
            }
        }
    }

    static void print(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.err.print(arr[i]+" ");
        }
    }
}
