package demo.num;

import java.sql.SQLSyntaxErrorException;

/**
 * @author zhaopeng
 * @create 2020-06-30 22:49
 */
public class Solution {
    /**
     * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
     * 示例:
     * 输入: a = 2, b = 3
     *   10
     *   11
     *
     *  101
     *
     *  011 3
     *  111 7
     *  100
     *
     *  100
     *
     *  101
     * 输出: 2
     */
    public int add(int a, int b) {
        return a+b;
    }


    /**
     * 现给定任意正整数 n，请寻找并输出最小的正整数 m（m>9），使得 m 的各位（个位、十位、百位 ... ...）之乘积等于n，
     * 若不存在则输出 -1。
     *
     * 36  --> 49  4*9=36
     */

    public int solution (int n) {
        if(n<9){
            return n;
        }
        int res=0;
        int height=1;
        for (int i = 9; i > 1 ; i--) {
           if( n % i == 0 ){
               n /= i;
               res += (height*i);
               height *= 10;
               i=9;//恢复原样
           }
        }
        if(n != 1){
            return -1;
        }
        return res;
    }
    //得到一个数的乘积


    /**
     * 在vivo产线上，每位职工随着对手机加工流程认识的熟悉和经验的增加，日产量也会不断攀升。
     * 假设第一天量产1台，接下来2天(即第二、三天)每天量产2件，接下来3天(即第四、五、六天)每天量产3件 ... ...
     * 1 2 2 3 3 3 4 4 4 4 5 5 5 5 5
     * 以此类推，请编程计算出第n天总共可以量产的手机数量。
     */

    public int solutions (int n) {

        if(n == 1){
           return 1;
        }
        if(n == 2){
            return 3;
        }

        // write code here
        int days=1;
        int res=0;
        int count=0;
        while( days != n ){
            for (int i = 1; i <= days ; i++) {
                count++;
                res += days;
                if(count == n){
                     return res;
                }
            }
            days++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int solution1 = solution.solutions(1);
        System.err.println(solution1);
    }
}
