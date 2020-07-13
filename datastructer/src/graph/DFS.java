package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 深度优先
 *
 * 就是一条路走到死，走不到就重新走
 * @author zhaopeng
 * @create 2020-06-30 16:04
 */
public class DFS {


    public static void dfs(Node head){
        Stack<Node> stack=new Stack<>();
        Set<Node> set=new HashSet<>();
        stack.add(head);
        set.add(head);
        System.err.print(head.value+" ");
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            ArrayList<Node> nexts = pop.nexts;
            for (Node next : nexts) {
                if(!set.contains(pop)){
                    System.err.print(next.value+" ");
                    stack.push(pop);
                    stack.push(next);
                    set.add(next);

                    break;
                }
            }
        }
    }


}
