package stack;
/**
 * 数组实现栈的功能
 * @author zhaopeng
 * @create 2020-06-01 23:51
 */
public class MyArrayStack<T> {
     //存放数据的数组
    private T[] datas;

    //显示当前数组中已经存在的数据个数
    private int size;

    //数组的容量大小是多少
    private int capacity;

    public MyArrayStack(int capacity) {
        this.datas = (T[])new Object[capacity];
        this.size = 0;
        this.capacity=capacity;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void push(T data){
        if(size==capacity){
            throw  new RuntimeException("stack is full....");
        }
        datas[size++]=data;
    }


    public T pop(){
        if(size==0){
            throw  new RuntimeException("stack is empty....");
        }
        return datas[--size];
    }

    public static void main(String[] args) {
        MyArrayStack stack=new MyArrayStack(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

}
