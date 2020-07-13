package queue;
/**
 * 双向链表实现队列和栈
 * @author zhaopeng
 * @create 2020-06-01 17:29
 */
public class MyDoubleQueue<T> {
    //头指针
    private QueueNode head;
    //尾指针
    private QueueNode tail;

    public MyDoubleQueue() {
        this.head = null;
        this.tail = null;
    }

    //将值添加到头部
    public void addToHead(T data){
        QueueNode cur=new QueueNode<T>(data);
        if(head==null){
            head=cur;
            tail=cur;
        }else{
            cur.next=head;
            head.pre=cur;
            head=cur;
        }
    }

    //将值添加到尾部
    public void addToBottom(T data){
        QueueNode cur=new QueueNode<T>(data);
        if(head==null){
            head=cur;
            tail=cur;
        }else{
            tail.next=cur;
            cur.pre=tail;
            tail=cur;
        }
    }

    //将值从头部弹出
    public T popFromHead(){
        if(head==null){
           return null;
        }
        QueueNode cur=head;
        if(head==tail){
             head=null;
             tail=null;
        }else{
            head=head.next;
            cur.next=null;
            head.pre=null;
        }
        return (T)cur.data;
    }

    //从尾巴pop值
    public T popFromTail(){
        if(tail==null){
            return null;
        }
        QueueNode cur=tail;
        if(tail==head){
           head=null;
           tail=null;
        }else{
            QueueNode pre = cur.pre;
            pre.next=null;
            cur.pre=null;
            tail=pre;
        }
          return (T) cur.data;
    }

    public boolean isEmpty(){
        if(head==null||tail==null){
            return true;
        }
        return false;
    }



    @Override
    public String toString() {
        QueueNode temp=head;
        StringBuilder sb=new StringBuilder();
        while(temp!=null){
            sb.append(temp.data+"---->");
            temp=temp.next;
        }
        sb.append(temp);
        return sb.toString();
    }

    public static void main(String[] args) {
        MyQueue queue=new MyQueue();
        queue.enQueue(1);
        queue.enQueue(2);
/*
/*
        MyDoubleQueue queue=new MyDoubleQueue();
        queue.addToHead(1);
        queue.addToHead(2);
        queue.addToHead(3);
        System.err.println(queue);*/
    }
}


class QueueNode<T>{

    T data;

    QueueNode pre;

    QueueNode next;

    public QueueNode() {

    }

    public QueueNode(T data, QueueNode pre, QueueNode next) {
        this.data = data;
        this.pre = pre;
        this.next = next;
    }

    public QueueNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public QueueNode getPre() {
        return pre;
    }

    public void setPre(QueueNode pre) {
        this.pre = pre;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }
}


//栈的实现
class MyStack<T> {
    private MyDoubleQueue<T> myDoubleQueue;

    MyStack(){
        myDoubleQueue=new MyDoubleQueue<>();
    }

    public void push(T data){
        myDoubleQueue.addToHead(data);
    }

    public T pop(){
        return myDoubleQueue.popFromHead();
    }

    public boolean isEmpty(){
        return myDoubleQueue.isEmpty();
    }
}


//队列的实现
class MyQueue<T> {

    private MyDoubleQueue<T> myDoubleQueue=new MyDoubleQueue<>();

    public void enQueue(T data){
        myDoubleQueue.addToBottom(data);
    }

    public T deQueue(){
        return myDoubleQueue.popFromHead();
    }

    public boolean isEmpty(){
        return myDoubleQueue.isEmpty();
    }
}
