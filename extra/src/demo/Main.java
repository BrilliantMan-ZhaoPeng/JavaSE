package demo;

import com.sun.deploy.panel.ITreeNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author zhaopeng
 * @create 2020-06-13 10:23
 */

public interface Main {
    public static void main(String[] args)  {
        int[] a={1,2,12,33,123,-1};
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                Integer abs=Math.abs(a[i])-Math.abs(a[j]);
                Integer key=Math.abs(abs);
                if(map.containsKey(key)){
                    int aa=map.get(key);
                    map.put(key,++aa);
                }else{
                    map.put(key,1);
                }
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            System.err.println(next.getKey()+":"+next.getValue());
        }
    }
}
