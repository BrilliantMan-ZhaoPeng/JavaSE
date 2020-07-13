package union;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
/**
 * 并查集
 * @author zhaopeng
 * @create 2020-06-28 23:14
 */
public class UnionFind {

    public static class Node<V>{
        V value;
        public Node(V v){
            value=v;
        }
    }

    public static class UnionSet<V>{

        public HashMap<V,Node<V>> nodes=new HashMap<>();

        //<当前节点，父节点是啥>
        public HashMap<Node<V>,Node<V>> parents=new HashMap<>();

        //只有一个点，它是代表点，才有大小的记录
        public HashMap<Node<V>,Integer> sizeMap=new HashMap<>();

        public UnionSet(List<V> values){
            for (V value : values) {
                Node<V> node = new Node<>(value);
                //放到nodes表中
                nodes.put(value,node);
                //父节点都先初始化指向自己
                parents.put(node,node);
                //自己都是代表点，size--->1
                sizeMap.put(node,1);
            }
        }

        //从cur开始，一直往上找，找到不能再往上的代表点
        public Node<V> findFather(Node<V> cur){
            Stack<Node<V>> path=new Stack<>();
            //说明还没找到这个代表点
            while(cur!=parents.get(cur)){
                path.push(cur);
                cur=parents.get(cur);
            }
            while(!path.isEmpty()){
                parents.put(path.pop(),cur);
            }
            return cur;
        }

        public boolean isSameSet(V a,V b){
            if(!nodes.containsKey(a)||!nodes.containsKey(b)){
              return false;
            }
            return findFather(nodes.get(a))==findFather(nodes.get(b));
        }

        public void union(V a,V b){
            if(!nodes.containsKey(a)||!nodes.containsKey(b)){
                return ;
            }
            Node<V> father = findFather(nodes.get(a));
            Node<V> father1 = findFather(nodes.get(b));
            //拿到当前的节点个数
            Integer fatherCount = sizeMap.get(father);
            Integer father1Count = sizeMap.get(father1);
            if(fatherCount>=father1Count){
                parents.put(father,father1);
                sizeMap.put(father1,father1Count+father1Count);
                sizeMap.remove(father);
            }else{
                parents.put(father1,father);
                sizeMap.put(father,father1Count+father1Count);
                sizeMap.remove(father1);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(1,1,4,5,4,7,8);
        UnionSet<Integer> unionSet=new UnionSet<>(list);
        boolean sameSet = unionSet.isSameSet(1, 1);
        System.err.println(sameSet);
    }
}
