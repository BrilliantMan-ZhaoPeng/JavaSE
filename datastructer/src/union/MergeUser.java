package union;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
/**
 * @author zhaopeng
 * @create 2020-06-30 10:11
 */
public class MergeUser {

   public static class User{
       public String a;
       public String b;
       public String c;

       User(String a,String b,String c){
           this.a=a;
           this.b=b;
           this.c=c;
       }
   }

   //如果两个User,a字段一样，或者b字段一样，或则c字段一样，
   // 就认为是一个人，请合并Users,返回合并之后的用户数量
   public static int mergeUser(User[] users){
       //初始化并查集
       UnionSet<User> unionSet=new UnionSet<>(users);
       //存每个用户的a字段
       HashMap<String,User> mapA=new HashMap<>();
       //存每个用户的b字段
       HashMap<String,User> mapB=new HashMap<>();
       //存每个用户的c字段
       HashMap<String,User> mapC=new HashMap<>();

       for (User user : users) {
          if(mapA.containsKey(user.a)){
              unionSet.union(user,mapA.get(user.a));
          }else{
              mapA.put(user.a,user);
          }

           if(mapA.containsKey(user.b)){
               unionSet.union(user,mapA.get(user.b));
           }else{
               mapA.put(user.b,user);
           }

           if(mapA.containsKey(user.c)){
               unionSet.union(user,mapA.get(user.c));
           }else{
               mapA.put(user.c,user);
           }
       }
       return unionSet.getSetNum();
   }



    public static class UnionSet<V>{

        public HashMap<V,Node<V>> nodes=new HashMap<>();

        //<当前节点，父节点是啥>
        public HashMap<Node<V>,Node<V>> parents=new HashMap<>();

        //只有一个点，它是代表点，才有大小的记录
        public HashMap<Node<V>,Integer> sizeMap=new HashMap<>();

        public UnionSet(V[] values){
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


        //获得并查集合并之后的size
        public int getSetNum(){
            return sizeMap.size();
        }
    }

    public static class Node<V>{
        V value;
        public Node(V v){
            value=v;
        }
    }

}
