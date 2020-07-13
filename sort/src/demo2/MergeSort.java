package demo2;
import java.util.Arrays;
/**
 * 归并排序的实现
 * @author zhaopeng
 * @create 2020-06-09 10:16
 */
public class MergeSort {
    private static int[] datas=new int[1000];
    static{
        for (int i = 0; i < 1000; i++) {
            datas[i]=(int)(Math.random()*1000);
        }
    }



    public static void main(String[] args) {
        int[] compare = compare(datas);
        sort(datas,0,datas.length-1);

        boolean flag=true;
        for (int i = 0; i < datas.length; i++) {
            if(compare[i]==datas[i]){
                continue;
            }else{
                flag=false;
                break;
            }
        }
        if(flag){
            print(datas);
            System.err.println("success...");
        }else{
            System.err.println("error...");
        }

    }


    public static void sort(int[] datas,int left,int right){
        if(left==right){
            return;
        }
        int mid=left+(right-left>>1);
        sort(datas,left,mid);
        sort(datas,mid+1,right);
        //将左右两边的数据综合在一起
        merge(datas,left,mid,right);
    }

    private static void merge(int[] datas,int left,int mid,int right){
        int[] temp=new int[right-left+1];
        int L=left;
        int R=mid+1;
        int i=0;
        while(left<=mid&&R<=right){
            temp[i++]=datas[left]>datas[R]?datas[R++]:datas[left++];
        }
        while(left<=mid){
            temp[i++]=datas[left++];
        }
        while(R<=right){
            temp[i++]=datas[R++];
        }
//        print(temp);
        for (int j = 0; j < temp.length ; j++) {
            datas[L++]=temp[j];
        }
    }


    public static int[] compare(int[] datas){
        int[] temp = copyArr(datas);
        Arrays.sort(temp);
        return temp;
    }

    private static int[] copyArr(int[] datas){
        if(datas==null||datas.length==0){
            return null;
        }
        int[] temp=new int[datas.length];
        for (int i = 0; i < datas.length; i++) {
             temp[i]=datas[i];
        }
        return temp;
    }

    private static void print(int[] datas){
        for (int i = 0; i <datas.length ; i++) {
            System.err.print(datas[i]+" ");
        }
        System.err.println("\n");
    }
}