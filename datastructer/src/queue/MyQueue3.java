package queue;

import com.sun.glass.ui.Size;

/**
 * 循环队列的--高级--实现
 * @author zhaopeng
 * @create 2020-05-06 23:57
 */
public class MyQueue3 implements FatherQueue<Integer>{

    //存放数据的数组
    private int[] datas;

    //相当于是头指针
    private int head;

    //相当于是尾指针
    private int tail;

    //容量
    private int capacity;

    public  MyQueue3(){
        //默认的容量为5
        this(5);
    }

    public MyQueue3(int capacity){
        datas=new int[capacity];
        head=-1;
        tail=-1;
        this.capacity=capacity;
    }
    //入队
    @Override
    public boolean enQueue(int x) {
        if(isFull()){
            throw new RuntimeException("队列已满");
        }
        if(isEmpty()){
           head=0;
        }
        tail=(tail+1)%capacity;
        datas[tail]=x;
        return true;
    }

    //出队
    //0 1 2 3 4 5
    //8 4 5 1 1 1
    @Override
    public Integer deQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int data=datas[head];
        if(head==tail){
            head=-1;
            tail=-1;
            return data;
        }
        head=(head+1)%capacity;
        return data;
    }

    @Override
    public Integer front(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        int data=datas[head];
        return data;
    }


    //判断是否为空
    @Override
    public boolean isEmpty() {
        return head==-1;
    }

    //判断是否为满
    public boolean isFull(){
        return (tail+1)%capacity==head;
    }

    public static void main(String[] args) {
        MyQueue3 myQueue3=new MyQueue3();
        myQueue3.enQueue(2);
        myQueue3.enQueue(3);
        myQueue3.enQueue(3);
        myQueue3.enQueue(3);
        myQueue3.enQueue(3);
    }
}
