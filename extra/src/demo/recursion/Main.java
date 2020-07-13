package demo.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

/**
 * @author zhaopeng
 * @create 2020-07-01 20:08
 */
public class Main {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> lists=new ArrayList<>();
        int temp=0;
        for (int i = A.length-1; i >= 0; i--) {
            temp=A[i]+K;
            lists.add(temp%10);
            K=temp/10;
        }
        while(K>0){
           lists.add(K%10);
           K/=10;
        }
        Collections.reverse(lists);
        return lists;
    }


    public double average(int[] salary) {
        int minSa=salary[0];
        int maxSa=salary[0];
        int count=0;
        for(int i=0; i<salary.length; i++){
            minSa=Math.min(salary[i],minSa);
            maxSa=Math.max(salary[i],maxSa);
            count+=salary[i];
        }
        System.err.println(minSa);
        System.err.println(maxSa);
        return (count-minSa-maxSa)/(salary.length-2.0);
    }


    public static void main(String[] args) {
        Main main=new Main();
        int[]   salary = {48000,59000,99000,13000,78000,45000,31000,17000,39000,37000,93000,77000,33000,28000,4000,54000,67000,6000,1000,11000};
        double average = main.average(salary);
        System.err.println(average);
    }
}
