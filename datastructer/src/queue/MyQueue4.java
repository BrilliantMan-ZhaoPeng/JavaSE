package queue;
import java.util.Stack;
/**
 * 用栈来实现队列
 * @author zhaopeng
 * @create 2020-05-19 20:26
 */
public class MyQueue4 {

   private  Stack<Integer> stack=new Stack();

   private int size;
    /** Initialize your data structure here. */

    public MyQueue4() {
       size=0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        size++;
          stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int remove = (int)stack.remove(0);
        size--;
        return remove;
    }

    /** Get the front element. */
    public int peek() {
        if(empty()){
            throw  new RuntimeException("栈为空");
        }
        return stack.get(0);
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
       return stack.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <size ; i++) {
            sb.append(stack.get(i)+",");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyQueue4 queue=new MyQueue4();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.err.println(queue);
        int peek = queue.peek();
        System.err.println(peek);
        queue.pop();
        System.err.println(queue);
    }
}
