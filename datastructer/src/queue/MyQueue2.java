package queue;
/**
 * 循环队列的--简单--实现
 * @author zhaopeng
 * @create 2020-05-06 23:03
 */
public class MyQueue2 implements FatherQueue<Integer> {
    private int[] datas;
    private int  front;
    private int  tail;
    private int size;
    public MyQueue2(){
        //默认的长度为5
        this(5);
    }
    public MyQueue2(int capicity){
        if(capicity<=0){
            throw new RuntimeException("长度至少为1");
        }
        datas=new int[capicity];
        front=0;
        tail=0;
        size=0;
    }
    @Override
    public boolean enQueue(int x) {
        if(isFull()){
            throw  new RuntimeException("队列已满");
        }
        datas[tail++]=x;
        tail=(tail+1)%datas.length;
        size++;
        return false;
    }

    @Override
    public Integer deQueue(){
        if(isEmpty()){
            throw  new RuntimeException("队列为空");
        }
        int data=datas[front];
        front++;
        front=(front+1)%datas.length;
        size--;
        return data;
    }

    @Override
    public Integer front(){
        if(isEmpty()){
            throw  new RuntimeException("队列为空");
        }
        int data=datas[front];
        return data;
    }

    //判断是否为空
    @Override
    public boolean isEmpty() {
        if(size==0){
            return true;
        }
        return false;
    }

    //判断是否为满
    //当tail+1==front的时候为满
    public boolean isFull(){
         if(size==datas.length){
              return true;
         }
         return false;
    }


    public static void main(String[] args) {
        MyQueue2 queue=new MyQueue2(3);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.err.println(queue.front());
    }
}
