package binarytree;
/**
 * 对折纸条的问题
 * @author zhaopeng
 * @create 2020-06-21 20:42
 */
public class Solution {
    public static void main(String[] args) {
        print(1,3,'凹');
    }

    //N是需要打印对折的次数,i是当前打印节点的层数,flag   false是凹，true是凸   记得是左凸右凹
    public static void print(int i,int N,char c){
        if(i>N){
           return ;
        }
        //先来左边的
        print(i+1,N,'凸');
        //中间的操作
        System.err.println(c);
        print(i+1,N,'凹');
        //右边的
    }
}
