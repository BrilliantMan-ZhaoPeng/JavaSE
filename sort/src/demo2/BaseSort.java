package demo2;

import java.util.zip.CheckedOutputStream;

/**
 * 基数排序的实现，，，桶为0 1 2 3 4 5 6 7 8 9
 * @author zhaopeng
 * @create 2020-06-14 19:12
 */
public class BaseSort {

    static int[] datas={1,2,42,3,122,99};

    public static void main(String[] args) {
        sort();
        print(datas);
    }

    public static void sort(){
        int[] result=new int[datas.length];
        int digit=getMaxDigit(datas);
        for (int i = 0; i < digit; i++) {//有多少位就进出多少下
            int[] count=new int[10];
            //获得需要的除数大小
            int digitNumber= (int) Math.pow(10,i);

            //循环数组
            for (int j = 0; j < datas.length; j++) {
                int index=(datas[j]/digitNumber)%10;
                count[index]++;
            }
            //默认定好顺序   以实现先进先出
            for (int j = 1; j < count.length; j++) {
                count[j]=count[j]+count[j-1];
            }
            for (int k = datas.length-1; k >=0 ; k--) {
                int index=(datas[k]/digitNumber)%10;
                result[--count[index]]=datas[k];
            }
            //将数组copy到datas中
            System.arraycopy(result,0,datas,0,result.length);
        }
    }

    public static  void print(int[] datas){
        for (int i = 0; i < datas.length; i++) {
            System.err.print(datas[i]+" ");
        }
    }


    //得到最大数的位数
    public static int getMaxDigit(int[] datas){
        int max=datas[0];
        for (int i = 1; i < datas.length; i++) {
            max=Math.max(datas[i],max);
        }
        int count=0;
        while(max>0){
            max/=10;
            count++;
        }
        return count;
    }
}
