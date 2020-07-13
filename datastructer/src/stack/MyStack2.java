package stack;

import java.util.*;

/**
 * 利用队列来实现栈
 * @author zhaopeng
 * @create 2020-05-19 20:40
 */
public class MyStack2 {

   private List<Integer> datas;

    /** Initialize your data structure here. */
    public MyStack2() {
       datas=new ArrayList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        datas.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
      if(empty()){
         throw new RuntimeException("栈为空");
      }
      return datas.remove(datas.size()-1);
    }

    /** Get the top element. */
    public int top() {
        if(empty()){
            throw new RuntimeException("栈为空");
        }
        return datas.get(datas.size()-1);
    }
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return datas.size()==0;
    }

    @Override
    public String toString() {
        return datas.toString();
    }

    public static void main(String[] args) {
       MyStack2 stack2=new MyStack2();
       stack2.push(1);
       stack2.push(2);
        stack2.push(3);
        System.err.println(stack2);
        int top = stack2.top();
        System.err.println(top);
    }
}




