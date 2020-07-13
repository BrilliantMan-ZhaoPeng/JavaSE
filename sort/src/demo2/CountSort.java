package demo2;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.xml.internal.fastinfoset.util.PrefixArray;

import javax.activation.MailcapCommandMap;
import javax.annotation.Resource;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.time.chrono.MinguoDate;

/**
 * 计数排序，，，简单到爆的
 * 桶为0 1 2 3 4 5 6 7 8 9 ......max
 * @author zhaopeng
 * @create 2020-06-14 19:01
 */

public class CountSort {

    static int[] datas={1,2,42,3,122,99};

    public static void main(String[] args) {
        sort();
        print();
    }

    public static void sort(){
        int max = getMax(datas);
        int[] bucket=new int[max+1];
        for (int i = 0; i < datas.length; i++) {
              bucket[datas[i]]++;
        }
        int index=0;
        for (int i = 0; i < bucket.length; i++) {
             while(bucket[i]!=0){
                 bucket[i]--;
                 datas[index++]=i;
             }
        }
    }

    public static  void print(){
        for (int i = 0; i < datas.length; i++) {
            System.err.print(datas[i]+" ");
        }
    }

    public static int getMax(int[] datas){
        int max=datas[0];
        for (int i = 1; i < datas.length; i++) {
            max=Math.max(datas[i],max);
        }
        return max;
    }
}
