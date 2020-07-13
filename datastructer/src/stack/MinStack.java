package stack;
import java.util.ArrayList;
import java.util.List;
/**
 * 每次pop出栈中最小的值,但是呢？复杂度为O(n)
 *
 * @author zhaopeng
 * @create 2020-05-13 18:56
 */
public class MinStack {

    private List<Integer> datas;

    public MinStack() {
        datas=new ArrayList<>();
    }


    public void push(int x) {
        datas.add(x);
    }

    public void pop() {
         if(datas.isEmpty()){
            throw new RuntimeException("empty....");
         }
         datas.remove(datas.size()-1);
    }

    public int top() {
        if(datas.isEmpty()){
            throw new RuntimeException("empty....");
        }
        return datas.get(datas.size()-1);
    }

    public int getMin() {
        if(datas.isEmpty()){
            throw new RuntimeException("empty....");
        }
        int min=datas.get(0);
        for (int i = 1; i <datas.size() ; i++) {
            Integer integer = datas.get(i);
            if(min>integer){
                min=integer;
            }
        }
        return min;
    }

    public boolean isEmpty(){
        return datas.isEmpty();
    }


    public static void main(String[] args) {
        MinStack stack=new MinStack();
        stack.push(9);
        stack.push(2);
        stack.push(3);
        int min = stack.getMin();
        System.err.println(min);
    }
}



