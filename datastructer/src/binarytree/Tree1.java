package binarytree;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.Stack;
import java.util.logging.Level;

/**
 * @author zhaopeng
 * @create 2020-06-17 21:03
 */
public class Tree1 {

        public static class Node {
            public int value;
            public Node left;
            public Node right;

            public Node(int v) {
                value = v;
            }
        }

        public static void f(Node head) {
            if (head == null) {
                return;
            }
            // 1
            f(head.left);
            // 2
            f(head.right);
            // 3
        }

        // 先序打印所有节点
        public static void pre(Node head) {
            if (head == null) {
                return;
            }
            System.out.println(head.value);
            pre(head.left);
            pre(head.right);
        }

        // 先序不递归打印所有节点
        //1.先弹出打印，有右孩纸就压入，有左孩子就压入
        public static void pre1(Node head) {
            if (head == null) {
                return;
            }
            Stack<Node> stack=new Stack();
            stack.add(head);
            while(!stack.isEmpty()){
                Node pop = stack.pop();
                System.err.print(pop.value+" ");
                if(pop.right!=null){
                  stack.push(pop.right);
                }
                if(pop.left!=null){
                   stack.push(pop.left);
                }
            }
        }



        public static void in(Node head) {
            if (head == null) {
                return;
            }
            in(head.left);
            System.out.println(head.value);
            in(head.right);
        }


    // 中序不递归打印所有节点
    //1.有左孩纸就压入，pop打印该节点，有右孩子就压入
    public static void in1(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack=new Stack();
        while  (!stack.isEmpty()||head!=null){
            if(head!=null){
                stack.push(head.left);
            }else{
                head = stack.pop();
                System.err.print(head.value+" ");
                head=head.right;
            }
        }
    }

    public static void pos(Node head) {
            if (head == null) {
                return;
            }
            pos(head.left);
            pos(head.right);
            System.out.println(head.value);
        }

        //后序遍历 左孩子不为空就放左，，右孩纸不为空 就放入右边 。。。。r然后存放在栈中
    public static void pos1(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack=new Stack<>();
        Stack<Node> stack1=new Stack<Node>();
        stack.push(head);
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            stack1.push(pop);
            if(pop.left!=null&&head!=null){
                 stack.push(pop.left);
            }
            if(pop.right!=null){
                head=pop.right;
                 stack.push(pop.right);
            }
        }

        while(!stack1.isEmpty()){
            System.err.print(stack1.pop().value+" ");
        }
    }

    public static class Info{
        public boolean isBalanced;//当前数是不是平衡的
        public int heigth;//当前数的高度是多少呢
        public Info(boolean isBalanced, int heigth) {
            this.isBalanced = isBalanced;
            this.heigth = heigth;
        }
    }



    //判断是不是平衡二叉树
    public static Info process(Node head){
            //当节点为null,肯定是平衡的，而且高度为0
        if(head==null){
                return new Info(true,0);
        }
        //先递归
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);

        //到了最后拼装数据
        int height=Math.max(leftInfo.heigth,rightInfo.heigth)+1;//得到当前节点的高度
        boolean isBalance=true;
        if(!leftInfo.isBalanced||!rightInfo.isBalanced||Math.abs(leftInfo.heigth-rightInfo.heigth)>1){
            isBalance=false;
        }
        System.err.println("----");
        //返回拼装好的数据
        return new Info(isBalance,height);
    }


    public static class DistanceInfo{
            //当前节点数的最大距离
          public int maxDistance;
          //当前接电脑的最大高度
          public int height;

          public DistanceInfo(int maxDistance, int height) {
            this.maxDistance = maxDistance;
             this.height = height;
          }
    }


    //给定一颗二叉树的头结点head,任何两个节点之间都存在距离，返回整棵二叉树的最大距离？？
    public static DistanceInfo distance(Node head){
        if(head==null){
            return new DistanceInfo(0,0);
        }

        DistanceInfo leftInfo = distance(head.left);
        DistanceInfo rightInfo = distance(head.right);
        //获取当前节点数的高度
        int height=Math.max(leftInfo.height,rightInfo.height);
        int maxDistance=Math.max(Math.max(leftInfo.maxDistance,rightInfo.maxDistance),leftInfo.height+rightInfo.height+1);
        return new DistanceInfo(maxDistance,height);
    }


    public static class FullBinaryTreeInfo{
            public int H;
            public int count;
        public FullBinaryTreeInfo(int h, int count) {
            H = h;
            this.count = count;
        }

        @Override
        public String toString() {
            return "FullBinaryTreeInfo{" +
                    "H=" + H +
                    ", count=" + count +
                    '}';
        }
    }

    public static FullBinaryTreeInfo process3(Node head){
       if(head==null){
            return new FullBinaryTreeInfo(0,0);
       }
        FullBinaryTreeInfo leftInfo = process3(head.left);
        FullBinaryTreeInfo rightInfo = process3(head.right);
        int H=Math.max(leftInfo.H,rightInfo.H)+1;
        int count=leftInfo.count+rightInfo.count+1;
        return new FullBinaryTreeInfo(H,count);
    }


    public static class SearchBinaryInfo{
        //该节点成树的最大值
        public int max;
        //该节点成树的的最小值
        public int min;
        //是否是平衡二叉树
        public boolean isSearch;

        public SearchBinaryInfo(int max, int min,boolean isSearch) {
            this.max = max;
            this.min = min;
            this.isSearch=isSearch;
        }
    }

    public static SearchBinaryInfo process4(Node head){
            if(head.right==null||head.left==null){
                 return new SearchBinaryInfo(head.value,head.value,true);
            }
           SearchBinaryInfo leftInfo = process4(head.left);
           SearchBinaryInfo rightInfo = process4(head.right);

           int max=Math.max(leftInfo.max,rightInfo.max);
           int min=Math.min(leftInfo.min,rightInfo.min);

           boolean isSearch=false;
           if(leftInfo.max<head.value&&rightInfo.min>head.value){
               isSearch=true;
           }
           //左树的最大值<head.value&&右树的最小值>head.value
           return new SearchBinaryInfo(max,min,isSearch);
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(7);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.right.right= new Node(8);
        SearchBinaryInfo searchBinaryInfo = process4(head);
        System.err.println(searchBinaryInfo.min+":"+searchBinaryInfo.max);
        System.err.println(searchBinaryInfo.isSearch);
    }

}



