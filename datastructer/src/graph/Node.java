package graph;

import java.util.ArrayList;

/**
 * @author zhaopeng
 * @create 2020-06-30 11:30
 */

public class Node {
    //当前节点的值
    public int value;
    //指向当前节点的节点数
    public int in;
    //当前节点指出去的节点数
    public int out;

    //直接的指出去的节点
    public ArrayList<Node> nexts;
    //直接指出去的边

    public ArrayList<Edge> edegs;


    Node(int value){
       this.value=value;
       in=0;
       out=0;
       nexts=new ArrayList<>();
       edegs=new ArrayList<Edge>();
    }
}

