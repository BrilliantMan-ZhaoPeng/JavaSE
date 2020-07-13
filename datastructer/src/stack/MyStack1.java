package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaopeng
 * @create 2020-05-13 16:01
 */
public class MyStack1 {
   private List<Integer> datas;
   public MyStack1(){
       datas=new ArrayList<>();
   }

   public void push(int data){
      datas.add(data);
   }

   public boolean isEmpty(){
       return datas.isEmpty();
   }

   public boolean pop(){
       if(isEmpty()){
           throw new RuntimeException("不能为空");
       }
       datas.remove(datas.size()-1);
       return true;
   }

    public int top(){
       if(isEmpty()){
           throw new RuntimeException("不能为空");
       }
       return datas.get(datas.size()-1);
    }

    @Override
    public String toString() {
       StringBuilder sb=new StringBuilder();
        sb.append("[");
        for (Integer data : datas) {
           sb.append(data+",");
        }
        int index=sb.lastIndexOf(",");
        if(index>0){
             sb.replace(index,index+1,"");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyStack1 stack=new MyStack1();
        stack.push(1);
        stack.pop();
        System.err.println(stack);
    }
}
