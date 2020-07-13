package demo2;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author zhaopeng
 * @create 2020-06-10 11:03
 */

public class QuickSort {
    private static int[] datas=new int[1000];
    static{
        for (int i = 0; i < 1000; i++) {
            datas[i]=(int)(Math.random()*1000);
        }
    }

    public static void main(String[] args) {
        int[] compare = compare(datas);
        print(compare);
        sort(datas,0,datas.length-1);

        print(datas);

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
        if(left>=right){
           return ;
        }
        int L=left;
        int R=right;
        int temp=datas[L];
        while(L != R){
             while(datas[R]>temp&&R>L){
                 R--;
             }
            while (datas[L]<=temp&&R>L) {
                 L++;
            }
             int a=datas[L];
             datas[L]=datas[R];
             datas[R]=a;
        }
        datas[left]=datas[L];
        datas[L]=temp;
        sort(datas,left,L-1);
        sort(datas,L+1,right);
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
