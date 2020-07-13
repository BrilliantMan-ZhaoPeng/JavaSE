package graph;

import java.util.*;
/**
 * 宽度优先遍历
 * @author zhaopeng
 * @create 2020-06-30 15:55
 */
public class BFS {

    public static void bfs(Node head){
        Queue<Node> queue=new LinkedList<>();
        Set<Node> set=new HashSet();
        //先将头结点加入
        queue.add(head);
        //用于排除循环指向的问题
        set.add(head);

        while(queue.isEmpty()){
            Node poll = queue.poll();
            System.err.print(poll.value+" ");
            ArrayList<Node> nexts = poll.nexts;
            for (Node node : nexts) {
                if(!set.contains(node)){
                    queue.add(node);
                    set.add(node);
                }
            }
        }
    }
}
