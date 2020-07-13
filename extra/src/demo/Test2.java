package demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaopeng
 * @create 2020-06-28 18:31
 */
public class Test2 {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int i = 1; i <= 10; i++) {
            if(i==4){
               map.put(i,45);
            }else{
                map.put(i,50);
            }
        }
        int index=1;
        int left=0;
        int right=0;
        while(index<10){
            left+=map.get(index);
            right+=map.get(index+1);
            //System.err.println("left:"+left)
            // System.err.println("right:"+right);
            if (left<right) {
                System.err.println(index);
                break;
            }else if(left>right){
                System.err.println(index+1);
                break;
            }
            index+=2;
        }

    }


}
