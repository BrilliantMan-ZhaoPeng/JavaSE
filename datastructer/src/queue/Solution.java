package queue;

import java.util.*;

/**
 * @author zhaopeng
 * @create 2020-05-07 23:23
 */
public class Solution {
    public static void main(String[] args) {
         System.err.println(numSquares(1));
    }

    public static int numSquares(int n){
         Queue<Integer> queue = new LinkedList<Integer>();
        //存放已经使用过的数据
        Set<Integer> set=new HashSet<>();
        //存放数据
    //    MyQueue queue=new MyQueue();
        //获取到最大的数
        int maxNum=(int)Math.sqrt(n);

        for (int i = 1; i <= maxNum ; i++) {
            queue.offer(i*i);
           // queue.enQueue(i*i);
            set.add(i*i);
        }
        int step=0;
        //当不为空
        while(!queue.isEmpty()){
           step++;
           int size=queue.size();
            //System.err.println("size"+size);
           for (int i = 0; i < size ; ++i) {
             //  Integer front = queue.front();
               Integer front = queue.peek();
               if(front==n){
                  return step;
               }
               for(int j=1;j<=maxNum;j++){
                   int newNum=j*j+front;
                   if(!set.contains(newNum)){
                       set.add(newNum);
                       queue.offer(newNum);
                       //queue.enQueue(newNum);

                   }
               }
                //queue.deQueue();
               queue.poll();
               //  queue.remove();
           }
        }
        return -1;
    }

}
