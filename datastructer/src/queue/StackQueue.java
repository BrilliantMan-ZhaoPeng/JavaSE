package queue;

import java.util.Stack;

/**
 * 利用栈实现对列
 * @author zhaopeng
 * @create 2020-06-02 13:29
 */
public class StackQueue<T> {
    private Stack<T> stack1;

    private Stack<T> stack2;

    public StackQueue(){
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void enQueue(T data){
        stack1.push(data);
    }

    public T d(){
        if(stack1.isEmpty()&&stack2.isEmpty()){
            throw new RuntimeException("queue is empty...");
        }else if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            //将stack1的数据倒腾到stack2中
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        StackQueue<Integer> queue=new StackQueue<Integer>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
    }
}

