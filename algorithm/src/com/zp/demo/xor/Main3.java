package com.zp.demo.xor;

/**
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * @author zhaopeng
 * @create 2020-06-21 9:38
 */

public class Main3 {
    public static void main(String[] args) {
        String str="Let's take LeetCode contest";
        String reverse = reverse(str);
        System.err.println(reverse);
    }

    //方式一:
    public static String reverse(String str){
        String[] split = str.trim().split("\\s");
        StringBuilder sb=new StringBuilder();
        for (String s : split) {
            StringBuilder temp=new StringBuilder(s);
            sb.append(temp.reverse()+" ");
        }
        return sb.toString().trim();
    }
}
