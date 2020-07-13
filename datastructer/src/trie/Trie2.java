package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaopeng
 * @create 2020-06-14 18:17
 */

public class Trie2 {

    private Node2 root;

    public Trie2(){
       root=new Node2();
    }

    public void insert(String word){
        if(word==null||word.trim().isEmpty()){
            return;
        }
        Node2 temp=root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character ch=chars[i];
            Map nexts=temp.nexts;
            //说明没有当前的分支
            if(nexts.get(ch)==null){
                nexts.put(ch,new Node2());
            }
            temp=(Node2)nexts.get(ch);
            temp.pass++;
        }
        temp.end++;
    }


    public int search(String word){
        Node2 temp=root;
        if(word==null||word.trim().isEmpty()||temp==null){
            return 0;
        }
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character ch=chars[i];
            Map nexts=temp.nexts;
            if(nexts.get(ch)==null){
                return 0;
            }
            temp=(Node2)nexts.get(ch);
        }
        return temp.end;
    }


    public int prefixNumber(String word){
        Node2 temp=root;

        if(word==null||word.trim().isEmpty()||temp==null){
            return 0;
        }

        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            Character ch=chars[i];
            Map nexts=temp.nexts;
            if(nexts.get(ch)==null){
                return 0;
            }
            temp=(Node2)nexts.get(ch);
        }
        return temp.pass;
    }


    public static void main(String[] args) {
        Trie2 trie2=new Trie2();
        trie2.insert("ab");
        trie2.insert("abc");
        trie2.insert("123");
        System.err.println(trie2.prefixNumber("ab"));
    }


    class Node2{
        public int pass;
        public int end;
        public Map<Character,Node2> nexts;
        Node2(){
            pass=0;
            end=0;
            nexts=new HashMap<Character, Node2>();
        }
    }
}
