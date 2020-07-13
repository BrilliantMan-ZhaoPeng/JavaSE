package queue;
/**
 * 固定大小数组下，实现队列,不浪费空间
 * @author zhaopeng
 * @create 2020-06-02 10:26
 */
public class MyArrayQueue<T> {

    private T[] arr;
    /*头指针*/
    private int headIndex;
    /*尾指针*/
    private int tailIndex;
    /*记录当前queue中值的个数*/
    private int size;

    private final int capacity;

    public MyArrayQueue(int capacity){
         arr=(T[])new Object[capacity];
         headIndex=0;
         tailIndex=0;
         this.capacity=capacity;
    }

    //入队操作
    public void enQueue(T data){
        if(size==capacity){
            throw new RuntimeException("queue is full...");
        }
        arr[tailIndex++]=data;
        size++;
        tailIndex=getNewIndex(tailIndex);
    }

    //出队操作
    public T deQueue(){
        if(size==0){
            throw new RuntimeException("queue is empty");
        }
        T res=arr[headIndex++];
        size--;
        headIndex=getNewIndex(headIndex);
        return res;
    }

    //根据传入进来的index看是否大于capacity,如果刚好大于直接返回到0
    private int getNewIndex(int nowIndex){
       return nowIndex>=capacity ? 0:nowIndex;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public static void main(String[] args) {
        MyArrayQueue queue=new MyArrayQueue<Integer>(2);
        queue.enQueue(1);
        queue.enQueue(2);
        System.err.println(queue.deQueue());
        System.err.println(queue.deQueue());
       // queue.enQueue(2);
    }

}
