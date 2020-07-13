package link;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现带头结点的单向链表
 * @author zhaopeng
 * @create 2020-06-01 10:54
 */
public class MyLinkedListWithHead {

    private int size;

    private Node head;

    public MyLinkedListWithHead() {
        size=0;
        head=new Node();
    }

    //根据索引插入值
    public void add(int index,int data){
        Node nowNode=getNodeByIndex(index);
        Node newNode=new Node(data);

        Node next=nowNode.next;
        nowNode.next=newNode;
        newNode.next=next;
        size++;
    }

    //插入到最前面
    public void addLast(int data){
        add(size,data);
    }
    //插入到最后面
    public void addFirst(int data){
        add(0,data);
    }

    //根据索引查找结点的位置
    private Node getNodeByIndex(int index){
        if(index<0||index>size){
            throw new RuntimeException("数组下标越界");
        }
        //临时结点指向头结点
        Node tempNode=head;
        for (int i = 0; i < index ; i++) {
            tempNode=tempNode.next;
        }
        return tempNode;
    }

    //反转链表,返回反转好的头结点
    public Node  reverseLinked(){

          Node pre=null;

          Node next=null;

          head=head.next;

          while(head!=null){

              next=head.next;

              head.next=pre;

              pre=head;

              head=next;
          }
          //再创建一个头结点出来
          Node headNode=new Node();
          headNode.next=pre;
          head=headNode;
          return head;
    }



    public int size(){
        return size;
    }

    @Override
    public String toString() {
        Node temp=head.next;
        StringBuilder sb=new StringBuilder();
        while(temp!=null){
            sb.append(temp.data+"---->");
            temp=temp.next;
        }
        sb.append(temp);
        return sb.toString();
    }



    //奇数个返回中点，偶数返回上中点
    public static Node midOrUpMidNode(Node head){
        List<Node> list=new ArrayList<>();
        head=head.next;
        while(head!=null){
            list.add(head);
            head=head.next;
        }
        return list.size()%2==0?list.get((list.size()/2)-1):list.get(list.size()/2);
    }


    public static void main(String[] args) {
        MyLinkedListWithHead list=new MyLinkedListWithHead();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.reverseLinked();
        System.err.println(list);
        Node node = midOrUpMidNode(list.head);
        System.err.println(node.data);
    }
}


