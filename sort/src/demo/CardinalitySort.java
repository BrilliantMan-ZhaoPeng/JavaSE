package demo;
/**
 *
 *
 * 123,122,100,123,534,51,1231
 *
 * 100 1231 51 122 123 123 534
 *
 * 100 122 123 123 1231 534 51
 * 51 100 122 123 123 1231 534
 * 51 100 122 123 123 534 1231
 *
 *
 *
 * 123,122,100,123,534,51,1231
 *
 * 100 51 1231 122 123 123 534
 * 100 123 123 122 534 1231 51
 * 51 122 123 123 100 1231 534
 * 534 100 123 123 122 51 1231
 * 基数排序的实现
 * @author zhaopeng
 * @create 2020-05-29 18:59
 */
public class CardinalitySort {
    public static void main(String[] args) {
        int arr[]={123,122,100,123,534,1231,51};
        sort(arr);
    }

    public static void sort(int[] arr){
        //找出数组中最大的数
        int maxData=arr[0];
        for (int i = 1; i < arr.length ; i++) {
             if(arr[i]>maxData){
                   maxData=arr[i];
             }
        }

        //倍数
        int multiple=0;

        while(maxData>0){
            //增量
            int increment=(int)Math.pow(10,multiple);
      //      System.err.println("increment:"+increment);

            //记数
            int[] count=new int[10];
            //放结果
            int[] result=new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                int temp=(arr[i]/increment)%10;//得到个位上的数

                System.err.print(" temp:"+temp+" ");
                count[temp]++;
            }
            for (int i = 1; i < count.length; i++) {
                count[i]=count[i]+count[i-1];
            }
            for (int i = arr.length-1; i >= 0 ; i--) {
                int data=arr[i];
                int temp=(arr[i]/increment)%10;//得到个位上的数
                result[--count[temp]]=data;
            }
            //将result copy到arr中去
            System.arraycopy(result,0,arr,0,result.length);
            maxData/=10;
            multiple++;


            print(arr);
            System.err.println();
        }
    }

    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.err.print(arr[i]+" ");
        }
    }

}
