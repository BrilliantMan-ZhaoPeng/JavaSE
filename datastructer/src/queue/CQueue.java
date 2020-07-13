package queue;

import java.util.Stack;

/**用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 示例 1：
 输入：
 ["CQueue","appendTail","deleteHead","deleteHead"]
 [[],[3],[],[]]
 输出：[null,null,3,-1]
 示例 2：

 输入：
 ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 [[],[],[5],[2],[],[]]
 输出：[null,-1,null,null,5,2]

 * @author zhaopeng
 * @create 2020-06-30 10:18
 */
public class CQueue {
    //存数据
    Stack stack;
    //中间量抛出数据
    Stack stack2;

    public CQueue() {
        stack=new Stack();
        stack2=new Stack();
    }

    //加入值到队尾
    public void appendTail(int value) {
        stack.push(value);
    }

    //删除头结点的值
    public int deleteHead() {
        if(stack.isEmpty()&&stack2.isEmpty()){
            return -1;
        }

        if(stack2.isEmpty() && !stack.isEmpty()){
             while(!stack.isEmpty()){
               stack2.push(stack.pop());
             }
        }

        if(!stack2.isEmpty()){
             return (int)stack2.pop();
        }
         return 1;
    }

    public static void main(String[] args) {
        CQueue cQueue=new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
    }
}