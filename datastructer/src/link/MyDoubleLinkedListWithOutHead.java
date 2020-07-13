package link;
/**
 * 实现带头结点的单向链表
 * @author zhaopeng
 * @create 2020-06-01 10:54
 */
public class MyDoubleLinkedListWithOutHead{

    private int size;

    private DoubleNode head;

    public MyDoubleLinkedListWithOutHead() {
        size=0;
        head=null;
    }

    //根据索引插入值
    public void add(int index,int data){
        DoubleNode nowNode=getNodeByIndex(0);
        DoubleNode newNode=new DoubleNode();
        if(nowNode==null){
            head=newNode;
        }else if(index==-1){
            newNode.next=head;
            head.pre=newNode;
            head=newNode;

        }else if(index!=0&&index!=-1){
            nowNode=getNodeByIndex(index);
            System.err.println("nowNode:"+nowNode);
            System.err.println("newNode:"+newNode);
            DoubleNode next=nowNode.next;
            newNode.next=next;
            next.pre=newNode;
            newNode.pre=nowNode;
        }
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
    private DoubleNode getNodeByIndex(int index){
        if(index<0||index>size){
            throw new RuntimeException("数组下标越界");
        }
        //临时结点指向头结点
        DoubleNode tempNode=head;
        for (int i = 0; i < index-1 ; i++) {
            tempNode=tempNode.next;
        }
        return tempNode;
    }

    //反转链表,返回反转好的头结点
    public DoubleNode  reverseLinked(){
          DoubleNode pre=null;
          DoubleNode next=null;
          while(head!=null){

              next=head.next;

              head.next=pre;

              pre=head;

              head=next;
          }

          head=pre;
          return head;
    }


    public int size(){
        return size;
    }

    @Override
    public String toString() {
        DoubleNode temp=head;
        StringBuilder sb=new StringBuilder();
        while(temp!=null){
            sb.append(temp.data+"---->");
            temp=temp.next;
        }
        sb.append(temp);
        return sb.toString();
    }


    public static void main(String[] args) {
        MyDoubleLinkedListWithOutHead linked=new MyDoubleLinkedListWithOutHead();
        linked.addLast(1);
        linked.add(0,2);
        System.err.println(linked);
    }

}