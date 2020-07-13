package queue;
import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.List;
/**
 * @author zhaopeng
 * @create 2020-05-06 22:34
 */
public class  MyQueue1 implements FatherQueue{
   private List<Integer> datas;
   private int p_index;
   public MyQueue1(){
       datas=new ArrayList<Integer>();
       p_index=0;
   }

    @Override
    public boolean enQueue(int x) {
        datas.add(x);
        return true;
    }

    @Override
    public Integer deQueue() {
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        Integer remove = datas.remove(p_index);
        return remove;
    }

    @Override
    public Integer front() {
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return datas.get(p_index);
    }

    public Integer size(){
       return datas.size();
    }

    @Override
    public boolean isEmpty() {
        return datas.isEmpty();
    }
    //0 1 2 3
    //1 2 3 4
    @Override
    public String toString() {
         StringBuilder sb=new StringBuilder();
         sb.append("[");
         for (Integer data : datas) {
             sb.append(data+",");
         }
         sb.append("]");
         return sb.toString();
    }

    public static void main(String[] args) {
        MyQueue1 queue=new MyQueue1();
        queue.enQueue(2);
        queue.enQueue(2);
        queue.deQueue();
        queue.deQueue();
        System.err.println(queue);
    }
}
