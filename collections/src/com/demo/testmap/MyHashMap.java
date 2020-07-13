package com.demo.testmap;
/**
 * @author zhaopeng
 * @create 2020-06-11 21:07
 */
public class MyHashMap <K,V>implements MyMap<K,V>{
    Entry<K,V> table[]=null;
    int size=0;
    public int hash(K k){
       return Math.abs(k.hashCode()%16);
    }
    public MyHashMap(){
        table=new Entry[16];
    }
    @Override
    public V put(K k, V v) {
        int index=hash(k);
        Entry entry=table[index];
        if(null==entry){
            table[index]=new Entry<>(k,v,index,null);
            size++;
        }else{
            Entry<K, V> entry1 = findEntry(k);
            if(entry1==null){
                table[index]=new Entry<>(k,v,index,entry);
                size++;
            }else{
                entry1.v=v;
            }
        }
        return v;
    }

    @Override
    public V get(K k) {
        Entry<K, V> entry = findEntry(k);
        return entry==null?null:entry.getValue();
    }

    public Entry<K,V> findEntry(K k){
        int index=hash(k);
        Entry entry=table[index];
        if(entry==null){
            return null;
        }else{
            while(entry!=null){
                if(entry.getKey().equals(k)){//表示找到了
                    return entry;
                }
                entry=entry.next;
            }
        }
        return null;
    }


    @Override
    public int size() {
        return size;
    }


    //相当于就是一个节点
    class Entry<K,V> implements MyMap.Entry<K,V>{
        K k;//当前的key
        V v;//当前的value
        int hash;//hash值
        Entry<K,V> next;//

        Entry(K k,V v,int hash,Entry next){
             this.k=k;
             this.v=v;
             this.hash=hash;
             this.next=next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String,String> map=new MyHashMap<String,String>();
        map.put("zhangsan","123");
        map.put("zhangsan1","1234");
        map.put("zhangsan2","1235");
        map.put("zhangsan3","1236");
        map.put("zhangsan3","12367");
        System.err.println(map.size);
        System.err.println(map.get("zhangsan3"));
    }
}
