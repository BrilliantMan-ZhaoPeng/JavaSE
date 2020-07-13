package stack;
import java.util.Stack;
/**
 * 实现每次pop出栈中最小的值,且复杂度为O(1)
 * @author zhaopeng
 * @create 2020-06-02 11:21
 */
public class MinStack2<T extends Comparable> {
        private Stack<T> stackData;
        private Stack<T> stackMin;

        public MinStack2() {
            this.stackData=new Stack<>();
            this.stackMin=new Stack<>();
        }

        public T getMin(){
             if(stackData.isEmpty()||stackMin.isEmpty()){
                     System.err.println("stack is empty...");
             }
             return stackMin.peek();
        }

        public T pop(){
            if(stackData.isEmpty()||stackMin.isEmpty()){
                System.err.println("stack is empty...");
            }
            stackMin.pop();
           return stackData.pop();
        }

        public void push(T data){
            stackData.push(data);
            if (stackMin.isEmpty()) {
                  stackMin.push(data);
            }else if(stackMin.peek().compareTo(data)>=0){//表示当前的值比栈顶更加小
                  stackMin.push(data);
            }else{
                stackMin.push(stackMin.peek());
            }
        }

    public static void main(String[] args) {
        MinStack2 stack2=new MinStack2();
        stack2.push(8);
        stack2.push(4);
        stack2.push(2);
        stack2.push(5);
        stack2.push(6);
        System.err.println(stack2.getMin());
        stack2.pop();
        System.err.println(stack2.getMin());
        stack2.pop();
        System.err.println(stack2.getMin());
        stack2.pop();
        System.err.println(stack2.getMin());
    }
}
