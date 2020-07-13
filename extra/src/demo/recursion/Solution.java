package demo.recursion;
import java.util.Set;
/**
 * @author zhaopeng
 * @create 2020-07-02 19:00
 */

public class Solution {
    public static class Info{
        private int num;
        public Info(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }

    //如何递归打印一个字符串的所有子序列
    public static void getSubsequence(char[] str,int index,String res){
        if(index==str.length){
            System.err.println(res);
            return ;
        }

        //走需要当前字符的路径符的路径
        getSubsequence(str,index+1,res+String.valueOf(str[index]));

        //走不需要当前字
        getSubsequence(str,index+1,res);
    }



    //如何递归打印一个字符串的所有子序列,要求不要出现重复字面值的子序列
    public static void getUnrepeatedSubsequence(char[] str, int index, String res, Set<String> set){
        if(index==str.length){
            if(!set.contains(res)){
                set.add(res);
            }
            return ;
        }
        //走需要当前字符的路径符的路径
        getUnrepeatedSubsequence(str,index+1,res+String.valueOf(str[index]),set);
        //走不需要当前字
        getUnrepeatedSubsequence(str,index+1,res,set);
    }


    //如何递归得到一个字符串的所有子序列,要求不要出现重复字面值的子序列的---->个数
    public static void  getUnrepeatedSubsequenceCount(char[] str, int index, String res, Set<String> set,Info info){
        if(index==str.length){
            if(!set.contains(res)){
                set.add(res);
                info.setNum(info.getNum()+1);
            }
            return ;
        }
        //走需要当前字符的路径符的路径
        getUnrepeatedSubsequenceCount(str,index+1,res+String.valueOf(str[index]),set,info);
        //走不需要当前字
        getUnrepeatedSubsequenceCount(str,index+1,res,set,info);
    }


    /*
     * N皇后问题
     *
     *
     * n表示一共有多少行
     * record 记录答案
     */
    public int getHuanghou(int N){
        int[] record=new int[N];
        return process(0,record,N);
    }

    public int process(int i,int[] record,int n){
        if(i==n){
            return 1;
        }
        int res=0;
        //没有到终止位置，还有皇后要摆
        for (int j = 0; j < n; j++) {
            //判断i,j行能不能摆
            if(isValid(record,i,j)){
                record[i]=j;
                res+=process(i+1,record,n);
            }
        }
        return res;
    }

    public boolean isValid(int[] record,int i,int j){
        for (int k = 0; k < i; k++) {
            if(j==record[k]||Math.abs(record[k]-j)==Math.abs(i-k)){
                 return false;
            }
        }
        return true;
    }


    /**
     * 求斐波拉契数列的第N项的值是啥
     * 1 1 2 3 5 8 13......
     */

    public int f(int N){
        if(N==1||N==2){
            return 1;
        }
        int res=f(N-1)+f(N-2);
        return res;
    }


    public static void main(String[] args) {
        Solution solution=new Solution();
        int f = solution.f(6);
        System.err.println(f);
    }
}
