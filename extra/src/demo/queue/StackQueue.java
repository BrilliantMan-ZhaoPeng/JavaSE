package demo.queue;

import java.util.Queue;
import java.util.Stack;

/**
 * @author zhaopeng
 * @create 2020-06-18 14:45
 */
public class StackQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    StackQueue(){
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    //入队
    public void enQueue(int data){
          stack1.push(data);
    }

    //出队
    public Integer deQueue(){
        if(stack1.isEmpty()&&stack2.isEmpty()){
            return -1;
        }
        if(!stack2.isEmpty()){
              return stack2.pop();
        }else{
           while(!stack1.isEmpty()){
              stack2.push(stack1.pop());
           }
           return stack2.pop();
        }
    }


    public static void main(String[] args) {
        StackQueue quque=new StackQueue();
        quque.enQueue(1);
        quque.enQueue(2);
        quque.enQueue(3);
        System.err.println(quque.deQueue());
        System.err.println(quque.deQueue());
        System.err.println(quque.deQueue());
    }
}
