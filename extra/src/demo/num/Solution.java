package demo.num;

import sun.swing.SwingUtilities2;

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

    /**
     * 作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
     *
     * 1. 你设计的矩形页面必须等于给定的目标面积。
     *
     * 2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
     *
     * 3. 长度 L 和宽度 W 之间的差距应当尽可能小。
     * 你需要按顺序输出你设计的页面的长度 L 和宽度 W。
     *
     * 示例：
     *
     * 输入: 4
     * 输出: [2, 2]
     * 解释: 目标面积是 4， 所有可能的构造方案有 [1,4], [2,2], [4,1]。
     * 但是根据要求2，[1,4] 不符合要求; 根据要求3，[2,2] 比 [4,1] 更能符合要求. 所以输出长度 L 为 2， 宽度 W 为 2。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-the-rectangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //法一.时间超出限制
    public int[] constructRectangle(int area) {
        int L=area;
        int W=1;
        for (int i = 1; i <= area; i++) {
            for (int j = 1; j <=area ; j++) {
                if(i*j == area){
                    if( i >= j  && (L-W) > (i-j) ) {
                            L=i;
                            W=j;
                    }
                }
            }
        }
        int[] res={L,W};
        return res;
    }


    public int[] constructRectangle1(int area) {
        for (int i = 1; i <= area; i++) {
            int a=area/i;
            if(area % a == 0){

            }
            System.err.println(a+"--"+i);
        }
        return null;
    }



    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] ints = solution.constructRectangle1(4);
    }
}
