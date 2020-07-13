package stack;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * 利用队列实现栈
 * @author zhaopeng
 * @create 2020-06-02 23:43
 */
public class QueueStack<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;
    public QueueStack(){
        queue1=new PriorityQueue<>();
        queue2=new PriorityQueue<>();
    }

    public void push(T data){
        queue1.add(data);
    }

    public T pop(){
        T  res=null;
        if(queue2.isEmpty()&&queue1.isEmpty()){
            throw new RuntimeException("stack is empty...");
        }
        if(queue1.size()==1){
            res=queue1.poll();
        }else{//表示queue1里面还有很多的数据
            while(queue1.size()!=1){
                queue2.add(queue1.poll());
            }
            res=queue1.poll();
            while(!queue2.isEmpty()){
               queue1.add(queue2.poll());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        QueueStack<Integer> stack=new QueueStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }
}
