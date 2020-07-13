package link;
/**
 * 实现带头结点的双向链表
 * @author zhaopeng
 * @create 2020-06-01 10:54
 */
public class MyDoubleLinkedListWithHead{

    private int size;

    private DoubleNode head;

    public MyDoubleLinkedListWithHead() {
        size=0;
        head=new DoubleNode();
    }

    //根据索引插入值
    public void add(int index,int data){
        DoubleNode nowNode=getNodeByIndex(index);
        if(nowNode.next==null){//意思是放在最后
            DoubleNode newNode=new DoubleNode(data,nowNode);
            nowNode.next=newNode;
        }else{//在某个值中间插入
            DoubleNode newNode=new DoubleNode(data,nowNode,nowNode.next);
            nowNode.next.pre=newNode;
            nowNode.next=newNode;
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
        for (int i = 0; i < index ; i++) {
            tempNode=tempNode.next;
        }
        return tempNode;
    }

    //反转链表,返回反转好的头结点
    public DoubleNode  reverseLinked(){
          DoubleNode pre=null;
          DoubleNode next=null;
          head=head.next;
          while(head!=null){
              next=head.next;
              head.next=pre;
              pre.pre=head;

              pre=head;
              head=next;
          }
          //这个时候已经遍历到最后一个节点了，还在需要一个头指针指向当前这个节点
          DoubleNode headNode=new DoubleNode();
          headNode.next=pre;
          pre.pre=headNode;
          head=headNode;
          return head;
    }


    public int size(){
        return size;
    }

    @Override
    public String toString() {
        DoubleNode temp=head.next;
        StringBuilder sb=new StringBuilder();
        while(temp!=null){
            sb.append(temp.data+"---->");
            temp=temp.next;
        }
        sb.append(temp);
        return sb.toString();
    }


    public static void main(String[] args) {
        MyDoubleLinkedListWithHead linked=new MyDoubleLinkedListWithHead();
        linked.addLast(1);
        linked.addLast(2);
        linked.addLast(3);
       // linked.reverseLinked();
        System.err.println(linked);
    }

}

class DoubleNode{

    public int data;

    public DoubleNode pre;

    public DoubleNode next;

    public DoubleNode(int data,DoubleNode pre,DoubleNode  next){
        this.data=data;
        this.pre=pre;
        this.next=next;
    }

    public DoubleNode(int data,DoubleNode pre){
        this.data=data;
        this.pre=pre;
    }


    public DoubleNode() {
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "data=" + data +
                ", pre=" + pre +
                ", next=" + next +
                '}';
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoubleNode getPre() {
        return pre;
    }

    public void setPre(DoubleNode pre) {
        this.pre = pre;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }
}



