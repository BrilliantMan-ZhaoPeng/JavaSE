package com.zp.demo.xor;
import java.time.temporal.ValueRange;
import java.util.Stack;
/**
 * 字符串的反转
 *
 * For example,
 * Given s = “the sky is blue”,
 * return “blue is sky the”.
 * @author zhaopeng
 * @create 2020-05-31 14:18
 */
public class Main2 {
    public static void main(String[] args) {
        String str="the sky is blue";
        String reverse = reverse1(str);
        System.err.println(reverse);
    }

    //方法一：
    public static String reverse(String str){
        Stack<String> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        String[] split = str.trim().split("\\s");
        for (int i = 0; i < split.length; i++) {
           stack.push(split[i]);
        }
        while(!stack.isEmpty()){
           sb.append(stack.pop());
           sb.append(" ");
        }
        return sb.toString().trim();
    }

    //方法二：
    public static String reverse1(String str){
        String[] split = str.trim().split("\\s");
        StringBuilder sb=new StringBuilder();
        for (int i = split.length-1; i >=0 ; i--) {
            sb.append(split[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
