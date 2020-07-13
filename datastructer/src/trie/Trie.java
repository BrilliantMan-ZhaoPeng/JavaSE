package trie;
/**
 * @author zhaopeng
 * @create 2020-06-13 20:34
 */
public class Trie {
     public static class Node{
         public int pass;
         public int end;
         public Node[] nexts;
         public Node(){
             pass=0;
             end=0;
             nexts=new Node[26];
         }
     }
     private Node root;

     public Trie(){
         root=new Node();
     }

     public void insert(String word){
         if(word==null){
             return;
         }
         Node temp = root;
         char[] chars = word.toCharArray();
         int index=0;
         for (int i = 0; i < chars.length; i++) {
             index=chars[i]-'a';
             Node[] nexts=temp.nexts;
             if(nexts[index]==null){
                 nexts[index]=new Node();
             }
             temp=temp.nexts[index];
             temp.pass++;
         }
         temp.end++;
     }

     //查询word出现的次数
     public int search(String word){
         Node temp=root;
         if(temp==null){
             return 0;
         }
         char[] chars = word.toCharArray();
         for (int i = 0; i < chars.length; i++) {
             //得到next数组下标的值
             Node[] nexts=temp.nexts;
             int index=chars[i]-'a';
             if(nexts[index]==null){
                 return 0;
             }
             temp=nexts[index];
         }
         return temp.end;
     }

     public int prefixNumber(String pre){
         Node temp=root;
         if(pre==null||temp==null){
           return 0;
         }
         char[] chars = pre.toCharArray();
         for (int i = 0; i <chars.length ; i++) {
             int index=chars[i]-'a';
             Node[] nexts=temp.nexts;
             if(nexts[index]==null){
                 return 0;
             }
             temp=nexts[index];
         }
         return temp.pass;
     }


     public boolean remove(String word){
         Node temp=root;
         if(word==null||temp==null){
             return false;
         }
         int count = search(word);
         if(count==0){
             return false;
         }
         char[] chars = word.toCharArray();
         int index=0;
         for (int i = 0; i < chars.length ; i++) {
             index=chars[i]-'a';
             Node[] nexts=temp.nexts;
             temp.pass--;
             temp=nexts[index];
         }
         temp.end--;
         if(temp.pass==0){
             temp=null;
         }
         return true;
     }

    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.insert("ab");
        trie.insert("ac");
        trie.insert("ac");
        trie.insert("acdd");
        System.err.println(trie.remove("ac"));
        System.err.println(trie.search("acdd"));
    }
}
