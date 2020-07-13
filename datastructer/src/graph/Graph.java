package graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author zhaopeng
 * @create 2020-06-30 11:35
 */

public class Graph {
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;
    public  Graph(){
         nodes=new HashMap<>();
         edges=new HashSet<>();
    }
}
