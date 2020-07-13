package link;

import com.sun.xml.internal.ws.handler.HandlerException;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 实现不带头结点的单向链表
 * @author zhaopeng
 * @create 2020-06-01 10:54
 */
public class MyLinkedListWithOutHead {

    private int size;

    private Node head;

    public MyLinkedListWithOutHead() {
        size=0;
        head=null;
    }

    //根据索引插入值
    public void add(int index,int data){
        Node nowNode=getNodeByIndex(0);
        Node newNode=new Node(data);
        if(nowNode==null){
            head=newNode;
        }else if(index==-1){
            newNode.next=head;
            head=newNode;
        }else if(index!=0&&index!=-1){
            nowNode=getNodeByIndex(index);
            Node next=nowNode.next;
            nowNode.next=newNode;
            newNode.next=next;
        }
        size++;
    }

    public void addLast(int data){
        add(size,data);
    }

    public void addFirst(int data){
        add(-1,data);
    }

    //根据索引查找结点的位置
    private Node getNodeByIndex(int index){
        if(index<0||index>size){
            throw new RuntimeException("数组下标越界");
        }
        //临时结点指向头结点
        Node tempNode=head;
        for (int i = 0; i < index-1 ; i++) {
            tempNode=tempNode.next;
        }
       // System.err.println(tempNode);
        return tempNode;
    }


    //反转链表,将反转好的头结点返回去
    public Node reverseLinked(){
        //记录每次循环的时候的前节点
        Node pre=null;

        Node next=null;

        while(head!=null){

            next=head.next;

            head.next=pre;

            pre=head;

            head=next;
        }
        head=pre;
        return pre;
    }

    //将num值的都删掉
    public Node removeValue(int num){
       while(head!=null){
           if(head.data!=num){
               break;
           }
           head=head.next;
       }
       //当前节点就是第一个头结点不是num值的节点
       Node cur=head;
       Node pre=head;
       while(cur!=null){
            //进行删除的实现
            if(cur.data==num){
                pre.next=cur.next;
            }else{
                pre=cur;
            }
            cur=cur.next;
       }
       return pre;
    }


    //奇数个返回中点，偶数返回上中点
    public static Node midOrUpMidNode(Node head){
        List<Node> list=new ArrayList<>();
        while(head!=null){
            list.add(head);
            head=head.next;
        }
        return list.size()%2==0?list.get((list.size()/2)-1):list.get(list.size()/2);
    }


    //判断是否为回文
    public  boolean isPalindrome(Node head){
        Node temp=head;
        Stack<Node> stack=new Stack<>();
         while(temp!=null){
             stack.push(temp);
             temp=temp.next;
         }
         while(!stack.isEmpty()){
             Node pop = stack.pop();
             if(pop.data!=head.data){
                 return false;
             }
             head=head.next;
         }
         return true;
    }



    public int size(){
        return size;
    }

    @Override
    public String toString() {
        Node temp=head;
        StringBuilder sb=new StringBuilder();
        while(temp!=null){
            sb.append(temp.data+"---->");
            temp=temp.next;
        }
        sb.append(temp);
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedListWithOutHead list=new MyLinkedListWithOutHead();
        list.addLast(1);
        list.addLast(2);
        list.addLast(2);
        list.addLast(1);
        System.err.println(list.isPalindrome(list.head));
    }
}







class Node{

    public int data;

    public Node next;

    public Node(int data){
       this.data=data;
    }

    public Node(){

    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
