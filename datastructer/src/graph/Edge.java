package graph;
/**
 * @author zhaopeng
 * @create 2020-06-30 11:32
 */
public class Edge {
    //权重
  public int weight;
  public Node from;
  public Node to;

  public Edge(int weight,Node from,Node to){
      this.weight=weight;
      this.from=from;
      this.to=to;
  }
}
